package drr.standards.iso.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.MicData;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetOrFetchMicData.GetOrFetchMicDataDefault.class)
public abstract class GetOrFetchMicData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected API_GetMicData aPI_GetMicData;

	/**
	* @param preEnriched Pre-enriched MIC data.
	* @param mic MIC to be fetched from API.
	* @return micData 
	*/
	public MicData evaluate(List<? extends MicData> preEnriched, String mic) {
		MicData.MicDataBuilder micDataBuilder = doEvaluate(preEnriched, mic);
		
		final MicData micData;
		if (micDataBuilder == null) {
			micData = null;
		} else {
			micData = micDataBuilder.build();
			objectValidator.validate(MicData.class, micData);
		}
		
		return micData;
	}

	protected abstract MicData.MicDataBuilder doEvaluate(List<? extends MicData> preEnriched, String mic);

	protected abstract MapperS<? extends MicData> preEnrichedMicData(List<? extends MicData> preEnriched, String mic);

	protected abstract MapperS<Boolean> isEnabled(List<? extends MicData> preEnriched, String mic);

	public static class GetOrFetchMicDataDefault extends GetOrFetchMicData {
		@Override
		protected MicData.MicDataBuilder doEvaluate(List<? extends MicData> preEnriched, String mic) {
			if (preEnriched == null) {
				preEnriched = Collections.emptyList();
			}
			MicData.MicDataBuilder micData = MicData.builder();
			return assignOutput(micData, preEnriched, mic);
		}
		
		protected MicData.MicDataBuilder assignOutput(MicData.MicDataBuilder micData, List<? extends MicData> preEnriched, String mic) {
			if (areEqual(isEnabled(preEnriched, mic), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				micData = null;
			} else if (exists(preEnrichedMicData(preEnriched, mic)).getOrDefault(false)) {
				micData = toBuilder(preEnrichedMicData(preEnriched, mic).get());
			} else {
				micData = toBuilder(aPI_GetMicData.evaluate(mic));
			}
			
			return Optional.ofNullable(micData)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends MicData> preEnrichedMicData(List<? extends MicData> preEnriched, String mic) {
			final MapperC<MicData> thenArg = MapperC.<MicData>of(preEnriched)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getMic", micData -> micData.getMic()), MapperS.of(mic), CardinalityOperator.All).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<Boolean> isEnabled(List<? extends MicData> preEnriched, String mic) {
			final MapperC<MicData> thenArg0 = MapperC.<MicData>of(preEnriched)
				.filterItemNullSafe(item -> notExists(item.<String>map("getMic", micData -> micData.getMic())).get());
			final MapperC<Boolean> thenArg1 = thenArg0
				.mapItem(item -> item.<Boolean>map("getMicValidation", micData -> micData.getMicValidation()));
			return exists(MapperS.of(mic)).andNullSafe(exists(preEnrichedMicData(preEnriched, mic)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(preEnrichedMicData(preEnriched, mic).<Boolean>map("getMicValidation", micData -> micData.getMicValidation()).getOrDefault(true)))).orNullSafe(notExists(preEnrichedMicData(preEnriched, mic)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(MapperS.of(distinctIgnoringPrecision(thenArg1).get()).getOrDefault(true)))))).asMapper();
		}
	}
}
