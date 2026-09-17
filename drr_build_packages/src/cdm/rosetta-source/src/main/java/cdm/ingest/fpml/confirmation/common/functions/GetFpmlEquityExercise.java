package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityAmericanExercise;
import fpml.consolidated.eqd.EquityBermudaExercise;
import fpml.consolidated.eqd.EquityEuropeanExercise;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.shared.Exercise;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlEquityExercise.GetFpmlEquityExerciseDefault.class)
public abstract class GetFpmlEquityExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlEquityExercise 
	* @return fpmlExercise 
	*/
	public Exercise evaluate(EquityExerciseValuationSettlement fpmlEquityExercise) {
		Exercise.ExerciseBuilder fpmlExerciseBuilder = doEvaluate(fpmlEquityExercise);
		
		final Exercise fpmlExercise;
		if (fpmlExerciseBuilder == null) {
			fpmlExercise = null;
		} else {
			fpmlExercise = fpmlExerciseBuilder.build();
			objectValidator.validate(Exercise.class, fpmlExercise);
		}
		
		return fpmlExercise;
	}

	protected abstract Exercise.ExerciseBuilder doEvaluate(EquityExerciseValuationSettlement fpmlEquityExercise);

	public static class GetFpmlEquityExerciseDefault extends GetFpmlEquityExercise {
		@Override
		protected Exercise.ExerciseBuilder doEvaluate(EquityExerciseValuationSettlement fpmlEquityExercise) {
			Exercise.ExerciseBuilder fpmlExercise = Exercise.builder();
			return assignOutput(fpmlExercise, fpmlEquityExercise);
		}
		
		protected Exercise.ExerciseBuilder assignOutput(Exercise.ExerciseBuilder fpmlExercise, EquityExerciseValuationSettlement fpmlEquityExercise) {
			if (exists(MapperS.of(fpmlEquityExercise).<EquityEuropeanExercise>map("getEquityEuropeanExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getEquityEuropeanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlEquityExercise).<EquityEuropeanExercise>map("getEquityEuropeanExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getEquityEuropeanExercise()).get());
			} else if (exists(MapperS.of(fpmlEquityExercise).<EquityBermudaExercise>map("getEquityBermudaExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getEquityBermudaExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlEquityExercise).<EquityBermudaExercise>map("getEquityBermudaExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getEquityBermudaExercise()).get());
			} else if (exists(MapperS.of(fpmlEquityExercise).<EquityAmericanExercise>map("getEquityAmericanExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getEquityAmericanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlEquityExercise).<EquityAmericanExercise>map("getEquityAmericanExercise", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getEquityAmericanExercise()).get());
			} else {
				fpmlExercise = null;
			}
			
			return Optional.ofNullable(fpmlExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
