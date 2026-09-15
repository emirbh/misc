package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalActionStatementChoice")
@ImplementedBy(LoanLegalActionStatementChoice.Default.class)
public interface LoanLegalActionStatementChoice extends Validator<LoanLegalActionStatement> {
	
	String NAME = "LoanLegalActionStatementChoice";
	String DEFINITION = "optional choice dealIdentifier, dealSummary, deal";
	
	class Default implements LoanLegalActionStatementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatement loanLegalActionStatement) {
			ComparisonResult result = executeDataRule(loanLegalActionStatement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionStatement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalActionStatement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalActionStatement loanLegalActionStatement) {
			try {
				return choice(MapperS.of(loanLegalActionStatement), Arrays.asList("dealIdentifier", "dealSummary", "deal"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalActionStatementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatement loanLegalActionStatement) {
			return Collections.emptyList();
		}
	}
}
