package fpml.consolidated.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.TransformTypeChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TransformTypeChoiceChoice")
@ImplementedBy(TransformTypeChoiceChoice.Default.class)
public interface TransformTypeChoiceChoice extends Validator<TransformTypeChoice> {
	
	String NAME = "TransformTypeChoiceChoice";
	String DEFINITION = "optional choice anyContents, xPath";
	
	class Default implements TransformTypeChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransformTypeChoice transformTypeChoice) {
			ComparisonResult result = executeDataRule(transformTypeChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TransformTypeChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TransformTypeChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TransformTypeChoice transformTypeChoice) {
			try {
				return choice(MapperS.of(transformTypeChoice), Arrays.asList("anyContents", "xPath"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TransformTypeChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransformTypeChoice transformTypeChoice) {
			return Collections.emptyList();
		}
	}
}
