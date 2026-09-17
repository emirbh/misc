package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationNotificationChoice2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanAllocationNotificationChoice2Choice")
@ImplementedBy(LoanAllocationNotificationChoice2Choice.Default.class)
public interface LoanAllocationNotificationChoice2Choice extends Validator<LoanAllocationNotificationChoice2> {
	
	String NAME = "LoanAllocationNotificationChoice2Choice";
	String DEFINITION = "optional choice letterOfCreditIdentifier, letterOfCreditSummary, letterOfCredit, contractIdentifier, contractSummary, contract";
	
	class Default implements LoanAllocationNotificationChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice2 loanAllocationNotificationChoice2) {
			ComparisonResult result = executeDataRule(loanAllocationNotificationChoice2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotificationChoice2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotificationChoice2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanAllocationNotificationChoice2 loanAllocationNotificationChoice2) {
			try {
				return choice(MapperS.of(loanAllocationNotificationChoice2), Arrays.asList("letterOfCreditIdentifier", "letterOfCreditSummary", "letterOfCredit", "contractIdentifier", "contractSummary", "contract"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanAllocationNotificationChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice2 loanAllocationNotificationChoice2) {
			return Collections.emptyList();
		}
	}
}
