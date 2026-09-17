package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanCovenantObligationNotificationChoice1Choice")
@ImplementedBy(LoanCovenantObligationNotificationChoice1Choice.Default.class)
public interface LoanCovenantObligationNotificationChoice1Choice extends Validator<LoanCovenantObligationNotificationChoice1> {
	
	String NAME = "LoanCovenantObligationNotificationChoice1Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanCovenantObligationNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
			ComparisonResult result = executeDataRule(loanCovenantObligationNotificationChoice1);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationNotificationChoice1", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationNotificationChoice1", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
			try {
				return choice(MapperS.of(loanCovenantObligationNotificationChoice1), Arrays.asList("covenantIdentifier", "covenantSummary", "covenant"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanCovenantObligationNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
			return Collections.emptyList();
		}
	}
}
