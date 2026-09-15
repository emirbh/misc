package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LegalActionIdentifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LegalActionIdentifierChoice")
@ImplementedBy(LegalActionIdentifierChoice.Default.class)
public interface LegalActionIdentifierChoice extends Validator<LegalActionIdentifier> {
	
	String NAME = "LegalActionIdentifierChoice";
	String DEFINITION = "required choice legalActionId, versionedLegalActionId";
	
	class Default implements LegalActionIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalActionIdentifier legalActionIdentifier) {
			ComparisonResult result = executeDataRule(legalActionIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalActionIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalActionIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegalActionIdentifier legalActionIdentifier) {
			try {
				return choice(MapperS.of(legalActionIdentifier), Arrays.asList("legalActionId", "versionedLegalActionId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegalActionIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalActionIdentifier legalActionIdentifier) {
			return Collections.emptyList();
		}
	}
}
