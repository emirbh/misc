package fpml.consolidated.riskdef.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.SensitivityDefinitionChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SensitivityDefinitionChoiceChoice")
@ImplementedBy(SensitivityDefinitionChoiceChoice.Default.class)
public interface SensitivityDefinitionChoiceChoice extends Validator<SensitivityDefinitionChoice> {
	
	String NAME = "SensitivityDefinitionChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements SensitivityDefinitionChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinitionChoice sensitivityDefinitionChoice) {
			ComparisonResult result = executeDataRule(sensitivityDefinitionChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDefinitionChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDefinitionChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SensitivityDefinitionChoice sensitivityDefinitionChoice) {
			try {
				return choice(MapperS.of(sensitivityDefinitionChoice), Arrays.asList("coordinate", "coordinateReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SensitivityDefinitionChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinitionChoice sensitivityDefinitionChoice) {
			return Collections.emptyList();
		}
	}
}
