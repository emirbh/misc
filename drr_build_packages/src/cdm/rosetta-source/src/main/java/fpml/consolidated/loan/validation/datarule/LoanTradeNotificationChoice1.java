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
@RosettaDataRule("LoanTradeNotificationChoice1")
@ImplementedBy(LoanTradeNotificationChoice1.Default.class)
public interface LoanTradeNotificationChoice1 extends Validator<LoanTradeNotification> {
	
	String NAME = "LoanTradeNotificationChoice1";
	String DEFINITION = "required choice tradeIdentifier, tradeSummary, trade";
	
	class Default implements LoanTradeNotificationChoice1 {
	
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
				return choice(MapperS.of(loanTradeNotification), Arrays.asList("tradeIdentifier", "tradeSummary", "trade"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTradeNotificationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeNotification loanTradeNotification) {
			return Collections.emptyList();
		}
	}
}
