package cdm.legaldocumentation.transaction.validation.datarule;

import cdm.legaldocumentation.transaction.Clause;
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
@RosettaDataRule("ClauseChoice0")
@ImplementedBy(ClauseChoice0.Default.class)
public interface ClauseChoice0 extends Validator<Clause> {
	
	String NAME = "ClauseChoice0";
	String DEFINITION = "optional choice terms, subcomponents";
	
	class Default implements ClauseChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Clause clause) {
			ComparisonResult result = executeDataRule(clause);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Clause", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Clause", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Clause clause) {
			try {
				return choice(MapperS.of(clause), Arrays.asList("terms", "subcomponents"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClauseChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Clause clause) {
			return Collections.emptyList();
		}
	}
}
