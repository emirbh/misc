package cdm.ingest.fpml.confirmation.product.equityoption.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlEquityExercise;
import cdm.ingest.fpml.confirmation.common.functions.GetUnitTypeForUnderlyingAsset;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyRoleEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapEquityDerivativeBaseQuantityListWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapOptionStrikePrice;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapEquityExerciseValuationSettlementToSettlementTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.PassThrough;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.eqd.EquityOption;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.option.shared.Asian;
import fpml.consolidated.option.shared.AveragingPeriod;
import fpml.consolidated.option.shared.PassThroughItem;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionPayout.MapEquityOptionPayoutDefault.class)
public abstract class MapEquityOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlEquityExercise getFpmlEquityExercise;
	@Inject protected GetUnitTypeForUnderlyingAsset getUnitTypeForUnderlyingAsset;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapEquityDerivativeBaseQuantityListWithAddress mapEquityDerivativeBaseQuantityListWithAddress;
	@Inject protected MapEquityExerciseValuationSettlementToSettlementTerms mapEquityExerciseValuationSettlementToSettlementTerms;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapOptionStrikePrice mapOptionStrikePrice;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;
	@Inject protected MapUnderlyerToObservableWithAddress mapUnderlyerToObservableWithAddress;

	/**
	* @param fpmlEquityOption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlEquityOption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> unit(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends UnitType> perUnitOf(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperC<? extends PassThroughItem> passThroughItem(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AveragingPeriod> apo(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AveragingPeriod> api(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquityOptionPayoutDefault extends MapEquityOptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlEquityOption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			final cdm.product.template.PassThroughItem _passThroughItem = cdm.product.template.PassThroughItem.builder()
				.setPayerReceiver(PayerReceiver.builder()
					.setPayer(mapCounterpartyRoleEnum.evaluate(MapperS.of(passThroughItem(fpmlEquityOption, cdmCounterpartyList).get()).<PartyReference>map("getPayerPartyReference", __passThroughItem -> __passThroughItem.getPayerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
					.setReceiver(mapCounterpartyRoleEnum.evaluate(MapperS.of(passThroughItem(fpmlEquityOption, cdmCounterpartyList).get()).<PartyReference>map("getReceiverPartyReference", __passThroughItem -> __passThroughItem.getReceiverPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
					.build())
				.setPassThroughPercentage(MapperS.of(passThroughItem(fpmlEquityOption, cdmCounterpartyList).get()).<BigDecimal>map("getPassThroughPercentage", __passThroughItem -> __passThroughItem.getPassThroughPercentage()).get())
				.build();
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlEquityOption).<PartyReference>map("getSellerPartyReference", equityOption -> equityOption.getSellerPartyReference()).get(), MapperS.of(fpmlEquityOption).<PartyReference>map("getBuyerPartyReference", equityOption -> equityOption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapEquityDerivativeBaseQuantityListWithAddress.evaluate(fpmlEquityOption, MapperS.of(fpmlEquityOption).<BigDecimal>map("getNumberOfOptions", equityOption -> equityOption.getNumberOfOptions()).get()))
						.build())
					.setSettlementTerms(mapEquityExerciseValuationSettlementToSettlementTerms.evaluate(MapperS.of(fpmlEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", equityOption -> equityOption.getEquityExercise()).get(), null))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlEquityOption).<PartyReference>map("getBuyerPartyReference", equityOption -> equityOption.getBuyerPartyReference()).get(), MapperS.of(fpmlEquityOption).<PartyReference>map("getSellerPartyReference", equityOption -> equityOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setFeature(OptionFeature.builder()
						.setPassThrough(PassThrough.builder()
							.setPassThroughItem((_passThroughItem == null ? Collections.<cdm.product.template.PassThroughItem>emptyList() : Collections.singletonList(_passThroughItem)))
							.build())
						.build())
					.setUnderlier(Underlier.builder()
						.setObservable(mapUnderlyerToObservableWithAddress.evaluate(MapperS.of(fpmlEquityOption).<Underlyer>map("getUnderlyer", equityOption -> equityOption.getUnderlyer()).get()))
						.build())
					.setOptionType(MapperS.of(fpmlEquityOption).<EquityOptionTypeEnum>map("getOptionType", equityOption -> equityOption.getOptionType()).checkedMap("to-enum", e -> OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlEquityExercise.evaluate(MapperS.of(fpmlEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", equityOption -> equityOption.getEquityExercise()).get()), null, MapperS.of(fpmlEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", equityOption -> equityOption.getEquityExercise()).<Boolean>map("getAutomaticExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getAutomaticExercise()).get(), MapperS.of(fpmlEquityOption).<PartyReference>map("getBuyerPartyReference", equityOption -> equityOption.getBuyerPartyReference()).get(), MapperS.of(fpmlEquityOption).<PartyReference>map("getSellerPartyReference", equityOption -> equityOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(mapOptionStrikePrice.evaluate(MapperS.of(fpmlEquityOption).<EquityStrike>map("getStrike", equityOption -> equityOption.getStrike()).<BigDecimal>map("getStrikePrice", equityStrike -> equityStrike.getStrikePrice()).get(), MapperS.of(fpmlEquityOption).<EquityStrike>map("getStrike", equityOption -> equityOption.getStrike()).<BigDecimal>map("getStrikePercentage", equityStrike -> equityStrike.getStrikePercentage()).get(), unit(fpmlEquityOption, cdmCounterpartyList).get(), perUnitOf(fpmlEquityOption, cdmCounterpartyList).get()))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> unit(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlEquityOption).<EquityStrike>map("getStrike", equityOption -> equityOption.getStrike()).<Currency>map("getCurrency", equityStrike -> equityStrike.getCurrency()).getOrDefault(MapperS.of(fpmlEquityOption).<EquityExerciseValuationSettlement>map("getEquityExercise", equityOption -> equityOption.getEquityExercise()).<Currency>map("getSettlementCurrency", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getSettlementCurrency()).get())))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> perUnitOf(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(getUnitTypeForUnderlyingAsset.evaluate(MapperS.of(fpmlEquityOption).<Underlyer>map("getUnderlyer", equityOption -> equityOption.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<Asset>map("getUnderlyingAsset", singleUnderlyer -> singleUnderlyer.getUnderlyingAsset()).get()));
		}
		
		@Override
		protected MapperC<? extends PassThroughItem> passThroughItem(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlEquityOption).<OptionFeatures>map("getFeature", equityOption -> equityOption.getFeature()).<fpml.consolidated.option.shared.PassThrough>map("getPassThrough", optionFeatures -> optionFeatures.getPassThrough()).<PassThroughItem>mapC("getPassThroughItem", passThrough -> passThrough.getPassThroughItem());
		}
		
		@Override
		protected MapperS<? extends AveragingPeriod> apo(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlEquityOption).<OptionFeatures>map("getFeature", equityOption -> equityOption.getFeature()).<Asian>map("getAsian", optionFeatures -> optionFeatures.getAsian()).<AveragingPeriod>map("getAveragingPeriodOut", asian -> asian.getAveragingPeriodOut());
		}
		
		@Override
		protected MapperS<? extends AveragingPeriod> api(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlEquityOption).<OptionFeatures>map("getFeature", equityOption -> equityOption.getFeature()).<Asian>map("getAsian", optionFeatures -> optionFeatures.getAsian()).<AveragingPeriod>map("getAveragingPeriodIn", asian -> asian.getAveragingPeriodIn());
		}
	}
}
