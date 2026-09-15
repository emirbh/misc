package cdm.ingest.fpml.confirmation.common.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.product.template.MultipleExercise;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.NotionalReference;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMultipleExercise.MapMultipleExerciseDefault.class)
public abstract class MapMultipleExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlMultipleExercise 
	* @return multipleExercise 
	*/
	public MultipleExercise evaluate(fpml.consolidated.shared.MultipleExercise fpmlMultipleExercise) {
		MultipleExercise.MultipleExerciseBuilder multipleExerciseBuilder = doEvaluate(fpmlMultipleExercise);
		
		final MultipleExercise multipleExercise;
		if (multipleExerciseBuilder == null) {
			multipleExercise = null;
		} else {
			multipleExercise = multipleExerciseBuilder.build();
			objectValidator.validate(MultipleExercise.class, multipleExercise);
		}
		
		return multipleExercise;
	}

	protected abstract MultipleExercise.MultipleExerciseBuilder doEvaluate(fpml.consolidated.shared.MultipleExercise fpmlMultipleExercise);

	public static class MapMultipleExerciseDefault extends MapMultipleExercise {
		@Override
		protected MultipleExercise.MultipleExerciseBuilder doEvaluate(fpml.consolidated.shared.MultipleExercise fpmlMultipleExercise) {
			MultipleExercise.MultipleExerciseBuilder multipleExercise = MultipleExercise.builder();
			return assignOutput(multipleExercise, fpmlMultipleExercise);
		}
		
		protected MultipleExercise.MultipleExerciseBuilder assignOutput(MultipleExercise.MultipleExerciseBuilder multipleExercise, fpml.consolidated.shared.MultipleExercise fpmlMultipleExercise) {
			final BigDecimal bigDecimal0 = MapperS.of(fpmlMultipleExercise).<BigDecimal>map("getMinimumNumberOfOptions", _multipleExercise -> _multipleExercise.getMinimumNumberOfOptions()).get();
			final BigDecimal bigDecimal1 = MapperS.of(fpmlMultipleExercise).<BigDecimal>map("getMaximumNumberOfOptions", _multipleExercise -> _multipleExercise.getMaximumNumberOfOptions()).get();
			multipleExercise = toBuilder(MultipleExercise.builder()
				.setIntegralMultipleAmount(MapperS.of(fpmlMultipleExercise).<BigDecimal>map("getIntegralMultipleAmount", _multipleExercise -> _multipleExercise.getIntegralMultipleAmount()).get())
				.setMinimumNumberOfOptions((bigDecimal0 == null ? null : bigDecimal0.intValueExact()))
				.setMaximumNumberOfOptions((bigDecimal1 == null ? null : bigDecimal1.intValueExact()))
				.setMinimumNotionalAmount(MapperS.of(fpmlMultipleExercise).<BigDecimal>map("getMinimumNotionalAmount", _multipleExercise -> _multipleExercise.getMinimumNotionalAmount()).get())
				.setNotionaReference(ReferenceWithMetaMoney.builder().setValue(null).setExternalReference(MapperS.of(fpmlMultipleExercise).<NotionalReference>mapC("getNotionalReference", _multipleExercise -> _multipleExercise.getNotionalReference()).<String>map("getHref", notionalReference -> notionalReference.getHref())
					.first().get()).build())
				.build());
			
			return Optional.ofNullable(multipleExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
