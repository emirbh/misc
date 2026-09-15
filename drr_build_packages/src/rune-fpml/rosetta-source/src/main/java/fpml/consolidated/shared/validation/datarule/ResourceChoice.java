package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ResourceChoice")
@ImplementedBy(ResourceChoice.Default.class)
public interface ResourceChoice extends Validator<Resource> {
	
	String NAME = "ResourceChoice";
	String DEFINITION = "optional choice string, hexadecimalBinary, base64Binary, url";
	
	class Default implements ResourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Resource resource) {
			ComparisonResult result = executeDataRule(resource);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Resource", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Resource", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Resource resource) {
			try {
				return choice(MapperS.of(resource), Arrays.asList("string", "hexadecimalBinary", "base64Binary", "url"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ResourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Resource resource) {
			return Collections.emptyList();
		}
	}
}
