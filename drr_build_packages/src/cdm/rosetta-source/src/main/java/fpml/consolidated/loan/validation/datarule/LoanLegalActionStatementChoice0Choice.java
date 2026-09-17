package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionStatementChoice0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionStatementChoice0Choice")
@ImplementedBy(LoanLegalActionStatementChoice0Choice.Default.class)
public interface LoanLegalActionStatementChoice0Choice extends Validator<LoanLegalActionStatementChoice0> {
	
	String NAME = "LoanLegalActionStatementChoice0Choice";
	String DEFINITION = "optional choice facilityIdentifier, facilitySummary, facilityGroup";
	
	class Default implements LoanLegalActionStatementChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatementChoice0 loanLegalActionStatementChoice0) {
			ComparisonResult result = executeDataRule(loanLegalActionStatementChoice0);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionStatementChoice0", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionStatementChoice0", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionStatementChoice0 loanLegalActionStatementChoice0) {
			try {
				return choice(MapperS.of(loanLegalActionStatementChoice0), Arrays.asList("facilityIdentifier", "facilitySummary", "facilityGroup"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionStatementChoice0Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatementChoice0 loanLegalActionStatementChoice0) {
			return Collections.emptyList();
		}
	}
}
