package cdm.ingest.fpml.confirmation.product.fxdigitaloption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlFxDigitalExercise;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.settlement.functions.MapFxDigitalOptionToSettlementTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxDigitalOptionPayout.MapFxDigitalOptionPayoutDefault.class)
public abstract class MapFxDigitalOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlFxDigitalExercise getFpmlFxDigitalExercise;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapFxDigitalOptionToSettlementTerms mapFxDigitalOptionToSettlementTerms;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlFxDigitalOption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(FxDigitalOption fpmlFxDigitalOption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFxDigitalOption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(FxDigitalOption fpmlFxDigitalOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxDigitalOptionPayoutDefault extends MapFxDigitalOptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(FxDigitalOption fpmlFxDigitalOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFxDigitalOption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, FxDigitalOption fpmlFxDigitalOption, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getSellerPartyReference", fxDigitalOption -> fxDigitalOption.getSellerPartyReference()).get(), MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getBuyerPartyReference", fxDigitalOption -> fxDigitalOption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setSettlementTerms(mapFxDigitalOptionToSettlementTerms.evaluate(fpmlFxDigitalOption))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getBuyerPartyReference", fxDigitalOption -> fxDigitalOption.getBuyerPartyReference()).get(), MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getSellerPartyReference", fxDigitalOption -> fxDigitalOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(null)
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlFxDigitalExercise.evaluate(fpmlFxDigitalOption), MapperS.of(fpmlFxDigitalOption).<ExerciseProcedure>map("getExerciseProcedure", fxDigitalOption -> fxDigitalOption.getExerciseProcedure()).get(), null, MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getBuyerPartyReference", fxDigitalOption -> fxDigitalOption.getBuyerPartyReference()).get(), MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getSellerPartyReference", fxDigitalOption -> fxDigitalOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
