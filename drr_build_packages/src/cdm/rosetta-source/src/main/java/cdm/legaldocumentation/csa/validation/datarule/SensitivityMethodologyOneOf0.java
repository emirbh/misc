package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.SensitivityMethodology;
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
@RosettaDataRule("SensitivityMethodologyOneOf0")
@ImplementedBy(SensitivityMethodologyOneOf0.Default.class)
public interface SensitivityMethodologyOneOf0 extends Validator<SensitivityMethodology> {
	
	String NAME = "SensitivityMethodologyOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements SensitivityMethodologyOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityMethodology sensitivityMethodology) {
			ComparisonResult result = executeDataRule(sensitivityMethodology);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityMethodology", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityMethodology", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SensitivityMethodology sensitivityMethodology) {
			try {
				return choice(MapperS.of(sensitivityMethodology), Arrays.asList("specifiedMethodology", "customMethodology"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SensitivityMethodologyOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityMethodology sensitivityMethodology) {
			return Collections.emptyList();
		}
	}
}
