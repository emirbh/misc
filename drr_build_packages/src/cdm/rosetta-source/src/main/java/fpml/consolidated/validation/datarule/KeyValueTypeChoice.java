package fpml.consolidated.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.KeyValueType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("KeyValueTypeChoice")
@ImplementedBy(KeyValueTypeChoice.Default.class)
public interface KeyValueTypeChoice extends Validator<KeyValueType> {
	
	String NAME = "KeyValueTypeChoice";
	String DEFINITION = "one-of";
	
	class Default implements KeyValueTypeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyValueType keyValueType) {
			ComparisonResult result = executeDataRule(keyValueType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "KeyValueType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "KeyValueType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(KeyValueType keyValueType) {
			try {
				return choice(MapperS.of(keyValueType), Arrays.asList("dsaKeyValue", "rsaKeyValue", "anyContents"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements KeyValueTypeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyValueType keyValueType) {
			return Collections.emptyList();
		}
	}
}
