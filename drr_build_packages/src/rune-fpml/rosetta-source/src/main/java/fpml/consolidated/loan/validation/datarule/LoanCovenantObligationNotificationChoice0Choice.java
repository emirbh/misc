package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanCovenantObligationNotificationChoice0Choice")
@ImplementedBy(LoanCovenantObligationNotificationChoice0Choice.Default.class)
public interface LoanCovenantObligationNotificationChoice0Choice extends Validator<LoanCovenantObligationNotificationChoice0> {
	
	String NAME = "LoanCovenantObligationNotificationChoice0Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanCovenantObligationNotificationChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0) {
			ComparisonResult result = executeDataRule(loanCovenantObligationNotificationChoice0);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationNotificationChoice0", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationNotificationChoice0", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0) {
			try {
				return choice(MapperS.of(loanCovenantObligationNotificationChoice0), Arrays.asList("dealIdentifier", "dealSummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanCovenantObligationNotificationChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0) {
			return Collections.emptyList();
		}
	}
}
