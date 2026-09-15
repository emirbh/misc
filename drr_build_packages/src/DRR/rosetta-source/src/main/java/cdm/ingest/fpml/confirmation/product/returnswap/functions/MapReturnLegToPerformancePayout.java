package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapFxFeature;
import cdm.ingest.fpml.confirmation.other.functions.MapReturnTypeEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapReturnSwapLegToSettlementTerms;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.DividendPayout;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.Return;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnLegValuation;
import fpml.consolidated.eq.shared.ReturnLegValuationPrice;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.eq.shared.ReturnSwapPaymentDates;
import fpml.consolidated.fpmlenum.ReturnTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReturnLegToPerformancePayout.MapReturnLegToPerformancePayoutDefault.class)
public abstract class MapReturnLegToPerformancePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxFeature mapFxFeature;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPaymentDateSchedule mapPaymentDateSchedule;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapReturnLegValuationToValuationDates mapReturnLegValuationToValuationDates;
	@Inject protected MapReturnSwapDividendReturnTerms mapReturnSwapDividendReturnTerms;
	@Inject protected MapReturnSwapLegToSettlementTerms mapReturnSwapLegToSettlementTerms;
	@Inject protected MapReturnTypeEnum mapReturnTypeEnum;
	@Inject protected MapUnderlyerToObservableWithAddress mapUnderlyerToObservableWithAddress;

	/**
	* @param fpmlReturnLeg 
	* @param cdmCounterpartyList 
	* @param fpmlInterestLeg 
	* @return payout 
	*/
	public Payout evaluate(ReturnLeg fpmlReturnLeg, List<? extends Counterparty> cdmCounterpartyList, InterestLeg fpmlInterestLeg) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlReturnLeg, cdmCounterpartyList, fpmlInterestLeg);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(ReturnLeg fpmlReturnLeg, List<? extends Counterparty> cdmCounterpartyList, InterestLeg fpmlInterestLeg);

	public static class MapReturnLegToPerformancePayoutDefault extends MapReturnLegToPerformancePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(ReturnLeg fpmlReturnLeg, List<? extends Counterparty> cdmCounterpartyList, InterestLeg fpmlInterestLeg) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlReturnLeg, cdmCounterpartyList, fpmlInterestLeg);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, ReturnLeg fpmlReturnLeg, List<? extends Counterparty> cdmCounterpartyList, InterestLeg fpmlInterestLeg) {
			payout = toBuilder(Payout.builder()
				.setPerformancePayout(PerformancePayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlReturnLeg).<PartyReference>map("getPayerPartyReference", returnLeg -> returnLeg.getPayerPartyReference()).get(), MapperS.of(fpmlReturnLeg).<PartyReference>map("getReceiverPartyReference", returnLeg -> returnLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPaymentDates(PaymentDates.builder()
						.setPaymentDateSchedule(mapPaymentDateSchedule.evaluate(MapperS.of(fpmlReturnLeg).<ReturnLegValuation>map("getRateOfReturn", returnLeg -> returnLeg.getRateOfReturn()).<ReturnSwapPaymentDates>map("getPaymentDates", returnLegValuation -> returnLegValuation.getPaymentDates()).get()))
						.build())
					.setValuationDates(mapReturnLegValuationToValuationDates.evaluate(MapperS.of(fpmlReturnLeg).<ReturnLegValuation>map("getRateOfReturn", returnLeg -> returnLeg.getRateOfReturn()).get()))
					.setPriceQuantity(mapResolvablePriceQuantity.evaluate(MapperS.of(fpmlReturnLeg).<ReturnSwapNotional>map("getNotional", returnLeg -> returnLeg.getNotional()).get(), MapperS.of(fpmlReturnLeg).<ReturnLegValuation>map("getRateOfReturn", returnLeg -> returnLeg.getRateOfReturn()).<Boolean>map("getNotionalReset", returnLegValuation -> returnLegValuation.getNotionalReset()).get(), fpmlReturnLeg, MapperS.of(fpmlInterestLeg).<ReturnSwapNotional>map("getNotional", interestLeg -> interestLeg.getNotional()).get(), fpmlInterestLeg))
					.setSettlementTerms(mapReturnSwapLegToSettlementTerms.evaluate(fpmlReturnLeg))
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlReturnLeg).<Underlyer>map("getUnderlyer", returnLeg -> returnLeg.getUnderlyer()).get()))
						.build())
					.setFxFeature(MapperS.of(fpmlReturnLeg).<FxFeature>map("getFxFeature", returnLeg -> returnLeg.getFxFeature())
						.mapSingleToItem(item -> MapperS.of(mapFxFeature.evaluate(item.get()))).getMulti())
					.setReturnTerms(ReturnTerms.builder()
						.setPriceReturnTerms(PriceReturnTerms.builder()
							.setReturnType(mapReturnTypeEnum.evaluate(MapperS.of(fpmlReturnLeg).<Return>map("getReturn", returnLeg -> returnLeg.getReturn()).<ReturnTypeEnum>map("getReturnType", _return -> _return.getReturnType()).map("to-string", ReturnTypeEnum::toDisplayString).get()))
							.build())
						.setDividendReturnTerms(mapReturnSwapDividendReturnTerms.evaluate(MapperS.of(fpmlReturnLeg).<Underlyer>map("getUnderlyer", returnLeg -> returnLeg.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<DividendPayout>map("getDividendPayout", singleUnderlyer -> singleUnderlyer.getDividendPayout()).get(), MapperS.of(fpmlReturnLeg).<Return>map("getReturn", returnLeg -> returnLeg.getReturn()).<DividendConditions>map("getDividendConditions", _return -> _return.getDividendConditions()).get(), MapperS.of(fpmlReturnLeg).<ReturnLegValuation>map("getRateOfReturn", returnLeg -> returnLeg.getRateOfReturn()).<ReturnLegValuationPrice>map("getValuationPriceFinal", returnLegValuation -> returnLegValuation.getValuationPriceFinal()).<EquityValuation>map("getValuationRules", returnLegValuationPrice -> returnLegValuationPrice.getValuationRules()).get()))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
