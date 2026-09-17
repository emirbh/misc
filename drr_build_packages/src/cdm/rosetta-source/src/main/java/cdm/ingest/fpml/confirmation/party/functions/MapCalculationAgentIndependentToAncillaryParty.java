package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCalculationAgentIndependentToAncillaryParty.MapCalculationAgentIndependentToAncillaryPartyDefault.class)
public abstract class MapCalculationAgentIndependentToAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryParty mapAncillaryParty;

	/**
	* @param fpmlCalculationAgent 
	* @return ancillaryParty 
	*/
	public AncillaryParty evaluate(CalculationAgent fpmlCalculationAgent) {
		AncillaryParty.AncillaryPartyBuilder ancillaryPartyBuilder = doEvaluate(fpmlCalculationAgent);
		
		final AncillaryParty ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.build();
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract AncillaryParty.AncillaryPartyBuilder doEvaluate(CalculationAgent fpmlCalculationAgent);

	public static class MapCalculationAgentIndependentToAncillaryPartyDefault extends MapCalculationAgentIndependentToAncillaryParty {
		@Override
		protected AncillaryParty.AncillaryPartyBuilder doEvaluate(CalculationAgent fpmlCalculationAgent) {
			AncillaryParty.AncillaryPartyBuilder ancillaryParty = AncillaryParty.builder();
			return assignOutput(ancillaryParty, fpmlCalculationAgent);
		}
		
		protected AncillaryParty.AncillaryPartyBuilder assignOutput(AncillaryParty.AncillaryPartyBuilder ancillaryParty, CalculationAgent fpmlCalculationAgent) {
			if (exists(MapperS.of(fpmlCalculationAgent).<PartyReference>mapC("getCalculationAgentPartyReference", calculationAgent -> calculationAgent.getCalculationAgentPartyReference())).getOrDefault(false)) {
				ancillaryParty = toBuilder(mapAncillaryParty.evaluate(AncillaryRoleEnum.CALCULATION_AGENT_INDEPENDENT, MapperS.of(fpmlCalculationAgent).<PartyReference>mapC("getCalculationAgentPartyReference", calculationAgent -> calculationAgent.getCalculationAgentPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), null, Collections.<Counterparty>emptyList()));
			} else {
				ancillaryParty = null;
			}
			
			return Optional.ofNullable(ancillaryParty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
