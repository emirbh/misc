package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Documentation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DocumentationChoice")
@ImplementedBy(DocumentationChoice.Default.class)
public interface DocumentationChoice extends Validator<Documentation> {
	
	String NAME = "DocumentationChoice";
	String DEFINITION = "optional choice masterConfirmation, brokerConfirmation";
	
	class Default implements DocumentationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Documentation documentation) {
			ComparisonResult result = executeDataRule(documentation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Documentation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Documentation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Documentation documentation) {
			try {
				return choice(MapperS.of(documentation), Arrays.asList("masterConfirmation", "brokerConfirmation"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DocumentationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Documentation documentation) {
			return Collections.emptyList();
		}
	}
}
