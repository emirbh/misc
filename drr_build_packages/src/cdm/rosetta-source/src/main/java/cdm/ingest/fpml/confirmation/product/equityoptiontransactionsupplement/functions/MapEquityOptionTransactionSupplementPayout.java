package cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions;

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
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionTransactionSupplementPayout.MapEquityOptionTransactionSupplementPayoutDefault.class)
public abstract class MapEquityOptionTransactionSupplementPayout implements RosettaFunction {
	
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
	* @param fpmlEquityOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlEquityOptionTransactionSupplement, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> unit(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> perUnitOf(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquityOptionTransactionSupplementPayoutDefault extends MapEquityOptionTransactionSupplementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlEquityOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getSellerPartyReference()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapEquityDerivativeBaseQuantityListWithAddress.evaluate(fpmlEquityOptionTransactionSupplement, MapperS.of(fpmlEquityOptionTransactionSupplement).<BigDecimal>map("getNumberOfOptions", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getNumberOfOptions()).get()))
						.build())
					.setSettlementTerms(mapEquityExerciseValuationSettlementToSettlementTerms.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<EquityExerciseValuationSettlement>map("getEquityExercise", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getEquityExercise()).get(), null))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<Underlyer>map("getUnderlyer", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getUnderlyer()).get()))
						.build())
					.setOptionType(MapperS.of(fpmlEquityOptionTransactionSupplement).<EquityOptionTypeEnum>map("getOptionType", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getOptionType()).checkedMap("to-enum", e -> OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlEquityExercise.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<EquityExerciseValuationSettlement>map("getEquityExercise", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getEquityExercise()).get()), null, MapperS.of(fpmlEquityOptionTransactionSupplement).<EquityExerciseValuationSettlement>map("getEquityExercise", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getEquityExercise()).<Boolean>map("getAutomaticExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getAutomaticExercise()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(mapOptionStrikePrice.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<EquityStrike>map("getStrike", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getStrike()).<BigDecimal>map("getStrikePrice", equityStrike -> equityStrike.getStrikePrice()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<EquityStrike>map("getStrike", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getStrike()).<BigDecimal>map("getStrikePercentage", equityStrike -> equityStrike.getStrikePercentage()).get(), unit(fpmlEquityOptionTransactionSupplement, cdmCounterpartyList).get(), perUnitOf(fpmlEquityOptionTransactionSupplement, cdmCounterpartyList).get()))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> unit(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<EquityStrike>map("getStrike", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getStrike()).<Currency>map("getCurrency", equityStrike -> equityStrike.getCurrency()).get()))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> perUnitOf(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(getUnitTypeForUnderlyingAsset.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<Underlyer>map("getUnderlyer", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<Asset>map("getUnderlyingAsset", singleUnderlyer -> singleUnderlyer.getUnderlyingAsset()).get()));
		}
	}
}
