package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanCovenantObligationNotificationChoice2Choice")
@ImplementedBy(LoanCovenantObligationNotificationChoice2Choice.Default.class)
public interface LoanCovenantObligationNotificationChoice2Choice extends Validator<LoanCovenantObligationNotificationChoice2> {
	
	String NAME = "LoanCovenantObligationNotificationChoice2Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanCovenantObligationNotificationChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
			ComparisonResult result = executeDataRule(loanCovenantObligationNotificationChoice2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationNotificationChoice2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationNotificationChoice2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
			try {
				return choice(MapperS.of(loanCovenantObligationNotificationChoice2), Arrays.asList("facilityIdentifier", "facilitySummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanCovenantObligationNotificationChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
			return Collections.emptyList();
		}
	}
}
