package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenter;
import cdm.observable.asset.CalculationAgent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCalculationAgent.MapCalculationAgentDefault.class)
public abstract class MapCalculationAgent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenter mapBusinessCenter;

	/**
	* @param fpmlCalculationAgent 
	* @param fpmlCalculationAgentBusinessCenter 
	* @return calculationAgent 
	*/
	public CalculationAgent evaluate(fpml.consolidated.shared.CalculationAgent fpmlCalculationAgent, BusinessCenter fpmlCalculationAgentBusinessCenter) {
		CalculationAgent.CalculationAgentBuilder calculationAgentBuilder = doEvaluate(fpmlCalculationAgent, fpmlCalculationAgentBusinessCenter);
		
		final CalculationAgent calculationAgent;
		if (calculationAgentBuilder == null) {
			calculationAgent = null;
		} else {
			calculationAgent = calculationAgentBuilder.build();
			objectValidator.validate(CalculationAgent.class, calculationAgent);
		}
		
		return calculationAgent;
	}

	protected abstract CalculationAgent.CalculationAgentBuilder doEvaluate(fpml.consolidated.shared.CalculationAgent fpmlCalculationAgent, BusinessCenter fpmlCalculationAgentBusinessCenter);

	public static class MapCalculationAgentDefault extends MapCalculationAgent {
		@Override
		protected CalculationAgent.CalculationAgentBuilder doEvaluate(fpml.consolidated.shared.CalculationAgent fpmlCalculationAgent, BusinessCenter fpmlCalculationAgentBusinessCenter) {
			CalculationAgent.CalculationAgentBuilder calculationAgent = CalculationAgent.builder();
			return assignOutput(calculationAgent, fpmlCalculationAgent, fpmlCalculationAgentBusinessCenter);
		}
		
		protected CalculationAgent.CalculationAgentBuilder assignOutput(CalculationAgent.CalculationAgentBuilder calculationAgent, fpml.consolidated.shared.CalculationAgent fpmlCalculationAgent, BusinessCenter fpmlCalculationAgentBusinessCenter) {
			AncillaryRoleEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlCalculationAgent).<PartyReference>mapC("getCalculationAgentPartyReference", _calculationAgent -> _calculationAgent.getCalculationAgentPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref())).getOrDefault(false)) {
				ifThenElseResult = AncillaryRoleEnum.CALCULATION_AGENT_INDEPENDENT;
			}
			calculationAgent = toBuilder(CalculationAgent.builder()
				.setCalculationAgentParty(ifThenElseResult)
				.setCalculationAgentPartyEnum(null)
				.setCalculationAgentBusinessCenter(mapBusinessCenter.evaluate(fpmlCalculationAgentBusinessCenter))
				.build());
			
			return Optional.ofNullable(calculationAgent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
