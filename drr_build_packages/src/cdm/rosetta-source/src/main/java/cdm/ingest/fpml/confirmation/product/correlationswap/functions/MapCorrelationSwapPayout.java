package cdm.ingest.fpml.confirmation.product.correlationswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.common.functions.MapAdjustableOrRelativeDateToObservationTerms;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPerformanceValuationDates;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyRoleEnum;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNonNegativeMoneyToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCorrelationLegToSettlementTerms;
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
import fpml.consolidated.correlation.swaps.CorrelationAmount;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.eq.shared.Correlation;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationSwapPayout.MapCorrelationSwapPayoutDefault.class)
public abstract class MapCorrelationSwapPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDateToObservationTerms mapAdjustableOrRelativeDateToObservationTerms;
	@Inject protected MapCorrelationLegToCorrelationReturnTerms mapCorrelationLegToCorrelationReturnTerms;
	@Inject protected MapCorrelationLegToSettlementTerms mapCorrelationLegToSettlementTerms;
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;
	@Inject protected MapNonNegativeMoneyToQuantityWithAddress mapNonNegativeMoneyToQuantityWithAddress;
	@Inject protected MapPerformanceValuationDates mapPerformanceValuationDates;
	@Inject protected MapUnderlyerToObservableWithAddress mapUnderlyerToObservableWithAddress;

	/**
	* @param fpmlCorrelationSwap 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlCorrelationSwap, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends CorrelationLeg> correlationLeg(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCorrelationSwapPayoutDefault extends MapCorrelationSwapPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlCorrelationSwap, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setPerformancePayout(PerformancePayout.builder()
					.setPayerReceiver(PayerReceiver.builder()
						.setPayer(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<PartyReference>map("getPayerPartyReference", _correlationLeg -> _correlationLeg.getPayerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
						.setReceiver(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<PartyReference>map("getReceiverPartyReference", _correlationLeg -> _correlationLeg.getReceiverPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
						.build())
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapNonNegativeMoneyToQuantityWithAddress.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<CorrelationAmount>map("getAmount", _correlationLeg -> _correlationLeg.getAmount()).<Correlation>map("getCorrelation", correlationAmount -> correlationAmount.getCorrelation()).<NonNegativeMoney>map("getNotionalAmount", correlation -> correlation.getNotionalAmount()).get(), null, correlationLeg(fpmlCorrelationSwap, cdmCounterpartyList).get()))
						.build())
					.setSettlementTerms(mapCorrelationLegToSettlementTerms.evaluate(correlationLeg(fpmlCorrelationSwap, cdmCounterpartyList).get()))
					.setObservationTerms(mapAdjustableOrRelativeDateToObservationTerms.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<CorrelationAmount>map("getAmount", _correlationLeg -> _correlationLeg.getAmount()).<AdjustableOrRelativeDate>map("getObservationStartDate", correlationAmount -> correlationAmount.getObservationStartDate()).get()))
					.setValuationDates(ValuationDates.builder()
						.setFinalValuationDate(mapPerformanceValuationDates.evaluate(null, MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<EquityValuation>map("getValuation", _correlationLeg -> _correlationLeg.getValuation()).get()))
						.build())
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<Underlyer>map("getUnderlyer", _correlationLeg -> _correlationLeg.getUnderlyer()).get()))
						.build())
					.setReturnTerms(ReturnTerms.builder()
						.setCorrelationReturnTerms(mapCorrelationLegToCorrelationReturnTerms.evaluate(correlationLeg(fpmlCorrelationSwap, cdmCounterpartyList).get()))
						.build())
					.setPaymentDates(null)
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CorrelationLeg> correlationLeg(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg());
		}
	}
}
