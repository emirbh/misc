package cdm.ingest.fpml.confirmation.common.functions;

import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.fx.FxAmericanExercise;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxAmericanExerciseTerms.MapFxAmericanExerciseTermsDefault.class)
public abstract class MapFxAmericanExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxDigitalAmericanExercise mapFxDigitalAmericanExercise;

	/**
	* @param fpmlFxAmericanExercise 
	* @param cdmExerciseProcedure 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(FxAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlFxAmericanExercise, cdmExerciseProcedure);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(FxAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure);

	public static class MapFxAmericanExerciseTermsDefault extends MapFxAmericanExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(FxAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlFxAmericanExercise, cdmExerciseProcedure);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, FxAmericanExercise fpmlFxAmericanExercise, ExerciseProcedure cdmExerciseProcedure) {
			exerciseTerms = toBuilder(mapFxDigitalAmericanExercise.evaluate(fpmlFxAmericanExercise, cdmExerciseProcedure));
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
