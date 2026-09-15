package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealStatementChoice2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DealStatementChoice2Choice")
@ImplementedBy(DealStatementChoice2Choice.Default.class)
public interface DealStatementChoice2Choice extends Validator<DealStatementChoice2> {
	
	String NAME = "DealStatementChoice2Choice";
	String DEFINITION = "one-of";
	
	class Default implements DealStatementChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealStatementChoice2 dealStatementChoice2) {
			ComparisonResult result = executeDataRule(dealStatementChoice2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DealStatementChoice2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DealStatementChoice2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DealStatementChoice2 dealStatementChoice2) {
			try {
				return choice(MapperS.of(dealStatementChoice2), Arrays.asList("facilityIdentifier", "facilitySummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DealStatementChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealStatementChoice2 dealStatementChoice2) {
			return Collections.emptyList();
		}
	}
}
