package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetailsChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanCovenantObligationDateTriggerDetailsChoiceChoice")
@ImplementedBy(LoanCovenantObligationDateTriggerDetailsChoiceChoice.Default.class)
public interface LoanCovenantObligationDateTriggerDetailsChoiceChoice extends Validator<LoanCovenantObligationDateTriggerDetailsChoice> {
	
	String NAME = "LoanCovenantObligationDateTriggerDetailsChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements LoanCovenantObligationDateTriggerDetailsChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationDateTriggerDetailsChoice loanCovenantObligationDateTriggerDetailsChoice) {
			ComparisonResult result = executeDataRule(loanCovenantObligationDateTriggerDetailsChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationDateTriggerDetailsChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationDateTriggerDetailsChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanCovenantObligationDateTriggerDetailsChoice loanCovenantObligationDateTriggerDetailsChoice) {
			try {
				return choice(MapperS.of(loanCovenantObligationDateTriggerDetailsChoice), Arrays.asList("dueDate", "frequencyType"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanCovenantObligationDateTriggerDetailsChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationDateTriggerDetailsChoice loanCovenantObligationDateTriggerDetailsChoice) {
			return Collections.emptyList();
		}
	}
}
