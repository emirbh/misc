package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CancelableProvision;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCancelableProvisionToAncillaryParty.MapCancelableProvisionToAncillaryPartyDefault.class)
public abstract class MapCancelableProvisionToAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryParty mapAncillaryParty;

	/**
	* @param fpmlCancelableProvision 
	* @param cdmCounterpartyList 
	* @return ancillaryParty 
	*/
	public AncillaryParty evaluate(CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList) {
		AncillaryParty.AncillaryPartyBuilder ancillaryPartyBuilder = doEvaluate(fpmlCancelableProvision, cdmCounterpartyList);
		
		final AncillaryParty ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.build();
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract AncillaryParty.AncillaryPartyBuilder doEvaluate(CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCancelableProvisionToAncillaryPartyDefault extends MapCancelableProvisionToAncillaryParty {
		@Override
		protected AncillaryParty.AncillaryPartyBuilder doEvaluate(CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			AncillaryParty.AncillaryPartyBuilder ancillaryParty = AncillaryParty.builder();
			return assignOutput(ancillaryParty, fpmlCancelableProvision, cdmCounterpartyList);
		}
		
		protected AncillaryParty.AncillaryPartyBuilder assignOutput(AncillaryParty.AncillaryPartyBuilder ancillaryParty, CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperS.of(fpmlCancelableProvision).<ExerciseNotice>map("getExerciseNotice", cancelableProvision -> cancelableProvision.getExerciseNotice()).<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference())).getOrDefault(false)) {
				ancillaryParty = toBuilder(mapAncillaryParty.evaluate(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION, MapperS.of(fpmlCancelableProvision).<ExerciseNotice>map("getExerciseNotice", cancelableProvision -> cancelableProvision.getExerciseNotice()).<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), MapperS.of(fpmlCancelableProvision).<ExerciseNotice>map("getExerciseNotice", cancelableProvision -> cancelableProvision.getExerciseNotice()).<PartyReference>map("getPartyReference", exerciseNotice -> exerciseNotice.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList));
			} else {
				ancillaryParty = null;
			}
			
			return Optional.ofNullable(ancillaryParty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
