package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApplicableTransactions;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ApplicableTransactionsChoice")
@ImplementedBy(ApplicableTransactionsChoice.Default.class)
public interface ApplicableTransactionsChoice extends Validator<ApplicableTransactions> {
	
	String NAME = "ApplicableTransactionsChoice";
	String DEFINITION = "one-of";
	
	class Default implements ApplicableTransactionsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableTransactions applicableTransactions) {
			ComparisonResult result = executeDataRule(applicableTransactions);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableTransactions", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableTransactions", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ApplicableTransactions applicableTransactions) {
			try {
				return choice(MapperS.of(applicableTransactions), Arrays.asList("applicableTransactionType", "allTransactions"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ApplicableTransactionsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableTransactions applicableTransactions) {
			return Collections.emptyList();
		}
	}
}
