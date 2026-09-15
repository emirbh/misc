package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.MandatoryEarlyTermination;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEarlyTerminationProvisionToAncillaryParty.MapEarlyTerminationProvisionToAncillaryPartyDefault.class)
public abstract class MapEarlyTerminationProvisionToAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryParty mapAncillaryParty;
	@Inject protected MapOptionalEarlyTerminationToAncillaryParty mapOptionalEarlyTerminationToAncillaryParty;

	/**
	* @param fpmlEarlyTerminationProvision 
	* @param cdmCounterpartyList 
	* @return ancillaryParty 
	*/
	public List<? extends AncillaryParty> evaluate(EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyBuilder = doEvaluate(fpmlEarlyTerminationProvision, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEarlyTerminationProvisionToAncillaryPartyDefault extends MapEarlyTerminationProvisionToAncillaryParty {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryParty = new ArrayList<>();
			return assignOutput(ancillaryParty, fpmlEarlyTerminationProvision, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryParty, EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList) {
			ancillaryParty.addAll(toBuilder(mapOptionalEarlyTerminationToAncillaryParty.evaluate(MapperS.of(fpmlEarlyTerminationProvision).<OptionalEarlyTermination>map("getOptionalEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getOptionalEarlyTermination()).get(), cdmCounterpartyList)));
			
			if (exists(MapperS.of(fpmlEarlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getMandatoryEarlyTermination()).<CalculationAgent>map("getCalculationAgent", mandatoryEarlyTermination -> mandatoryEarlyTermination.getCalculationAgent())).getOrDefault(false)) {
				final AncillaryParty _ancillaryParty = mapAncillaryParty.evaluate(AncillaryRoleEnum.CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION, MapperS.of(fpmlEarlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getMandatoryEarlyTermination()).<CalculationAgent>map("getCalculationAgent", mandatoryEarlyTermination -> mandatoryEarlyTermination.getCalculationAgent()).<PartyReference>mapC("getCalculationAgentPartyReference", calculationAgent -> calculationAgent.getCalculationAgentPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), null, Collections.<Counterparty>emptyList());
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
