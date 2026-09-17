package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CalculationAgent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CalculationAgentChoice")
@ImplementedBy(CalculationAgentChoice.Default.class)
public interface CalculationAgentChoice extends Validator<CalculationAgent> {
	
	String NAME = "CalculationAgentChoice";
	String DEFINITION = "one-of";
	
	class Default implements CalculationAgentChoice {
	
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
				return choice(MapperS.of(calculationAgent), Arrays.asList("calculationAgentPartyReference", "calculationAgentParty"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationAgentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAgent calculationAgent) {
			return Collections.emptyList();
		}
	}
}
