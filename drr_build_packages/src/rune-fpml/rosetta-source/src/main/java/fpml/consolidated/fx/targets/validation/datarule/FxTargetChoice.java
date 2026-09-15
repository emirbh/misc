package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTarget;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetChoice")
@ImplementedBy(FxTargetChoice.Default.class)
public interface FxTargetChoice extends Validator<FxTarget> {
	
	String NAME = "FxTargetChoice";
	String DEFINITION = "required choice knockoutLevel, knockoutCount";
	
	class Default implements FxTargetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTarget fxTarget) {
			ComparisonResult result = executeDataRule(fxTarget);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTarget", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTarget", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTarget fxTarget) {
			try {
				return choice(MapperS.of(fxTarget), Arrays.asList("knockoutLevel", "knockoutCount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTarget fxTarget) {
			return Collections.emptyList();
		}
	}
}
