package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxOptionChoice")
@ImplementedBy(FxOptionChoice.Default.class)
public interface FxOptionChoice extends Validator<FxOption> {
	
	String NAME = "FxOptionChoice";
	String DEFINITION = "optional choice americanExercise, europeanExercise";
	
	class Default implements FxOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOption fxOption) {
			ComparisonResult result = executeDataRule(fxOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxOption fxOption) {
			try {
				return choice(MapperS.of(fxOption), Arrays.asList("americanExercise", "europeanExercise"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOption fxOption) {
			return Collections.emptyList();
		}
	}
}
