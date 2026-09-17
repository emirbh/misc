package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionNotificationChoiceChoice0Choice")
@ImplementedBy(LoanLegalActionNotificationChoiceChoice0Choice.Default.class)
public interface LoanLegalActionNotificationChoiceChoice0Choice extends Validator<LoanLegalActionNotificationChoiceChoice0> {
	
	String NAME = "LoanLegalActionNotificationChoiceChoice0Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanLegalActionNotificationChoiceChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
			ComparisonResult result = executeDataRule(loanLegalActionNotificationChoiceChoice0);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoiceChoice0", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoiceChoice0", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
			try {
				return choice(MapperS.of(loanLegalActionNotificationChoiceChoice0), Arrays.asList("facilityIdentifier", "facilitySummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionNotificationChoiceChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
			return Collections.emptyList();
		}
	}
}
