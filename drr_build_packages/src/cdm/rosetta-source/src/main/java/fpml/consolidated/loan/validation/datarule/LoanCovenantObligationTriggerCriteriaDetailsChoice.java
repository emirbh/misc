package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationTriggerCriteriaDetails;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanCovenantObligationTriggerCriteriaDetailsChoice")
@ImplementedBy(LoanCovenantObligationTriggerCriteriaDetailsChoice.Default.class)
public interface LoanCovenantObligationTriggerCriteriaDetailsChoice extends Validator<LoanCovenantObligationTriggerCriteriaDetails> {
	
	String NAME = "LoanCovenantObligationTriggerCriteriaDetailsChoice";
	String DEFINITION = "one-of";
	
	class Default implements LoanCovenantObligationTriggerCriteriaDetailsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationTriggerCriteriaDetails loanCovenantObligationTriggerCriteriaDetails) {
			ComparisonResult result = executeDataRule(loanCovenantObligationTriggerCriteriaDetails);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationTriggerCriteriaDetails", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationTriggerCriteriaDetails", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanCovenantObligationTriggerCriteriaDetails loanCovenantObligationTriggerCriteriaDetails) {
			try {
				return choice(MapperS.of(loanCovenantObligationTriggerCriteriaDetails), Arrays.asList("date", "metric", "hybridCriteria"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanCovenantObligationTriggerCriteriaDetailsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationTriggerCriteriaDetails loanCovenantObligationTriggerCriteriaDetails) {
			return Collections.emptyList();
		}
	}
}
