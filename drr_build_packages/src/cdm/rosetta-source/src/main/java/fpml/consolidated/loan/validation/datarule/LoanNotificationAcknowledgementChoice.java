package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanNotificationAcknowledgement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanNotificationAcknowledgementChoice")
@ImplementedBy(LoanNotificationAcknowledgementChoice.Default.class)
public interface LoanNotificationAcknowledgementChoice extends Validator<LoanNotificationAcknowledgement> {
	
	String NAME = "LoanNotificationAcknowledgementChoice";
	String DEFINITION = "required choice eventIdentifier, taskIdentifier";
	
	class Default implements LoanNotificationAcknowledgementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationAcknowledgement loanNotificationAcknowledgement) {
			ComparisonResult result = executeDataRule(loanNotificationAcknowledgement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanNotificationAcknowledgement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanNotificationAcknowledgement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanNotificationAcknowledgement loanNotificationAcknowledgement) {
			try {
				return choice(MapperS.of(loanNotificationAcknowledgement), Arrays.asList("eventIdentifier", "taskIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanNotificationAcknowledgementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationAcknowledgement loanNotificationAcknowledgement) {
			return Collections.emptyList();
		}
	}
}
