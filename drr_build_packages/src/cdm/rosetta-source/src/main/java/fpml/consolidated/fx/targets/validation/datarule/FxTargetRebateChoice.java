package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetRebate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetRebateChoice")
@ImplementedBy(FxTargetRebateChoice.Default.class)
public interface FxTargetRebateChoice extends Validator<FxTargetRebate> {
	
	String NAME = "FxTargetRebateChoice";
	String DEFINITION = "one-of";
	
	class Default implements FxTargetRebateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRebate fxTargetRebate) {
			ComparisonResult result = executeDataRule(fxTargetRebate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetRebate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetRebate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetRebate fxTargetRebate) {
			try {
				return choice(MapperS.of(fxTargetRebate), Arrays.asList("payment", "outstandingGain"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetRebateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRebate fxTargetRebate) {
			return Collections.emptyList();
		}
	}
}
