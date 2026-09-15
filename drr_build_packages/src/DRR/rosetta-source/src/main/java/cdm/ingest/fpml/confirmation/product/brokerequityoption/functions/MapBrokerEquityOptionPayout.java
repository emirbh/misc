package cdm.ingest.fpml.confirmation.product.brokerequityoption.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlEquityExercise;
import cdm.ingest.fpml.confirmation.common.functions.GetUnitTypeForUnderlyingAsset;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapEquityDerivativeBaseQuantityListWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapOptionStrikePrice;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapEquityExerciseValuationSettlementToSettlementTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.eqd.BrokerEquityOption;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBrokerEquityOptionPayout.MapBrokerEquityOptionPayoutDefault.class)
public abstract class MapBrokerEquityOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlEquityExercise getFpmlEquityExercise;
	@Inject protected GetUnitTypeForUnderlyingAsset getUnitTypeForUnderlyingAsset;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapEquityDerivativeBaseQuantityListWithAddress mapEquityDerivativeBaseQuantityListWithAddress;
	@Inject protected MapEquityExerciseValuationSettlementToSettlementTerms mapEquityExerciseValuationSettlementToSettlementTerms;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapOptionStrikePrice mapOptionStrikePrice;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;
	@Inject protected MapUnderlyerToObservableWithAddress mapUnderlyerToObservableWithAddress;

	/**
	* @param fpmlBrokerEquityOption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlBrokerEquityOption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> unit(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> perUnitOf(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapBrokerEquityOptionPayoutDefault extends MapBrokerEquityOptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlBrokerEquityOption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getSellerPartyReference", brokerEquityOption -> brokerEquityOption.getSellerPartyReference()).get(), MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getBuyerPartyReference", brokerEquityOption -> brokerEquityOption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapEquityDerivativeBaseQuantityListWithAddress.evaluate(fpmlBrokerEquityOption, MapperS.of(fpmlBrokerEquityOption).<BigDecimal>map("getNumberOfOptions", brokerEquityOption -> brokerEquityOption.getNumberOfOptions()).get()))
						.build())
					.setSettlementTerms(mapEquityExerciseValuationSettlementToSettlementTerms.evaluate(MapperS.of(fpmlBrokerEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", brokerEquityOption -> brokerEquityOption.getEquityExercise()).get(), null))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getBuyerPartyReference", brokerEquityOption -> brokerEquityOption.getBuyerPartyReference()).get(), MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getSellerPartyReference", brokerEquityOption -> brokerEquityOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlBrokerEquityOption).<Underlyer>map("getUnderlyer", brokerEquityOption -> brokerEquityOption.getUnderlyer()).get()))
						.build())
					.setOptionType(MapperS.of(fpmlBrokerEquityOption).<EquityOptionTypeEnum>map("getOptionType", brokerEquityOption -> brokerEquityOption.getOptionType()).checkedMap("to-enum", e -> OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlEquityExercise.evaluate(MapperS.of(fpmlBrokerEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", brokerEquityOption -> brokerEquityOption.getEquityExercise()).get()), null, MapperS.of(fpmlBrokerEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", brokerEquityOption -> brokerEquityOption.getEquityExercise()).<Boolean>map("getAutomaticExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getAutomaticExercise()).get(), MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getBuyerPartyReference", brokerEquityOption -> brokerEquityOption.getBuyerPartyReference()).get(), MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getSellerPartyReference", brokerEquityOption -> brokerEquityOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(mapOptionStrikePrice.evaluate(MapperS.of(fpmlBrokerEquityOption).<EquityStrike>map("getStrike", brokerEquityOption -> brokerEquityOption.getStrike()).<BigDecimal>map("getStrikePrice", equityStrike -> equityStrike.getStrikePrice()).get(), MapperS.of(fpmlBrokerEquityOption).<EquityStrike>map("getStrike", brokerEquityOption -> brokerEquityOption.getStrike()).<BigDecimal>map("getStrikePercentage", equityStrike -> equityStrike.getStrikePercentage()).get(), unit(fpmlBrokerEquityOption, cdmCounterpartyList).get(), perUnitOf(fpmlBrokerEquityOption, cdmCounterpartyList).get()))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> unit(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlBrokerEquityOption).<EquityStrike>map("getStrike", brokerEquityOption -> brokerEquityOption.getStrike()).<Currency>map("getCurrency", equityStrike -> equityStrike.getCurrency()).getOrDefault(MapperS.of(fpmlBrokerEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", brokerEquityOption -> brokerEquityOption.getEquityExercise()).<Currency>map("getSettlementCurrency", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getSettlementCurrency()).get())))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> perUnitOf(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(getUnitTypeForUnderlyingAsset.evaluate(MapperS.of(fpmlBrokerEquityOption).<Underlyer>map("getUnderlyer", brokerEquityOption -> brokerEquityOption.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<Asset>map("getUnderlyingAsset", singleUnderlyer -> singleUnderlyer.getUnderlyingAsset()).get()));
		}
	}
}
