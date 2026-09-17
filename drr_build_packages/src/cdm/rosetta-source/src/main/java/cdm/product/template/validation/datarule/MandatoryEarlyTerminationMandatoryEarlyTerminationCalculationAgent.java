package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.product.template.MandatoryEarlyTermination;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent")
@ImplementedBy(MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent.Default.class)
public interface MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent extends Validator<MandatoryEarlyTermination> {
	
	String NAME = "MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent";
	String DEFINITION = "if calculationAgent -> calculationAgentParty exists then calculationAgent -> calculationAgentParty = AncillaryRoleEnum -> CalculationAgentMandatoryEarlyTermination";
	
	class Default implements MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MandatoryEarlyTermination mandatoryEarlyTermination) {
			ComparisonResult result = executeDataRule(mandatoryEarlyTermination);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTermination", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTermination", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MandatoryEarlyTermination mandatoryEarlyTermination) {
			try {
				if (exists(MapperS.of(mandatoryEarlyTermination).<CalculationAgent>map("getCalculationAgent", _mandatoryEarlyTermination -> _mandatoryEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty())).getOrDefault(false)) {
					return areEqual(MapperS.of(mandatoryEarlyTermination).<CalculationAgent>map("getCalculationAgent", _mandatoryEarlyTermination -> _mandatoryEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", calculationAgent -> calculationAgent.getCalculationAgentParty()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MandatoryEarlyTermination mandatoryEarlyTermination) {
			return Collections.emptyList();
		}
	}
}
