package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.Resource;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ResourceResourceChoice")
@ImplementedBy(ResourceResourceChoice.Default.class)
public interface ResourceResourceChoice extends Validator<Resource> {
	
	String NAME = "ResourceResourceChoice";
	String DEFINITION = "optional choice string, url";
	
	class Default implements ResourceResourceChoice {
	
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
				return choice(MapperS.of(resource), Arrays.asList("string", "url"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ResourceResourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Resource resource) {
			return Collections.emptyList();
		}
	}
}
