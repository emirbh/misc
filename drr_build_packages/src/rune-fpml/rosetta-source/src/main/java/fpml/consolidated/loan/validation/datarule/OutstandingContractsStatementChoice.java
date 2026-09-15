package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.OutstandingContractsStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OutstandingContractsStatementChoice")
@ImplementedBy(OutstandingContractsStatementChoice.Default.class)
public interface OutstandingContractsStatementChoice extends Validator<OutstandingContractsStatement> {
	
	String NAME = "OutstandingContractsStatementChoice";
	String DEFINITION = "optional choice dealIdentifier, dealSummary";
	
	class Default implements OutstandingContractsStatementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingContractsStatement outstandingContractsStatement) {
			ComparisonResult result = executeDataRule(outstandingContractsStatement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingContractsStatement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingContractsStatement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OutstandingContractsStatement outstandingContractsStatement) {
			try {
				return choice(MapperS.of(outstandingContractsStatement), Arrays.asList("dealIdentifier", "dealSummary"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OutstandingContractsStatementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingContractsStatement outstandingContractsStatement) {
			return Collections.emptyList();
		}
	}
}
