package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetLeverage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetLeverageChoice0")
@ImplementedBy(FxTargetLeverageChoice0.Default.class)
public interface FxTargetLeverageChoice0 extends Validator<FxTargetLeverage> {
	
	String NAME = "FxTargetLeverageChoice0";
	String DEFINITION = "required choice level, strikeReference, pivotReference, barrierReference, levelReference";
	
	class Default implements FxTargetLeverageChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverage fxTargetLeverage) {
			ComparisonResult result = executeDataRule(fxTargetLeverage);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetLeverage", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetLeverage", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetLeverage fxTargetLeverage) {
			try {
				return choice(MapperS.of(fxTargetLeverage), Arrays.asList("level", "strikeReference", "pivotReference", "barrierReference", "levelReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetLeverageChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverage fxTargetLeverage) {
			return Collections.emptyList();
		}
	}
}
