package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionNotificationChoice0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionNotificationChoice0Choice")
@ImplementedBy(LoanLegalActionNotificationChoice0Choice.Default.class)
public interface LoanLegalActionNotificationChoice0Choice extends Validator<LoanLegalActionNotificationChoice0> {
	
	String NAME = "LoanLegalActionNotificationChoice0Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanLegalActionNotificationChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoice0 loanLegalActionNotificationChoice0) {
			ComparisonResult result = executeDataRule(loanLegalActionNotificationChoice0);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoice0", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionNotificationChoice0", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionNotificationChoice0 loanLegalActionNotificationChoice0) {
			try {
				return choice(MapperS.of(loanLegalActionNotificationChoice0), Arrays.asList("facilityEventGroup", "lcEventGroup", "loanContractEventGroup", "legalActionTask", "legalActionStatus", "legalActionApprovalStatus"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionNotificationChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoice0 loanLegalActionNotificationChoice0) {
			return Collections.emptyList();
		}
	}
}
