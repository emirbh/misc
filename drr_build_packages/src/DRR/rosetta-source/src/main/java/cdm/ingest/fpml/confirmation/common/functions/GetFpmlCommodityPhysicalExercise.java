package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityPhysicalAmericanExercise;
import fpml.consolidated.com.CommodityPhysicalEuropeanExercise;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.shared.Exercise;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlCommodityPhysicalExercise.GetFpmlCommodityPhysicalExerciseDefault.class)
public abstract class GetFpmlCommodityPhysicalExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityPhysicalExercise 
	* @return fpmlExercise 
	*/
	public Exercise evaluate(CommodityPhysicalExercise fpmlCommodityPhysicalExercise) {
		Exercise.ExerciseBuilder fpmlExerciseBuilder = doEvaluate(fpmlCommodityPhysicalExercise);
		
		final Exercise fpmlExercise;
		if (fpmlExerciseBuilder == null) {
			fpmlExercise = null;
		} else {
			fpmlExercise = fpmlExerciseBuilder.build();
			objectValidator.validate(Exercise.class, fpmlExercise);
		}
		
		return fpmlExercise;
	}

	protected abstract Exercise.ExerciseBuilder doEvaluate(CommodityPhysicalExercise fpmlCommodityPhysicalExercise);

	public static class GetFpmlCommodityPhysicalExerciseDefault extends GetFpmlCommodityPhysicalExercise {
		@Override
		protected Exercise.ExerciseBuilder doEvaluate(CommodityPhysicalExercise fpmlCommodityPhysicalExercise) {
			Exercise.ExerciseBuilder fpmlExercise = Exercise.builder();
			return assignOutput(fpmlExercise, fpmlCommodityPhysicalExercise);
		}
		
		protected Exercise.ExerciseBuilder assignOutput(Exercise.ExerciseBuilder fpmlExercise, CommodityPhysicalExercise fpmlCommodityPhysicalExercise) {
			if (exists(MapperS.of(fpmlCommodityPhysicalExercise).<CommodityPhysicalEuropeanExercise>map("getEuropeanExercise", commodityPhysicalExercise -> commodityPhysicalExercise.getEuropeanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlCommodityPhysicalExercise).<CommodityPhysicalEuropeanExercise>map("getEuropeanExercise", commodityPhysicalExercise -> commodityPhysicalExercise.getEuropeanExercise()).get());
			} else if (exists(MapperS.of(fpmlCommodityPhysicalExercise).<CommodityPhysicalAmericanExercise>map("getAmericanExercise", commodityPhysicalExercise -> commodityPhysicalExercise.getAmericanExercise())).getOrDefault(false)) {
				fpmlExercise = toBuilder(MapperS.of(fpmlCommodityPhysicalExercise).<CommodityPhysicalAmericanExercise>map("getAmericanExercise", commodityPhysicalExercise -> commodityPhysicalExercise.getAmericanExercise()).get());
			} else {
				fpmlExercise = null;
			}
			
			return Optional.ofNullable(fpmlExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
