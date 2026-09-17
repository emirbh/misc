package cdm.product.template.validation.datarule;

import cdm.product.template.MultipleExercise;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("MultipleExerciseMinimumNumberOfOptions")
@ImplementedBy(MultipleExerciseMinimumNumberOfOptions.Default.class)
public interface MultipleExerciseMinimumNumberOfOptions extends Validator<MultipleExercise> {
	
	String NAME = "MultipleExerciseMinimumNumberOfOptions";
	String DEFINITION = "if minimumNumberOfOptions exists then minimumNumberOfOptions >= 0";
	
	class Default implements MultipleExerciseMinimumNumberOfOptions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleExercise multipleExercise) {
			ComparisonResult result = executeDataRule(multipleExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MultipleExercise multipleExercise) {
			try {
				if (exists(MapperS.of(multipleExercise).<Integer>map("getMinimumNumberOfOptions", _multipleExercise -> _multipleExercise.getMinimumNumberOfOptions())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(multipleExercise).<Integer>map("getMinimumNumberOfOptions", _multipleExercise -> _multipleExercise.getMinimumNumberOfOptions()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MultipleExerciseMinimumNumberOfOptions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleExercise multipleExercise) {
			return Collections.emptyList();
		}
	}
}
