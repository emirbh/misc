package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionStatementChoice2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionStatementChoice2Choice")
@ImplementedBy(LoanLegalActionStatementChoice2Choice.Default.class)
public interface LoanLegalActionStatementChoice2Choice extends Validator<LoanLegalActionStatementChoice2> {
	
	String NAME = "LoanLegalActionStatementChoice2Choice";
	String DEFINITION = "one-of";
	
	class Default implements LoanLegalActionStatementChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatementChoice2 loanLegalActionStatementChoice2) {
			ComparisonResult result = executeDataRule(loanLegalActionStatementChoice2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionStatementChoice2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionStatementChoice2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionStatementChoice2 loanLegalActionStatementChoice2) {
			try {
				return choice(MapperS.of(loanLegalActionStatementChoice2), Arrays.asList("letterOfCreditIdentifier", "letterOfCreditSummary", "letterOfCredit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionStatementChoice2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatementChoice2 loanLegalActionStatementChoice2) {
			return Collections.emptyList();
		}
	}
}
