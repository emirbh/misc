package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationSummary;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanCovenantObligationSummaryChoice")
@ImplementedBy(LoanCovenantObligationSummaryChoice.Default.class)
public interface LoanCovenantObligationSummaryChoice extends Validator<LoanCovenantObligationSummary> {
	
	String NAME = "LoanCovenantObligationSummaryChoice";
	String DEFINITION = "required choice dealReference, facilityReference";
	
	class Default implements LoanCovenantObligationSummaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationSummary loanCovenantObligationSummary) {
			ComparisonResult result = executeDataRule(loanCovenantObligationSummary);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationSummary", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligationSummary", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanCovenantObligationSummary loanCovenantObligationSummary) {
			try {
				return choice(MapperS.of(loanCovenantObligationSummary), Arrays.asList("dealReference", "facilityReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanCovenantObligationSummaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationSummary loanCovenantObligationSummary) {
			return Collections.emptyList();
		}
	}
}
