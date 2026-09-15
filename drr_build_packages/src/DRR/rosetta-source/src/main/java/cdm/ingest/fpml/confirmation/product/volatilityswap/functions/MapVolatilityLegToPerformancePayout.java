package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapAdjustableOrRelativeDateToObservationTerms;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPerformanceValuationDates;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithAddress;
import cdm.observable.asset.ValuationDates;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.volatility.swaps.VolatilityAmount;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilityLegToPerformancePayout.MapVolatilityLegToPerformancePayoutDefault.class)
public abstract class MapVolatilityLegToPerformancePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDateToObservationTerms mapAdjustableOrRelativeDateToObservationTerms;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPerformanceValuationDates mapPerformanceValuationDates;
	@Inject protected MapUnderlyerToObservableWithAddress mapUnderlyerToObservableWithAddress;
	@Inject protected MapVolatilitySwapReturnTerms mapVolatilitySwapReturnTerms;
	@Inject protected MapVolatilitySwapToResolvablePriceQuantity mapVolatilitySwapToResolvablePriceQuantity;

	/**
	* @param fpmlVolatilityLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(VolatilityLeg fpmlVolatilityLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlVolatilityLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVolatilityLegToPerformancePayoutDefault extends MapVolatilityLegToPerformancePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlVolatilityLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, VolatilityLeg fpmlVolatilityLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setPerformancePayout(PerformancePayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlVolatilityLeg).<PartyReference>map("getPayerPartyReference", volatilityLeg -> volatilityLeg.getPayerPartyReference()).get(), MapperS.of(fpmlVolatilityLeg).<PartyReference>map("getReceiverPartyReference", volatilityLeg -> volatilityLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlVolatilityLeg).<Underlyer>map("getUnderlyer", volatilityLeg -> volatilityLeg.getUnderlyer()).get()))
						.build())
					.setPriceQuantity(mapVolatilitySwapToResolvablePriceQuantity.evaluate(fpmlVolatilityLeg))
					.setSettlementTerms(SettlementTerms.builder()
						.setSettlementCurrency(mapCurrency.evaluate(MapperS.of(fpmlVolatilityLeg).<Currency>map("getSettlementCurrency", volatilityLeg -> volatilityLeg.getSettlementCurrency()).get()))
						.setSettlementType(null)
						.build())
					.setObservationTerms(mapAdjustableOrRelativeDateToObservationTerms.evaluate(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<AdjustableOrRelativeDate>map("getObservationStartDate", volatilityAmount -> volatilityAmount.getObservationStartDate()).get()))
					.setValuationDates(ValuationDates.builder()
						.setFinalValuationDate(mapPerformanceValuationDates.evaluate(null, MapperS.of(fpmlVolatilityLeg).<EquityValuation>map("getValuation", volatilityLeg -> volatilityLeg.getValuation()).get()))
						.build())
					.setReturnTerms(mapVolatilitySwapReturnTerms.evaluate(fpmlVolatilityLeg))
					.setPaymentDates(null)
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
