package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.ManualExercise;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapExerciseProcedureToAncillaryParty.MapExerciseProcedureToAncillaryPartyDefault.class)
public abstract class MapExerciseProcedureToAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryParty mapAncillaryParty;

	/**
	* @param fpmlExerciseProcedure 
	* @param cdmCounterpartyList 
	* @return ancillaryParty 
	*/
	public AncillaryParty evaluate(ExerciseProcedure fpmlExerciseProcedure, List<? extends Counterparty> cdmCounterpartyList) {
		AncillaryParty.AncillaryPartyBuilder ancillaryPartyBuilder = doEvaluate(fpmlExerciseProcedure, cdmCounterpartyList);
		
		final AncillaryParty ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.build();
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract AncillaryParty.AncillaryPartyBuilder doEvaluate(ExerciseProcedure fpmlExerciseProcedure, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapExerciseProcedureToAncillaryPartyDefault extends MapExerciseProcedureToAncillaryParty {
		@Override
		protected AncillaryParty.AncillaryPartyBuilder doEvaluate(ExerciseProcedure fpmlExerciseProcedure, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			AncillaryParty.AncillaryPartyBuilder ancillaryParty = AncillaryParty.builder();
			return assignOutput(ancillaryParty, fpmlExerciseProcedure, cdmCounterpartyList);
		}
		
		protected AncillaryParty.AncillaryPartyBuilder assignOutput(AncillaryParty.AncillaryPartyBuilder ancillaryParty, ExerciseProcedure fpmlExerciseProcedure, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperS.of(fpmlExerciseProcedure).<ManualExercise>map("getManualExercise", exerciseProcedure -> exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference())).getOrDefault(false)) {
				ancillaryParty = toBuilder(mapAncillaryParty.evaluate(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL, MapperS.of(fpmlExerciseProcedure).<ManualExercise>map("getManualExercise", exerciseProcedure -> exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), MapperS.of(fpmlExerciseProcedure).<ManualExercise>map("getManualExercise", exerciseProcedure -> exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<PartyReference>map("getPartyReference", exerciseNotice -> exerciseNotice.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList));
			} else {
				ancillaryParty = null;
			}
			
			return Optional.ofNullable(ancillaryParty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
