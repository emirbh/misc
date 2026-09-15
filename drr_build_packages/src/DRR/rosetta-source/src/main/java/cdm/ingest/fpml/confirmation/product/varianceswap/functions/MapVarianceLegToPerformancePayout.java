package cdm.ingest.fpml.confirmation.product.varianceswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapAdjustableOrRelativeDateToObservationTerms;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPerformanceValuationDates;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapOptionSettlementModelToSettlementTerms;
import cdm.observable.asset.ValuationDates;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.Variance;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.variance.swaps.VarianceAmount;
import fpml.consolidated.variance.swaps.VarianceLeg;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceLegToPerformancePayout.MapVarianceLegToPerformancePayoutDefault.class)
public abstract class MapVarianceLegToPerformancePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDateToObservationTerms mapAdjustableOrRelativeDateToObservationTerms;
	@Inject protected MapNotionalAmountToQuantityWithAddress mapNotionalAmountToQuantityWithAddress;
	@Inject protected MapOptionSettlementModelToSettlementTerms mapOptionSettlementModelToSettlementTerms;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPerformanceValuationDates mapPerformanceValuationDates;
	@Inject protected MapUnderlyerToObservableWithAddress mapUnderlyerToObservableWithAddress;
	@Inject protected MapVarianceLegToVarianceReturnTerms mapVarianceLegToVarianceReturnTerms;

	/**
	* @param fpmlVarianceLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(VarianceLeg fpmlVarianceLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlVarianceLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(VarianceLeg fpmlVarianceLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVarianceLegToPerformancePayoutDefault extends MapVarianceLegToPerformancePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(VarianceLeg fpmlVarianceLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlVarianceLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, VarianceLeg fpmlVarianceLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setPerformancePayout(PerformancePayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlVarianceLeg).<PartyReference>map("getPayerPartyReference", varianceLeg -> varianceLeg.getPayerPartyReference()).get(), MapperS.of(fpmlVarianceLeg).<PartyReference>map("getReceiverPartyReference", varianceLeg -> varianceLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<NonNegativeMoney>map("getVarianceAmount", variance -> variance.getVarianceAmount()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), fpmlVarianceLeg))
						.build())
					.setSettlementTerms(mapOptionSettlementModelToSettlementTerms.evaluate(MapperS.of(fpmlVarianceLeg).<SettlementTypeEnum>map("getSettlementType", varianceLeg -> varianceLeg.getSettlementType()).get(), MapperS.of(fpmlVarianceLeg).<Currency>map("getSettlementCurrency", varianceLeg -> varianceLeg.getSettlementCurrency()).get(), MapperS.of(fpmlVarianceLeg).<AdjustableOrRelativeDate>map("getSettlementDate", varianceLeg -> varianceLeg.getSettlementDate()).get()))
					.setObservationTerms(mapAdjustableOrRelativeDateToObservationTerms.evaluate(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<AdjustableOrRelativeDate>map("getObservationStartDate", varianceAmount -> varianceAmount.getObservationStartDate()).get()))
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlVarianceLeg).<Underlyer>map("getUnderlyer", varianceLeg -> varianceLeg.getUnderlyer()).get()))
						.build())
					.setValuationDates(ValuationDates.builder()
						.setFinalValuationDate(mapPerformanceValuationDates.evaluate(null, MapperS.of(fpmlVarianceLeg).<EquityValuation>map("getValuation", varianceLeg -> varianceLeg.getValuation()).get()))
						.build())
					.setPaymentDates(null)
					.setReturnTerms(ReturnTerms.builder()
						.setVarianceReturnTerms(mapVarianceLegToVarianceReturnTerms.evaluate(fpmlVarianceLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
