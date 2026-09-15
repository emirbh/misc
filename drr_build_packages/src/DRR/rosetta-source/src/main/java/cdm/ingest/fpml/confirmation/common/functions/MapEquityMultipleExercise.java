package cdm.ingest.fpml.confirmation.common.functions;

import cdm.product.template.MultipleExercise;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityMultipleExercise;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityMultipleExercise.MapEquityMultipleExerciseDefault.class)
public abstract class MapEquityMultipleExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlEquityMultipleExercise 
	* @return multipleExercise 
	*/
	public MultipleExercise evaluate(EquityMultipleExercise fpmlEquityMultipleExercise) {
		MultipleExercise.MultipleExerciseBuilder multipleExerciseBuilder = doEvaluate(fpmlEquityMultipleExercise);
		
		final MultipleExercise multipleExercise;
		if (multipleExerciseBuilder == null) {
			multipleExercise = null;
		} else {
			multipleExercise = multipleExerciseBuilder.build();
			objectValidator.validate(MultipleExercise.class, multipleExercise);
		}
		
		return multipleExercise;
	}

	protected abstract MultipleExercise.MultipleExerciseBuilder doEvaluate(EquityMultipleExercise fpmlEquityMultipleExercise);

	public static class MapEquityMultipleExerciseDefault extends MapEquityMultipleExercise {
		@Override
		protected MultipleExercise.MultipleExerciseBuilder doEvaluate(EquityMultipleExercise fpmlEquityMultipleExercise) {
			MultipleExercise.MultipleExerciseBuilder multipleExercise = MultipleExercise.builder();
			return assignOutput(multipleExercise, fpmlEquityMultipleExercise);
		}
		
		protected MultipleExercise.MultipleExerciseBuilder assignOutput(MultipleExercise.MultipleExerciseBuilder multipleExercise, EquityMultipleExercise fpmlEquityMultipleExercise) {
			final BigDecimal bigDecimal0 = MapperS.of(fpmlEquityMultipleExercise).<BigDecimal>map("getMinimumNumberOfOptions", equityMultipleExercise -> equityMultipleExercise.getMinimumNumberOfOptions()).get();
			final BigDecimal bigDecimal1 = MapperS.of(fpmlEquityMultipleExercise).<BigDecimal>map("getMaximumNumberOfOptions", equityMultipleExercise -> equityMultipleExercise.getMaximumNumberOfOptions()).get();
			multipleExercise = toBuilder(MultipleExercise.builder()
				.setIntegralMultipleAmount(MapperS.of(fpmlEquityMultipleExercise).<BigDecimal>map("getIntegralMultipleExercise", equityMultipleExercise -> equityMultipleExercise.getIntegralMultipleExercise()).get())
				.setMinimumNumberOfOptions((bigDecimal0 == null ? null : bigDecimal0.intValueExact()))
				.setMaximumNumberOfOptions((bigDecimal1 == null ? null : bigDecimal1.intValueExact()))
				.setNotionaReferenceValue(null)
				.build());
			
			return Optional.ofNullable(multipleExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
