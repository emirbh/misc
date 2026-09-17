package fpml.consolidated.option.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.StrategyFeature;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("StrategyFeatureChoice")
@ImplementedBy(StrategyFeatureChoice.Default.class)
public interface StrategyFeatureChoice extends Validator<StrategyFeature> {
	
	String NAME = "StrategyFeatureChoice";
	String DEFINITION = "one-of";
	
	class Default implements StrategyFeatureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrategyFeature strategyFeature) {
			ComparisonResult result = executeDataRule(strategyFeature);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StrategyFeature", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "StrategyFeature", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(StrategyFeature strategyFeature) {
			try {
				return choice(MapperS.of(strategyFeature), Arrays.asList("strikeSpread", "calendarSpread"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StrategyFeatureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrategyFeature strategyFeature) {
			return Collections.emptyList();
		}
	}
}
