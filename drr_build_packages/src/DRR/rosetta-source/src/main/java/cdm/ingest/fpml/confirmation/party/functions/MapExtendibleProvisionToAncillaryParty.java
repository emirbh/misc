package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.ExtendibleProvision;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapExtendibleProvisionToAncillaryParty.MapExtendibleProvisionToAncillaryPartyDefault.class)
public abstract class MapExtendibleProvisionToAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryParty mapAncillaryParty;

	/**
	* @param fpmlExtendibleProvision 
	* @param cdmCounterpartyList 
	* @return ancillaryParty 
	*/
	public AncillaryParty evaluate(ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList) {
		AncillaryParty.AncillaryPartyBuilder ancillaryPartyBuilder = doEvaluate(fpmlExtendibleProvision, cdmCounterpartyList);
		
		final AncillaryParty ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.build();
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract AncillaryParty.AncillaryPartyBuilder doEvaluate(ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapExtendibleProvisionToAncillaryPartyDefault extends MapExtendibleProvisionToAncillaryParty {
		@Override
		protected AncillaryParty.AncillaryPartyBuilder doEvaluate(ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			AncillaryParty.AncillaryPartyBuilder ancillaryParty = AncillaryParty.builder();
			return assignOutput(ancillaryParty, fpmlExtendibleProvision, cdmCounterpartyList);
		}
		
		protected AncillaryParty.AncillaryPartyBuilder assignOutput(AncillaryParty.AncillaryPartyBuilder ancillaryParty, ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperS.of(fpmlExtendibleProvision).<ExerciseNotice>map("getExerciseNotice", extendibleProvision -> extendibleProvision.getExerciseNotice()).<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference())).getOrDefault(false)) {
				ancillaryParty = toBuilder(mapAncillaryParty.evaluate(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION, MapperS.of(fpmlExtendibleProvision).<ExerciseNotice>map("getExerciseNotice", extendibleProvision -> extendibleProvision.getExerciseNotice()).<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), MapperS.of(fpmlExtendibleProvision).<ExerciseNotice>map("getExerciseNotice", extendibleProvision -> extendibleProvision.getExerciseNotice()).<PartyReference>map("getPartyReference", exerciseNotice -> exerciseNotice.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList));
			} else {
				ancillaryParty = null;
			}
			
			return Optional.ofNullable(ancillaryParty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
