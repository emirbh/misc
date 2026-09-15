package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyRoleEnum;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountWithIdToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapQuotedCurrencyPairToObservableWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapFxPerformanceSwapToSettlementTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxPerformanceFixedLeg;
import fpml.consolidated.fx.FxPerformanceFloatingLeg;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.fx.FxValuationDateOffset;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxVarianceSwapPayout.MapFxVarianceSwapPayoutDefault.class)
public abstract class MapFxVarianceSwapPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;
	@Inject protected MapFxPerformanceSwapToObservationTerms mapFxPerformanceSwapToObservationTerms;
	@Inject protected MapFxPerformanceSwapToSettlementTerms mapFxPerformanceSwapToSettlementTerms;
	@Inject protected MapFxValuationDateOffsetToValuationDates mapFxValuationDateOffsetToValuationDates;
	@Inject protected MapNotionalAmountWithIdToQuantityWithAddress mapNotionalAmountWithIdToQuantityWithAddress;
	@Inject protected MapQuotedCurrencyPairToObservableWithAddress mapQuotedCurrencyPairToObservableWithAddress;

	/**
	* @param fpmlFxVarianceSwap 
	* @param returnTerms 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(FxPerformanceSwap fpmlFxVarianceSwap, ReturnTerms returnTerms, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFxVarianceSwap, returnTerms, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(FxPerformanceSwap fpmlFxVarianceSwap, ReturnTerms returnTerms, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxVarianceSwapPayoutDefault extends MapFxVarianceSwapPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(FxPerformanceSwap fpmlFxVarianceSwap, ReturnTerms returnTerms, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFxVarianceSwap, returnTerms, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, FxPerformanceSwap fpmlFxVarianceSwap, ReturnTerms returnTerms, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setPerformancePayout(PerformancePayout.builder()
					.setPayerReceiver(PayerReceiver.builder()
						.setPayer(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlFxVarianceSwap).<FxPerformanceFloatingLeg>map("getFloatingLeg", fxPerformanceSwap -> fxPerformanceSwap.getFloatingLeg()).<PartyReference>map("getPayerPartyReference", fxPerformanceFloatingLeg -> fxPerformanceFloatingLeg.getPayerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
						.setReceiver(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlFxVarianceSwap).<FxPerformanceFixedLeg>map("getFixedLeg", fxPerformanceSwap -> fxPerformanceSwap.getFixedLeg()).<PartyReference>map("getPayerPartyReference", fxPerformanceFixedLeg -> fxPerformanceFixedLeg.getPayerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
						.build())
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapNotionalAmountWithIdToQuantityWithAddress.evaluate(MapperS.of(fpmlFxVarianceSwap).<NonNegativeMoney>map("getNotional", fxPerformanceSwap -> fxPerformanceSwap.getNotional()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), "notional", null))
						.build())
					.setSettlementTerms(mapFxPerformanceSwapToSettlementTerms.evaluate(fpmlFxVarianceSwap))
					.setObservationTerms(mapFxPerformanceSwapToObservationTerms.evaluate(fpmlFxVarianceSwap))
					.setValuationDates(mapFxValuationDateOffsetToValuationDates.evaluate(MapperS.of(fpmlFxVarianceSwap).<FxValuationDateOffset>map("getValuationDateOffset", fxPerformanceSwap -> fxPerformanceSwap.getValuationDateOffset()).get()))
					.setPaymentDates(null)
					.setUnderlier(Underlier.builder()
						.setObservable(mapQuotedCurrencyPairToObservableWithAddress.evaluate(MapperS.of(fpmlFxVarianceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxPerformanceSwap -> fxPerformanceSwap.getQuotedCurrencyPair()).get()))
						.build())
					.setReturnTerms(returnTerms)
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
