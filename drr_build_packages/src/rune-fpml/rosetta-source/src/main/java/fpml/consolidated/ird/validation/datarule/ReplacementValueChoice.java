package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ReplacementValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ReplacementValueChoice")
@ImplementedBy(ReplacementValueChoice.Default.class)
public interface ReplacementValueChoice extends Validator<ReplacementValue> {
	
	String NAME = "ReplacementValueChoice";
	String DEFINITION = "one-of";
	
	class Default implements ReplacementValueChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReplacementValue replacementValue) {
			ComparisonResult result = executeDataRule(replacementValue);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReplacementValue", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReplacementValue", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReplacementValue replacementValue) {
			try {
				return choice(MapperS.of(replacementValue), Arrays.asList("firmQuotations", "calculationAgentDetermination"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReplacementValueChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReplacementValue replacementValue) {
			return Collections.emptyList();
		}
	}
}
