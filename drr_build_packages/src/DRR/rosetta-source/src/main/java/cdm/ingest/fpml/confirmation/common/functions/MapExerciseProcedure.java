package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyRoleEnum;
import cdm.product.template.AutomaticExercise;
import cdm.product.template.ExerciseNoticeGiverEnum;
import cdm.product.template.ExerciseProcedure;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.ManualExercise;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapExerciseProcedure.MapExerciseProcedureDefault.class)
public abstract class MapExerciseProcedure implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;

	/**
	* @param fpmlExerciseProcedure 
	* @param fpmlBuyerPartyReference 
	* @param fpmlSellerPartyReference 
	* @param fpmlAutomaticExercise 
	* @param cdmCounterpartyList 
	* @return exerciseProcedure 
	*/
	public ExerciseProcedure evaluate(fpml.consolidated.shared.ExerciseProcedure fpmlExerciseProcedure, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, Boolean fpmlAutomaticExercise, List<? extends Counterparty> cdmCounterpartyList) {
		ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedureBuilder = doEvaluate(fpmlExerciseProcedure, fpmlBuyerPartyReference, fpmlSellerPartyReference, fpmlAutomaticExercise, cdmCounterpartyList);
		
		final ExerciseProcedure exerciseProcedure;
		if (exerciseProcedureBuilder == null) {
			exerciseProcedure = null;
		} else {
			exerciseProcedure = exerciseProcedureBuilder.build();
			objectValidator.validate(ExerciseProcedure.class, exerciseProcedure);
		}
		
		return exerciseProcedure;
	}

	protected abstract ExerciseProcedure.ExerciseProcedureBuilder doEvaluate(fpml.consolidated.shared.ExerciseProcedure fpmlExerciseProcedure, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, Boolean fpmlAutomaticExercise, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends BuyerSeller> buyerSeller(fpml.consolidated.shared.ExerciseProcedure fpmlExerciseProcedure, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, Boolean fpmlAutomaticExercise, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapExerciseProcedureDefault extends MapExerciseProcedure {
		@Override
		protected ExerciseProcedure.ExerciseProcedureBuilder doEvaluate(fpml.consolidated.shared.ExerciseProcedure fpmlExerciseProcedure, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, Boolean fpmlAutomaticExercise, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure = ExerciseProcedure.builder();
			return assignOutput(exerciseProcedure, fpmlExerciseProcedure, fpmlBuyerPartyReference, fpmlSellerPartyReference, fpmlAutomaticExercise, cdmCounterpartyList);
		}
		
		protected ExerciseProcedure.ExerciseProcedureBuilder assignOutput(ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure, fpml.consolidated.shared.ExerciseProcedure fpmlExerciseProcedure, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, Boolean fpmlAutomaticExercise, List<? extends Counterparty> cdmCounterpartyList) {
			final ExerciseNoticeGiverEnum ifThenElseResult;
			if (areEqual(buyerSeller(fpmlExerciseProcedure, fpmlBuyerPartyReference, fpmlSellerPartyReference, fpmlAutomaticExercise, cdmCounterpartyList).<CounterpartyRoleEnum>map("getBuyer", _buyerSeller -> _buyerSeller.getBuyer()), MapperS.of(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlExerciseProcedure).<ManualExercise>map("getManualExercise", _exerciseProcedure -> _exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<PartyReference>map("getPartyReference", exerciseNotice -> exerciseNotice.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = ExerciseNoticeGiverEnum.BUYER;
			} else if (areEqual(buyerSeller(fpmlExerciseProcedure, fpmlBuyerPartyReference, fpmlSellerPartyReference, fpmlAutomaticExercise, cdmCounterpartyList).<CounterpartyRoleEnum>map("getSeller", _buyerSeller -> _buyerSeller.getSeller()), MapperS.of(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlExerciseProcedure).<ManualExercise>map("getManualExercise", _exerciseProcedure -> _exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<PartyReference>map("getPartyReference", exerciseNotice -> exerciseNotice.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = ExerciseNoticeGiverEnum.SELLER;
			} else {
				ifThenElseResult = null;
			}
			exerciseProcedure = toBuilder(ExerciseProcedure.builder()
				.setManualExercise(cdm.product.template.ManualExercise.builder()
					.setExerciseNotice(cdm.product.template.ExerciseNotice.builder()
						.setExerciseNoticeGiver(ifThenElseResult)
						.setBusinessCenterValue(MapperS.of(fpmlExerciseProcedure).<ManualExercise>map("getManualExercise", _exerciseProcedure -> _exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<BusinessCenter>map("getBusinessCenter", exerciseNotice -> exerciseNotice.getBusinessCenter()).<String>map("getValue", businessCenter -> businessCenter.getValue()).checkedMap("to-enum", BusinessCenterEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build())
					.build())
				.setAutomaticExercise(AutomaticExercise.builder()
					.setIsApplicable(fpmlAutomaticExercise)
					.build())
				.setFollowUpConfirmation(MapperS.of(fpmlExerciseProcedure).<Boolean>map("getFollowUpConfirmation", _exerciseProcedure -> _exerciseProcedure.getFollowUpConfirmation()).get())
				.build());
			
			return Optional.ofNullable(exerciseProcedure)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends BuyerSeller> buyerSeller(fpml.consolidated.shared.ExerciseProcedure fpmlExerciseProcedure, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, Boolean fpmlAutomaticExercise, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapBuyerSeller.evaluate(fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList));
		}
	}
}
