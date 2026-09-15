package fpml.consolidated.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.KeyInfoTypeChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("KeyInfoTypeChoiceChoice")
@ImplementedBy(KeyInfoTypeChoiceChoice.Default.class)
public interface KeyInfoTypeChoiceChoice extends Validator<KeyInfoTypeChoice> {
	
	String NAME = "KeyInfoTypeChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements KeyInfoTypeChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyInfoTypeChoice keyInfoTypeChoice) {
			ComparisonResult result = executeDataRule(keyInfoTypeChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "KeyInfoTypeChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "KeyInfoTypeChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(KeyInfoTypeChoice keyInfoTypeChoice) {
			try {
				return choice(MapperS.of(keyInfoTypeChoice), Arrays.asList("keyName", "keyValue", "retrievalMethod", "x509Data", "pgpData", "spkiData", "mgmtData", "anyContents"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements KeyInfoTypeChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyInfoTypeChoice keyInfoTypeChoice) {
			return Collections.emptyList();
		}
	}
}
