package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapOptionalEarlyTerminationToAncillaryParty.MapOptionalEarlyTerminationToAncillaryPartyDefault.class)
public abstract class MapOptionalEarlyTerminationToAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryParty mapAncillaryParty;

	/**
	* @param fpmlOptionalEarlyTermination 
	* @param cdmCounterpartyList 
	* @return ancillaryParty 
	*/
	public List<? extends AncillaryParty> evaluate(OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyBuilder = doEvaluate(fpmlOptionalEarlyTermination, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapOptionalEarlyTerminationToAncillaryPartyDefault extends MapOptionalEarlyTerminationToAncillaryParty {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryParty = new ArrayList<>();
			return assignOutput(ancillaryParty, fpmlOptionalEarlyTermination, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryParty, OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperS.of(fpmlOptionalEarlyTermination).<ExerciseNotice>mapC("getExerciseNotice", optionalEarlyTermination -> optionalEarlyTermination.getExerciseNotice()).<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference())).getOrDefault(false)) {
				ancillaryParty.addAll(toBuilder(MapperS.of(fpmlOptionalEarlyTermination).<ExerciseNotice>mapC("getExerciseNotice", optionalEarlyTermination -> optionalEarlyTermination.getExerciseNotice())
					.mapItem(item -> MapperS.of(mapAncillaryParty.evaluate(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION, item.<PartyReference>map("getExerciseNoticePartyReference", exerciseNotice -> exerciseNotice.getExerciseNoticePartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), item.<PartyReference>map("getPartyReference", exerciseNotice -> exerciseNotice.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))).getMulti()));
			} else {
				ancillaryParty.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlOptionalEarlyTermination).<CalculationAgent>map("getCalculationAgent", optionalEarlyTermination -> optionalEarlyTermination.getCalculationAgent())).getOrDefault(false)) {
				final AncillaryParty _ancillaryParty = mapAncillaryParty.evaluate(AncillaryRoleEnum.CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION, MapperS.of(fpmlOptionalEarlyTermination).<CalculationAgent>map("getCalculationAgent", optionalEarlyTermination -> optionalEarlyTermination.getCalculationAgent()).<PartyReference>mapC("getCalculationAgentPartyReference", calculationAgent -> calculationAgent.getCalculationAgentPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), null, Collections.<Counterparty>emptyList());
				if (_ancillaryParty == null) {
					ancillaryParty.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
				} else {
					ancillaryParty.addAll(toBuilder(Collections.singletonList(_ancillaryParty)));
				}
			} else {
				ancillaryParty.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			}
			
			return Optional.ofNullable(ancillaryParty)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
