package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalStructureBefore;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanLegalStructureBeforeChoice")
@ImplementedBy(LoanLegalStructureBeforeChoice.Default.class)
public interface LoanLegalStructureBeforeChoice extends Validator<LoanLegalStructureBefore> {
	
	String NAME = "LoanLegalStructureBeforeChoice";
	String DEFINITION = "required choice dealReference, facilityReference";
	
	class Default implements LoanLegalStructureBeforeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureBefore loanLegalStructureBefore) {
			ComparisonResult result = executeDataRule(loanLegalStructureBefore);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalStructureBefore", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanLegalStructureBefore", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanLegalStructureBefore loanLegalStructureBefore) {
			try {
				return choice(MapperS.of(loanLegalStructureBefore), Arrays.asList("dealReference", "facilityReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanLegalStructureBeforeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureBefore loanLegalStructureBefore) {
			return Collections.emptyList();
		}
	}
}
