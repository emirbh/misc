package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.OutstandingContractsStatementChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OutstandingContractsStatementChoiceChoice")
@ImplementedBy(OutstandingContractsStatementChoiceChoice.Default.class)
public interface OutstandingContractsStatementChoiceChoice extends Validator<OutstandingContractsStatementChoice> {
	
	String NAME = "OutstandingContractsStatementChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements OutstandingContractsStatementChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
			ComparisonResult result = executeDataRule(outstandingContractsStatementChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingContractsStatementChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingContractsStatementChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
			try {
				return choice(MapperS.of(outstandingContractsStatementChoice), Arrays.asList("loanContract", "letterOfCredit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OutstandingContractsStatementChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
			return Collections.emptyList();
		}
	}
}
