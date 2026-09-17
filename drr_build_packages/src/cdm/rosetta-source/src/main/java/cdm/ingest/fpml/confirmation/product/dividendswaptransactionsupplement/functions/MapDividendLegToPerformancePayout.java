package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapFxFeature;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapOptionSettlementModelToSettlementTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendLegToPerformancePayout.MapDividendLegToPerformancePayoutDefault.class)
public abstract class MapDividendLegToPerformancePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxFeature mapFxFeature;
	@Inject protected MapOptionSettlementModelToSettlementTerms mapOptionSettlementModelToSettlementTerms;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapSwapTransactionSupplementDividendReturnTerms mapSwapTransactionSupplementDividendReturnTerms;
	@Inject protected MapUnderlyerToObservableWithAddress mapUnderlyerToObservableWithAddress;

	/**
	* @param fpmlDividendLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlDividendLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendLegToPerformancePayoutDefault extends MapDividendLegToPerformancePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlDividendLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setPerformancePayout(PerformancePayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlDividendLeg).<PartyReference>map("getPayerPartyReference", dividendLeg -> dividendLeg.getPayerPartyReference()).get(), MapperS.of(fpmlDividendLeg).<PartyReference>map("getReceiverPartyReference", dividendLeg -> dividendLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPaymentDates(null)
					.setValuationDates(null)
					.setSettlementTerms(mapOptionSettlementModelToSettlementTerms.evaluate(MapperS.of(fpmlDividendLeg).<SettlementTypeEnum>map("getSettlementType", dividendLeg -> dividendLeg.getSettlementType()).get(), MapperS.of(fpmlDividendLeg).<Currency>map("getSettlementCurrency", dividendLeg -> dividendLeg.getSettlementCurrency()).get(), MapperS.of(fpmlDividendLeg).<AdjustableOrRelativeDate>map("getSettlementDate", dividendLeg -> dividendLeg.getSettlementDate()).get()))
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlDividendLeg).<Underlyer>map("getUnderlyer", dividendLeg -> dividendLeg.getUnderlyer()).get()))
						.build())
					.setFxFeature(MapperS.of(fpmlDividendLeg).<FxFeature>map("getFxFeature", dividendLeg -> dividendLeg.getFxFeature())
						.mapSingleToItem(item -> MapperS.of(mapFxFeature.evaluate(item.get()))).getMulti())
					.setReturnTerms(ReturnTerms.builder()
						.setDividendReturnTerms(mapSwapTransactionSupplementDividendReturnTerms.evaluate(fpmlDividendLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
