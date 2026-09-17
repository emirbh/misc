package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradeNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanTradeNotificationChoice3")
@ImplementedBy(LoanTradeNotificationChoice3.Default.class)
public interface LoanTradeNotificationChoice3 extends Validator<LoanTradeNotification> {
	
	String NAME = "LoanTradeNotificationChoice3";
	String DEFINITION = "required choice facilityIdentifier, facilitySummary";
	
	class Default implements LoanTradeNotificationChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeNotification loanTradeNotification) {
			ComparisonResult result = executeDataRule(loanTradeNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradeNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradeNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanTradeNotification loanTradeNotification) {
			try {
				return choice(MapperS.of(loanTradeNotification), Arrays.asList("facilityIdentifier", "facilitySummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTradeNotificationChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeNotification loanTradeNotification) {
			return Collections.emptyList();
		}
	}
}
