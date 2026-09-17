package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CalculationAgent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CalculationAgentCalculationAgentChoice")
@ImplementedBy(CalculationAgentCalculationAgentChoice.Default.class)
public interface CalculationAgentCalculationAgentChoice extends Validator<CalculationAgent> {
	
	String NAME = "CalculationAgentCalculationAgentChoice";
	String DEFINITION = "optional choice calculationAgentParty, calculationAgentPartyEnum";
	
	class Default implements CalculationAgentCalculationAgentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAgent calculationAgent) {
			ComparisonResult result = executeDataRule(calculationAgent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationAgent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationAgent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationAgent calculationAgent) {
			try {
				return choice(MapperS.of(calculationAgent), Arrays.asList("calculationAgentParty", "calculationAgentPartyEnum"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationAgentCalculationAgentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAgent calculationAgent) {
			return Collections.emptyList();
		}
	}
}
