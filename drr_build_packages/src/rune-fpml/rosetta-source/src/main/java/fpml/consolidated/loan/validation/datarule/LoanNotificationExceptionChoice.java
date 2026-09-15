package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanNotificationException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanNotificationExceptionChoice")
@ImplementedBy(LoanNotificationExceptionChoice.Default.class)
public interface LoanNotificationExceptionChoice extends Validator<LoanNotificationException> {
	
	String NAME = "LoanNotificationExceptionChoice";
	String DEFINITION = "optional choice eventIdentifier, taskIdentifier";
	
	class Default implements LoanNotificationExceptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationException loanNotificationException) {
			ComparisonResult result = executeDataRule(loanNotificationException);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanNotificationException", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanNotificationException", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanNotificationException loanNotificationException) {
			try {
				return choice(MapperS.of(loanNotificationException), Arrays.asList("eventIdentifier", "taskIdentifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanNotificationExceptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationException loanNotificationException) {
			return Collections.emptyList();
		}
	}
}
