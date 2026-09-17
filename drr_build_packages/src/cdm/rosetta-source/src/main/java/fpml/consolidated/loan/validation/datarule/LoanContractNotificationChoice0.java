package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanContractNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanContractNotificationChoice0")
@ImplementedBy(LoanContractNotificationChoice0.Default.class)
public interface LoanContractNotificationChoice0 extends Validator<LoanContractNotification> {
	
	String NAME = "LoanContractNotificationChoice0";
	String DEFINITION = "optional choice dealIdentifier, dealSummary";
	
	class Default implements LoanContractNotificationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContractNotification loanContractNotification) {
			ComparisonResult result = executeDataRule(loanContractNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContractNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContractNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanContractNotification loanContractNotification) {
			try {
				return choice(MapperS.of(loanContractNotification), Arrays.asList("dealIdentifier", "dealSummary"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanContractNotificationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContractNotification loanContractNotification) {
			return Collections.emptyList();
		}
	}
}
