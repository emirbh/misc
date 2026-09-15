package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanAllocationNotificationChoice0")
@ImplementedBy(LoanAllocationNotificationChoice0.Default.class)
public interface LoanAllocationNotificationChoice0 extends Validator<LoanAllocationNotification> {
	
	String NAME = "LoanAllocationNotificationChoice0";
	String DEFINITION = "required choice tradeIdentifier, tradeSummary";
	
	class Default implements LoanAllocationNotificationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotification loanAllocationNotification) {
			ComparisonResult result = executeDataRule(loanAllocationNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanAllocationNotification loanAllocationNotification) {
			try {
				return choice(MapperS.of(loanAllocationNotification), Arrays.asList("tradeIdentifier", "tradeSummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanAllocationNotificationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotification loanAllocationNotification) {
			return Collections.emptyList();
		}
	}
}
