package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxAmericanExercise;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.shared.Exercise;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlFxExercise.GetFpmlFxExerciseDefault.class)
public abstract class GetFpmlFxExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlFxOption 
	* @return fpmlExercise 
	*/
	public Exercise evaluate(FxOption fpmlFxOption) {
		Exercise.ExerciseBuilder fpmlExerciseBuilder = doEvaluate(fpmlFxOption);
		
		final Exercise fpmlExercise;
		if (fpmlExerciseBuilder == null) {
			fpmlExercise = null;
		} else {
			fpmlExercise = fpmlExerciseBuilder.build();
			objectValidator.validate(Exercise.class, fpmlExercise);
		}
		
		return fpmlExercise;
	}

	protected abstract Exercise.ExerciseBuilder doEvaluate(FxOption fpmlFxOption);

	public static class GetFpmlFxExerciseDefault extends GetFpmlFxExercise {
		@Override
		protected Exercise.ExerciseBuilder doEvaluate(FxOption fpmlFxOption) {
			Exercise.ExerciseBuilder fpmlExercise = Exercise.builder();
			return assignOutput(fpmlExercise, fpmlFxOption);
		}
		
		protected Exercise.ExerciseBuilder assignOutput(Exercise.ExerciseBuilder fpmlExercise, FxOption fpmlFxOption) {
			if (exists(MapperS.of(fpmlFxOption).<FxEuropeanExercise>map("getEuropeanExercise", fxOption -> fxOption.getEuropeanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlFxOption).<FxEuropeanExercise>map("getEuropeanExercise", fxOption -> fxOption.getEuropeanExercise()).get());
			} else if (exists(MapperS.of(fpmlFxOption).<FxAmericanExercise>map("getAmericanExercise", fxOption -> fxOption.getAmericanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlFxOption).<FxAmericanExercise>map("getAmericanExercise", fxOption -> fxOption.getAmericanExercise()).get());
			} else {
				fpmlExercise = null;
			}
			
			return Optional.ofNullable(fpmlExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
