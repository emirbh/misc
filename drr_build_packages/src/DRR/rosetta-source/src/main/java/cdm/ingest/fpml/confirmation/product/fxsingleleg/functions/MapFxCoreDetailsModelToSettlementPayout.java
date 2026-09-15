package cdm.ingest.fpml.confirmation.product.fxsingleleg.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.GetFpmlExchangedCurrency;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCurrencyToObservableCashWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxCoreDetailsModelPriceWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxCoreDetailsModelQuantityWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapFxCashSettlementToSettlementTerms;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxCoreDetailsModelToSettlementPayout.MapFxCoreDetailsModelToSettlementPayoutDefault.class)
public abstract class MapFxCoreDetailsModelToSettlementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlExchangedCurrency getFpmlExchangedCurrency;
	@Inject protected MapCurrencyToObservableCashWithAddress mapCurrencyToObservableCashWithAddress;
	@Inject protected MapFxCashSettlementToSettlementTerms mapFxCashSettlementToSettlementTerms;
	@Inject protected MapFxCoreDetailsModelPriceWithAddress mapFxCoreDetailsModelPriceWithAddress;
	@Inject protected MapFxCoreDetailsModelQuantityWithAddress mapFxCoreDetailsModelQuantityWithAddress;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlExchangeRate 
	* @param fpmlExchangedCurrency1 
	* @param fpmlExchangedCurrency2 
	* @param fpmlNonDeliverableSettlement 
	* @param valueDate 
	* @param fpmlLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, FxCashSettlement fpmlNonDeliverableSettlement, ZonedDateTime valueDate, Leg fpmlLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlNonDeliverableSettlement, valueDate, fpmlLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, FxCashSettlement fpmlNonDeliverableSettlement, ZonedDateTime valueDate, Leg fpmlLeg, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Payment> exchangedCurrency(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, FxCashSettlement fpmlNonDeliverableSettlement, ZonedDateTime valueDate, Leg fpmlLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxCoreDetailsModelToSettlementPayoutDefault extends MapFxCoreDetailsModelToSettlementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, FxCashSettlement fpmlNonDeliverableSettlement, ZonedDateTime valueDate, Leg fpmlLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlNonDeliverableSettlement, valueDate, fpmlLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, FxCashSettlement fpmlNonDeliverableSettlement, ZonedDateTime valueDate, Leg fpmlLeg, List<? extends Counterparty> cdmCounterpartyList) {
			final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule = mapFxCoreDetailsModelPriceWithAddress.evaluate(fpmlExchangeRate, fpmlLeg);
			payout = toBuilder(Payout.builder()
				.setSettlementPayout(SettlementPayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(exchangedCurrency(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlNonDeliverableSettlement, valueDate, fpmlLeg, cdmCounterpartyList).<PartyReference>map("getPayerPartyReference", payment -> payment.getPayerPartyReference()).get(), exchangedCurrency(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlNonDeliverableSettlement, valueDate, fpmlLeg, cdmCounterpartyList).<PartyReference>map("getReceiverPartyReference", payment -> payment.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapFxCoreDetailsModelQuantityWithAddress.evaluate(fpmlExchangeRate, fpmlLeg))
						.setPriceSchedule((referenceWithMetaPriceSchedule == null ? Collections.<ReferenceWithMetaPriceSchedule>emptyList() : Collections.singletonList(referenceWithMetaPriceSchedule)))
						.build())
					.setSettlementTerms(mapFxCashSettlementToSettlementTerms.evaluate(fpmlNonDeliverableSettlement, MapperS.of(valueDate).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get()))
					.setUnderlier(Underlier.builder()
						.setObservable(mapCurrencyToObservableCashWithAddress.evaluate(exchangedCurrency(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlNonDeliverableSettlement, valueDate, fpmlLeg, cdmCounterpartyList).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), fpmlLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Payment> exchangedCurrency(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, FxCashSettlement fpmlNonDeliverableSettlement, ZonedDateTime valueDate, Leg fpmlLeg, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(getFpmlExchangedCurrency.evaluate(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2));
		}
	}
}
