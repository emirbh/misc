package cdm.ingest.fpml.confirmation.product.bondoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapOptionBaseExtendedQuantityListWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapOptionSettlementModelToSettlementTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.bond.option.BondOptionStrike;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBondOptionPayout.MapBondOptionPayoutDefault.class)
public abstract class MapBondOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithAddress mapAssetToObservableWithAddress;
	@Inject protected MapBondOptionStrikeToOptionStrike mapBondOptionStrikeToOptionStrike;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapOptionBaseExtendedQuantityListWithAddress mapOptionBaseExtendedQuantityListWithAddress;
	@Inject protected MapOptionSettlementModelToSettlementTerms mapOptionSettlementModelToSettlementTerms;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlBondOption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlBondOption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Bond> fpmlUnderlyingAsset(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapBondOptionPayoutDefault extends MapBondOptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlBondOption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlBondOption).<PartyReference>map("getSellerPartyReference", bondOption -> bondOption.getSellerPartyReference()).get(), MapperS.of(fpmlBondOption).<PartyReference>map("getBuyerPartyReference", bondOption -> bondOption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapOptionBaseExtendedQuantityListWithAddress.evaluate(fpmlBondOption))
						.build())
					.setSettlementTerms(mapOptionSettlementModelToSettlementTerms.evaluate(MapperS.of(fpmlBondOption).<SettlementTypeEnum>map("getSettlementType", bondOption -> bondOption.getSettlementType()).get(), MapperS.of(fpmlBondOption).<Currency>map("getSettlementCurrency", bondOption -> bondOption.getSettlementCurrency()).get(), MapperS.of(fpmlBondOption).<AdjustableOrRelativeDate>map("getSettlementDate", bondOption -> bondOption.getSettlementDate()).get()))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlBondOption).<PartyReference>map("getBuyerPartyReference", bondOption -> bondOption.getBuyerPartyReference()).get(), MapperS.of(fpmlBondOption).<PartyReference>map("getSellerPartyReference", bondOption -> bondOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapAssetToObservableWithAddress.evaluate(fpmlUnderlyingAsset(fpmlBondOption, cdmCounterpartyList).get()))
						.build())
					.setOptionType(MapperS.of(fpmlBondOption).<OptionTypeEnum>map("getOptionType", bondOption -> bondOption.getOptionType()).checkedMap("to-enum", e -> cdm.product.template.OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(MapperS.of(fpmlBondOption).<Exercise>map("getExercise", bondOption -> bondOption.getExercise()).get(), MapperS.of(fpmlBondOption).<ExerciseProcedure>map("getExerciseProcedure", bondOption -> bondOption.getExerciseProcedure()).get(), null, MapperS.of(fpmlBondOption).<PartyReference>map("getBuyerPartyReference", bondOption -> bondOption.getBuyerPartyReference()).get(), MapperS.of(fpmlBondOption).<PartyReference>map("getSellerPartyReference", bondOption -> bondOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(mapBondOptionStrikeToOptionStrike.evaluate(MapperS.of(fpmlBondOption).<BondOptionStrike>map("getStrike", bondOption -> bondOption.getStrike()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Bond> fpmlUnderlyingAsset(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(MapperS.of(fpmlBondOption).<Bond>map("getBond", bondOption -> bondOption.getBond()).getOrDefault(MapperS.of(fpmlBondOption).<ConvertibleBond>map("getConvertibleBond", bondOption -> bondOption.getConvertibleBond()).get()));
		}
	}
}
