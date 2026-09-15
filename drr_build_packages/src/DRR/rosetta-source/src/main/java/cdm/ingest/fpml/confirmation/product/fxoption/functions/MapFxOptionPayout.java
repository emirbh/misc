package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlFxExercise;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.other.functions.MapPutCallEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCurrencyToObservableCashWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxOptionQuantityWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapFxOptionToSettlementTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxOptionFeatures;
import fpml.consolidated.fx.FxStrikePrice;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxOptionPayout.MapFxOptionPayoutDefault.class)
public abstract class MapFxOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetExchangedCurrencyAmount getExchangedCurrencyAmount;
	@Inject protected GetFpmlFxExercise getFpmlFxExercise;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCurrencyToObservableCashWithAddress mapCurrencyToObservableCashWithAddress;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapFxOptionFeaturesToObservationTerms mapFxOptionFeaturesToObservationTerms;
	@Inject protected MapFxOptionQuantityWithAddress mapFxOptionQuantityWithAddress;
	@Inject protected MapFxOptionStrikePrice mapFxOptionStrikePrice;
	@Inject protected MapFxOptionToSettlementTerms mapFxOptionToSettlementTerms;
	@Inject protected MapPutCallEnum mapPutCallEnum;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlFxOption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFxOption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Currency> exchangeCurrency(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxOptionPayoutDefault extends MapFxOptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFxOption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlFxOption).<PartyReference>map("getSellerPartyReference", fxOption -> fxOption.getSellerPartyReference()).get(), MapperS.of(fpmlFxOption).<PartyReference>map("getBuyerPartyReference", fxOption -> fxOption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapFxOptionQuantityWithAddress.evaluate(fpmlFxOption))
						.build())
					.setSettlementTerms(mapFxOptionToSettlementTerms.evaluate(fpmlFxOption))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlFxOption).<PartyReference>map("getBuyerPartyReference", fxOption -> fxOption.getBuyerPartyReference()).get(), MapperS.of(fpmlFxOption).<PartyReference>map("getSellerPartyReference", fxOption -> fxOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setObservationTerms(mapFxOptionFeaturesToObservationTerms.evaluate(MapperS.of(fpmlFxOption).<FxOptionFeatures>map("getFeatures", fxOption -> fxOption.getFeatures()).get()))
					.setUnderlier(Underlier.builder()
						.setObservable(mapCurrencyToObservableCashWithAddress.evaluate(exchangeCurrency(fpmlFxOption, cdmCounterpartyList).get(), null))
						.build())
					.setOptionType(MapperS.of(mapPutCallEnum.evaluate(MapperS.of(fpmlFxOption).<FxStrikePrice>map("getStrike", fxOption -> fxOption.getStrike()).<StrikeQuoteBasisEnum>map("getStrikeQuoteBasis", fxStrikePrice -> fxStrikePrice.getStrikeQuoteBasis()).map("to-string", StrikeQuoteBasisEnum::toDisplayString).get())).checkedMap("to-enum", e -> OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlFxExercise.evaluate(fpmlFxOption), MapperS.of(fpmlFxOption).<ExerciseProcedure>map("getExerciseProcedure", fxOption -> fxOption.getExerciseProcedure()).get(), null, MapperS.of(fpmlFxOption).<PartyReference>map("getBuyerPartyReference", fxOption -> fxOption.getBuyerPartyReference()).get(), MapperS.of(fpmlFxOption).<PartyReference>map("getSellerPartyReference", fxOption -> fxOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(mapFxOptionStrikePrice.evaluate(fpmlFxOption))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Currency> exchangeCurrency(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(getExchangedCurrencyAmount.evaluate(fpmlFxOption)).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency());
		}
	}
}
