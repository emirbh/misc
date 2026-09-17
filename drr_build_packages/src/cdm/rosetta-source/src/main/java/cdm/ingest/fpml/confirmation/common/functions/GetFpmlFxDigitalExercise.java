package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.shared.Exercise;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlFxDigitalExercise.GetFpmlFxDigitalExerciseDefault.class)
public abstract class GetFpmlFxDigitalExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlFxDigitalOption 
	* @return fpmlDigitalExercise 
	*/
	public Exercise evaluate(FxDigitalOption fpmlFxDigitalOption) {
		Exercise.ExerciseBuilder fpmlDigitalExerciseBuilder = doEvaluate(fpmlFxDigitalOption);
		
		final Exercise fpmlDigitalExercise;
		if (fpmlDigitalExerciseBuilder == null) {
			fpmlDigitalExercise = null;
		} else {
			fpmlDigitalExercise = fpmlDigitalExerciseBuilder.build();
			objectValidator.validate(Exercise.class, fpmlDigitalExercise);
		}
		
		return fpmlDigitalExercise;
	}

	protected abstract Exercise.ExerciseBuilder doEvaluate(FxDigitalOption fpmlFxDigitalOption);

	public static class GetFpmlFxDigitalExerciseDefault extends GetFpmlFxDigitalExercise {
		@Override
		protected Exercise.ExerciseBuilder doEvaluate(FxDigitalOption fpmlFxDigitalOption) {
			Exercise.ExerciseBuilder fpmlDigitalExercise = Exercise.builder();
			return assignOutput(fpmlDigitalExercise, fpmlFxDigitalOption);
		}
		
		protected Exercise.ExerciseBuilder assignOutput(Exercise.ExerciseBuilder fpmlDigitalExercise, FxDigitalOption fpmlFxDigitalOption) {
			if (exists(MapperS.of(fpmlFxDigitalOption).<FxEuropeanExercise>map("getEuropeanExercise", fxDigitalOption -> fxDigitalOption.getEuropeanExercise())).getOrDefault(false)) {
				fpmlDigitalExercise = toBuilder(MapperS.of(fpmlFxDigitalOption).<FxEuropeanExercise>map("getEuropeanExercise", fxDigitalOption -> fxDigitalOption.getEuropeanExercise()).get());
			} else if (exists(MapperS.of(fpmlFxDigitalOption).<FxDigitalAmericanExercise>map("getAmericanExercise", fxDigitalOption -> fxDigitalOption.getAmericanExercise())).getOrDefault(false)) {
				fpmlDigitalExercise = toBuilder(MapperS.of(fpmlFxDigitalOption).<FxDigitalAmericanExercise>map("getAmericanExercise", fxDigitalOption -> fxDigitalOption.getAmericanExercise()).get());
			} else {
				fpmlDigitalExercise = null;
			}
			
			return Optional.ofNullable(fpmlDigitalExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
