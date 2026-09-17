package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.fpmlenum.ExerciseTimingEnum;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OptionExerciseChoice0")
@ImplementedBy(OptionExerciseChoice0.Default.class)
public interface OptionExerciseChoice0 extends Validator<OptionExercise> {
	
	String NAME = "OptionExerciseChoice0";
	String DEFINITION = "exerciseTiming is absent or exerciseDate is absent and exerciseTime is absent";
	
	class Default implements OptionExerciseChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise optionExercise) {
			ComparisonResult result = executeDataRule(optionExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionExercise optionExercise) {
			try {
				return notExists(MapperS.of(optionExercise).<ExerciseTimingEnum>map("getExerciseTiming", _optionExercise -> _optionExercise.getExerciseTiming())).orNullSafe(notExists(MapperS.of(optionExercise).<ZonedDateTime>map("getExerciseDate", _optionExercise -> _optionExercise.getExerciseDate())).andNullSafe(notExists(MapperS.of(optionExercise).<LocalTime>map("getExerciseTime", _optionExercise -> _optionExercise.getExerciseTime()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExerciseChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise optionExercise) {
			return Collections.emptyList();
		}
	}
}
