package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionNotificationChoice1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionNotificationChoice1Choice")
@ImplementedBy(LoanLegalActionNotificationChoice1Choice.Default.class)
public interface LoanLegalActionNotificationChoice1Choice extends Validator<LoanLegalActionNotificationChoice1> {
	
	String NAME = "LoanLegalActionNotificationChoice1Choice";
	String DEFINITION = "optional choice dealIdentifier, dealSummary, loanLegalActionNotificationChoiceChoice0, loanLegalActionNotificationChoiceChoice1, loanLegalActionNotificationChoiceChoice2";
	
	class Default implements LoanLegalActionNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoice1 loanLegalActionNotificationChoice1) {
			ComparisonResult result = executeDataRule(loanLegalActionNotificationChoice1);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoice1", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoice1", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionNotificationChoice1 loanLegalActionNotificationChoice1) {
			try {
				return choice(MapperS.of(loanLegalActionNotificationChoice1), Arrays.asList("dealIdentifier", "dealSummary", "loanLegalActionNotificationChoiceChoice0", "loanLegalActionNotificationChoiceChoice1", "loanLegalActionNotificationChoiceChoice2"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoice1 loanLegalActionNotificationChoice1) {
			return Collections.emptyList();
		}
	}
}
