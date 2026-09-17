package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanBulkServicingNotificationSequenceChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanBulkServicingNotificationSequenceChoiceChoice")
@ImplementedBy(LoanBulkServicingNotificationSequenceChoiceChoice.Default.class)
public interface LoanBulkServicingNotificationSequenceChoiceChoice extends Validator<LoanBulkServicingNotificationSequenceChoice> {
	
	String NAME = "LoanBulkServicingNotificationSequenceChoiceChoice";
	String DEFINITION = "optional choice letterOfCreditIdentifier, letterOfCreditSummary, letterOfCredit, contractIdentifier, contractSummary, contract";
	
	class Default implements LoanBulkServicingNotificationSequenceChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotificationSequenceChoice loanBulkServicingNotificationSequenceChoice) {
			ComparisonResult result = executeDataRule(loanBulkServicingNotificationSequenceChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationSequenceChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationSequenceChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanBulkServicingNotificationSequenceChoice loanBulkServicingNotificationSequenceChoice) {
			try {
				return choice(MapperS.of(loanBulkServicingNotificationSequenceChoice), Arrays.asList("letterOfCreditIdentifier", "letterOfCreditSummary", "letterOfCredit", "contractIdentifier", "contractSummary", "contract"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanBulkServicingNotificationSequenceChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotificationSequenceChoice loanBulkServicingNotificationSequenceChoice) {
			return Collections.emptyList();
		}
	}
}
