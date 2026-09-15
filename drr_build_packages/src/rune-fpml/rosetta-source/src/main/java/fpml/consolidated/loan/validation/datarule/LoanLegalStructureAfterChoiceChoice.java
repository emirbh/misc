package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalStructureAfterChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalStructureAfterChoiceChoice")
@ImplementedBy(LoanLegalStructureAfterChoiceChoice.Default.class)
public interface LoanLegalStructureAfterChoiceChoice extends Validator<LoanLegalStructureAfterChoice> {
	
	String NAME = "LoanLegalStructureAfterChoiceChoice";
	String DEFINITION = "optional choice contractReference, letterOfCreditReference";
	
	class Default implements LoanLegalStructureAfterChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureAfterChoice loanLegalStructureAfterChoice) {
			ComparisonResult result = executeDataRule(loanLegalStructureAfterChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalStructureAfterChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalStructureAfterChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalStructureAfterChoice loanLegalStructureAfterChoice) {
			try {
				return choice(MapperS.of(loanLegalStructureAfterChoice), Arrays.asList("contractReference", "letterOfCreditReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalStructureAfterChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureAfterChoice loanLegalStructureAfterChoice) {
			return Collections.emptyList();
		}
	}
}
