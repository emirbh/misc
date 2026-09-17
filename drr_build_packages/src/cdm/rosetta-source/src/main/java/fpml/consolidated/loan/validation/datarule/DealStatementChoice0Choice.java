package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealStatementChoice0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DealStatementChoice0Choice")
@ImplementedBy(DealStatementChoice0Choice.Default.class)
public interface DealStatementChoice0Choice extends Validator<DealStatementChoice0> {
	
	String NAME = "DealStatementChoice0Choice";
	String DEFINITION = "one-of";
	
	class Default implements DealStatementChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealStatementChoice0 dealStatementChoice0) {
			ComparisonResult result = executeDataRule(dealStatementChoice0);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DealStatementChoice0", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DealStatementChoice0", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DealStatementChoice0 dealStatementChoice0) {
			try {
				return choice(MapperS.of(dealStatementChoice0), Arrays.asList("dealIdentifier", "dealSummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DealStatementChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealStatementChoice0 dealStatementChoice0) {
			return Collections.emptyList();
		}
	}
}
