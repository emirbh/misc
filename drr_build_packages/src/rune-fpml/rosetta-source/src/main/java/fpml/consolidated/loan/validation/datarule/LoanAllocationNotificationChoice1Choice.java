package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationNotificationChoice1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanAllocationNotificationChoice1Choice")
@ImplementedBy(LoanAllocationNotificationChoice1Choice.Default.class)
public interface LoanAllocationNotificationChoice1Choice extends Validator<LoanAllocationNotificationChoice1> {
	
	String NAME = "LoanAllocationNotificationChoice1Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanAllocationNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
			ComparisonResult result = executeDataRule(loanAllocationNotificationChoice1);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotificationChoice1", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotificationChoice1", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
			try {
				return choice(MapperS.of(loanAllocationNotificationChoice1), Arrays.asList("allocationId", "allocationSummary", "allocation"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanAllocationNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
			return Collections.emptyList();
		}
	}
}
