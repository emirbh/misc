package cdm.event.workflow.validation.datarule;

import cdm.event.workflow.LimitApplicable;
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
@RosettaDataRule("LimitApplicableLimitApplicableChoice")
@ImplementedBy(LimitApplicableLimitApplicableChoice.Default.class)
public interface LimitApplicableLimitApplicableChoice extends Validator<LimitApplicable> {
	
	String NAME = "LimitApplicableLimitApplicableChoice";
	String DEFINITION = "optional choice amountUtilized, utilization";
	
	class Default implements LimitApplicableLimitApplicableChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LimitApplicable limitApplicable) {
			ComparisonResult result = executeDataRule(limitApplicable);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LimitApplicable", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LimitApplicable", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LimitApplicable limitApplicable) {
			try {
				return choice(MapperS.of(limitApplicable), Arrays.asList("amountUtilized", "utilization"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LimitApplicableLimitApplicableChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LimitApplicable limitApplicable) {
			return Collections.emptyList();
		}
	}
}
