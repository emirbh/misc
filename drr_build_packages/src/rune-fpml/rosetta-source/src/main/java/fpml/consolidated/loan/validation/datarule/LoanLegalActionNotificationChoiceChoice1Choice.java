package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionNotificationChoiceChoice1Choice")
@ImplementedBy(LoanLegalActionNotificationChoiceChoice1Choice.Default.class)
public interface LoanLegalActionNotificationChoiceChoice1Choice extends Validator<LoanLegalActionNotificationChoiceChoice1> {
	
	String NAME = "LoanLegalActionNotificationChoiceChoice1Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanLegalActionNotificationChoiceChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoiceChoice1 loanLegalActionNotificationChoiceChoice1) {
			ComparisonResult result = executeDataRule(loanLegalActionNotificationChoiceChoice1);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoiceChoice1", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoiceChoice1", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionNotificationChoiceChoice1 loanLegalActionNotificationChoiceChoice1) {
			try {
				return choice(MapperS.of(loanLegalActionNotificationChoiceChoice1), Arrays.asList("contractIdentifier", "contractSummary", "contract"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionNotificationChoiceChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoiceChoice1 loanLegalActionNotificationChoiceChoice1) {
			return Collections.emptyList();
		}
	}
}
