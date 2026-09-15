package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalStructureAfter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalStructureAfterChoice")
@ImplementedBy(LoanLegalStructureAfterChoice.Default.class)
public interface LoanLegalStructureAfterChoice extends Validator<LoanLegalStructureAfter> {
	
	String NAME = "LoanLegalStructureAfterChoice";
	String DEFINITION = "required choice dealReference, facilityReference";
	
	class Default implements LoanLegalStructureAfterChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureAfter loanLegalStructureAfter) {
			ComparisonResult result = executeDataRule(loanLegalStructureAfter);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalStructureAfter", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalStructureAfter", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalStructureAfter loanLegalStructureAfter) {
			try {
				return choice(MapperS.of(loanLegalStructureAfter), Arrays.asList("dealReference", "facilityReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalStructureAfterChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureAfter loanLegalStructureAfter) {
			return Collections.emptyList();
		}
	}
}
