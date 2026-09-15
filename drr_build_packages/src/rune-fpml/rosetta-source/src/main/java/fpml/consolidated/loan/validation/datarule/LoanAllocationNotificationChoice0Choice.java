package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationNotificationChoice0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanAllocationNotificationChoice0Choice")
@ImplementedBy(LoanAllocationNotificationChoice0Choice.Default.class)
public interface LoanAllocationNotificationChoice0Choice extends Validator<LoanAllocationNotificationChoice0> {
	
	String NAME = "LoanAllocationNotificationChoice0Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanAllocationNotificationChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice0 loanAllocationNotificationChoice0) {
			ComparisonResult result = executeDataRule(loanAllocationNotificationChoice0);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotificationChoice0", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotificationChoice0", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanAllocationNotificationChoice0 loanAllocationNotificationChoice0) {
			try {
				return choice(MapperS.of(loanAllocationNotificationChoice0), Arrays.asList("loanAllocationEventGroup", "settlementTask"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanAllocationNotificationChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice0 loanAllocationNotificationChoice0) {
			return Collections.emptyList();
		}
	}
}
