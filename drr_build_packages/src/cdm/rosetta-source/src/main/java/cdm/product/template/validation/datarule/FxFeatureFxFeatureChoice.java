package cdm.product.template.validation.datarule;

import cdm.product.template.FxFeature;
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
@RosettaDataRule("FxFeatureFxFeatureChoice")
@ImplementedBy(FxFeatureFxFeatureChoice.Default.class)
public interface FxFeatureFxFeatureChoice extends Validator<FxFeature> {
	
	String NAME = "FxFeatureFxFeatureChoice";
	String DEFINITION = "required choice composite, quanto, crossCurrency";
	
	class Default implements FxFeatureFxFeatureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFeature fxFeature) {
			ComparisonResult result = executeDataRule(fxFeature);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFeature", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFeature", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxFeature fxFeature) {
			try {
				return choice(MapperS.of(fxFeature), Arrays.asList("composite", "quanto", "crossCurrency"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFeatureFxFeatureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFeature fxFeature) {
			return Collections.emptyList();
		}
	}
}
