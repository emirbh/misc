package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.com.CommodityExercise;
import fpml.consolidated.shared.Exercise;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlCommodityExercise.GetFpmlCommodityExerciseDefault.class)
public abstract class GetFpmlCommodityExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityExercise 
	* @return fpmlExercise 
	*/
	public Exercise evaluate(CommodityExercise fpmlCommodityExercise) {
		Exercise.ExerciseBuilder fpmlExerciseBuilder = doEvaluate(fpmlCommodityExercise);
		
		final Exercise fpmlExercise;
		if (fpmlExerciseBuilder == null) {
			fpmlExercise = null;
		} else {
			fpmlExercise = fpmlExerciseBuilder.build();
			objectValidator.validate(Exercise.class, fpmlExercise);
		}
		
		return fpmlExercise;
	}

	protected abstract Exercise.ExerciseBuilder doEvaluate(CommodityExercise fpmlCommodityExercise);

	public static class GetFpmlCommodityExerciseDefault extends GetFpmlCommodityExercise {
		@Override
		protected Exercise.ExerciseBuilder doEvaluate(CommodityExercise fpmlCommodityExercise) {
			Exercise.ExerciseBuilder fpmlExercise = Exercise.builder();
			return assignOutput(fpmlExercise, fpmlCommodityExercise);
		}
		
		protected Exercise.ExerciseBuilder assignOutput(Exercise.ExerciseBuilder fpmlExercise, CommodityExercise fpmlCommodityExercise) {
			if (exists(MapperS.of(fpmlCommodityExercise).<CommodityEuropeanExercise>map("getEuropeanExercise", commodityExercise -> commodityExercise.getEuropeanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlCommodityExercise).<CommodityEuropeanExercise>map("getEuropeanExercise", commodityExercise -> commodityExercise.getEuropeanExercise()).get());
			} else if (exists(MapperS.of(fpmlCommodityExercise).<CommodityAmericanExercise>map("getAmericanExercise", commodityExercise -> commodityExercise.getAmericanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlCommodityExercise).<CommodityAmericanExercise>map("getAmericanExercise", commodityExercise -> commodityExercise.getAmericanExercise()).get());
			} else {
				fpmlExercise = null;
			}
			
			return Optional.ofNullable(fpmlExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
