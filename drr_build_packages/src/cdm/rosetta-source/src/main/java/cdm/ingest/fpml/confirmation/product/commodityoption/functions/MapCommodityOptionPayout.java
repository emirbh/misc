package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlCommodityExercise;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.other.functions.MapCapacityUnitEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityNotionalQuantityToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapOptionStrikePrice;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCommodityExerciseToSettlementTerms;
import cdm.observable.asset.Price;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityExercise;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommodityStrikeSchedule;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityOptionPayout.MapCommodityOptionPayoutDefault.class)
public abstract class MapCommodityOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlCommodityExercise getFpmlCommodityExercise;
	@Inject protected MapAssetToObservableWithAddress mapAssetToObservableWithAddress;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCapacityUnitEnum mapCapacityUnitEnum;
	@Inject protected MapCommodityExerciseToSettlementTerms mapCommodityExerciseToSettlementTerms;
	@Inject protected MapCommodityNotionalQuantityToQuantityWithAddress mapCommodityNotionalQuantityToQuantityWithAddress;
	@Inject protected MapCommodityOptionToObservationTerms mapCommodityOptionToObservationTerms;
	@Inject protected MapCommodityOptionToStrikePriceDatedValues mapCommodityOptionToStrikePriceDatedValues;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapOptionStrikePrice mapOptionStrikePrice;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlCommodityOption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlCommodityOption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> strikeUnit(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> strikePerUnitOf(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommodityOptionPayoutDefault extends MapCommodityOptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlCommodityOption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			final OptionStrike ifThenElseResult;
			if (exists(MapperS.of(fpmlCommodityOption).<NonNegativeMoney>map("getStrikePricePerUnit", commodityOption -> commodityOption.getStrikePricePerUnit()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount())).getOrDefault(false)) {
				ifThenElseResult = mapOptionStrikePrice.evaluate(MapperS.of(fpmlCommodityOption).<NonNegativeMoney>map("getStrikePricePerUnit", commodityOption -> commodityOption.getStrikePricePerUnit()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), null, strikeUnit(fpmlCommodityOption, cdmCounterpartyList).get(), strikePerUnitOf(fpmlCommodityOption, cdmCounterpartyList).get());
			} else if (exists(MapperS.of(fpmlCommodityOption).<CommodityStrikeSchedule>map("getStrikePricePerUnitSchedule", commodityOption -> commodityOption.getStrikePricePerUnitSchedule()).<NonNegativeMoney>mapC("getStrikePricePerUnitStep", commodityStrikeSchedule -> commodityStrikeSchedule.getStrikePricePerUnitStep()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount())).getOrDefault(false)) {
				ifThenElseResult = OptionStrike.builder()
					.setStrikePrice(Price.builder()
						.setPriceType(null)
						.setDatedValue(new ArrayList(mapCommodityOptionToStrikePriceDatedValues.evaluate(fpmlCommodityOption)))
						.build())
					.build();
			} else {
				ifThenElseResult = null;
			}
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlCommodityOption).<PartyReference>map("getSellerPartyReference", commodityOption -> commodityOption.getSellerPartyReference()).get(), MapperS.of(fpmlCommodityOption).<PartyReference>map("getBuyerPartyReference", commodityOption -> commodityOption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapCommodityNotionalQuantityToQuantityWithAddress.evaluate(MapperS.of(fpmlCommodityOption).<BigDecimal>map("getTotalNotionalQuantity", commodityOption -> commodityOption.getTotalNotionalQuantity()).get(), null))
						.build())
					.setSettlementTerms(mapCommodityExerciseToSettlementTerms.evaluate(MapperS.of(fpmlCommodityOption).<CommodityExercise>map("getExercise", commodityOption -> commodityOption.getExercise()).get()))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlCommodityOption).<PartyReference>map("getBuyerPartyReference", commodityOption -> commodityOption.getBuyerPartyReference()).get(), MapperS.of(fpmlCommodityOption).<PartyReference>map("getSellerPartyReference", commodityOption -> commodityOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setObservationTerms(mapCommodityOptionToObservationTerms.evaluate(fpmlCommodityOption))
					.setUnderlier(Underlier.builder()
						.setObservable(mapAssetToObservableWithAddress.evaluate(MapperS.of(fpmlCommodityOption).<Commodity>map("getCommodity", commodityOption -> commodityOption.getCommodity()).get()))
						.build())
					.setOptionType(MapperS.of(fpmlCommodityOption).<PutCallEnum>map("getOptionType", commodityOption -> commodityOption.getOptionType()).checkedMap("to-enum", e -> OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlCommodityExercise.evaluate(MapperS.of(fpmlCommodityOption).<CommodityExercise>map("getExercise", commodityOption -> commodityOption.getExercise()).get()), ExerciseProcedure.builder()
						.setFollowUpConfirmation(MapperS.of(fpmlCommodityOption).<CommodityExercise>map("getExercise", commodityOption -> commodityOption.getExercise()).<Boolean>map("getWrittenConfirmation", commodityExercise -> commodityExercise.getWrittenConfirmation()).get())
						.build(), MapperS.of(fpmlCommodityOption).<CommodityExercise>map("getExercise", commodityOption -> commodityOption.getExercise()).<Boolean>map("getAutomaticExercise", commodityExercise -> commodityExercise.getAutomaticExercise()).get(), MapperS.of(fpmlCommodityOption).<PartyReference>map("getBuyerPartyReference", commodityOption -> commodityOption.getBuyerPartyReference()).get(), MapperS.of(fpmlCommodityOption).<PartyReference>map("getSellerPartyReference", commodityOption -> commodityOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(ifThenElseResult)
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> strikeUnit(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlCommodityOption).<NonNegativeMoney>map("getStrikePricePerUnit", commodityOption -> commodityOption.getStrikePricePerUnit()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get()))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> strikePerUnitOf(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(UnitType.builder()
				.setCapacityUnit(mapCapacityUnitEnum.evaluate(MapperS.of(fpmlCommodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", commodityOption -> commodityOption.getNotionalQuantity()).<QuantityUnit>map("getQuantityUnit", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityUnit()).<String>map("getValue", quantityUnit -> quantityUnit.getValue()).get()))
				.build());
		}
	}
}
