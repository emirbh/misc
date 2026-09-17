package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionNotificationChoice")
@ImplementedBy(LoanLegalActionNotificationChoice.Default.class)
public interface LoanLegalActionNotificationChoice extends Validator<LoanLegalActionNotification> {
	
	String NAME = "LoanLegalActionNotificationChoice";
	String DEFINITION = "required choice legalActionIdentifier, legalActionSummary, legalAction";
	
	class Default implements LoanLegalActionNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotification loanLegalActionNotification) {
			ComparisonResult result = executeDataRule(loanLegalActionNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionNotification loanLegalActionNotification) {
			try {
				return choice(MapperS.of(loanLegalActionNotification), Arrays.asList("legalActionIdentifier", "legalActionSummary", "legalAction"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotification loanLegalActionNotification) {
			return Collections.emptyList();
		}
	}
}
