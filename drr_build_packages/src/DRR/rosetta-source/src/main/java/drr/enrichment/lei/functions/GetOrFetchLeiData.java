package drr.enrichment.lei.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.lei.LeiData;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetOrFetchLeiData.GetOrFetchLeiDataDefault.class)
public abstract class GetOrFetchLeiData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected API_GetLeiData aPI_GetLeiData;

	/**
	* @param preEnriched Pre-enriched LEI data.
	* @param lei LEI to be fetched from API.
	* @return leiData 
	*/
	public LeiData evaluate(List<? extends LeiData> preEnriched, String lei) {
		LeiData.LeiDataBuilder leiDataBuilder = doEvaluate(preEnriched, lei);
		
		final LeiData leiData;
		if (leiDataBuilder == null) {
			leiData = null;
		} else {
			leiData = leiDataBuilder.build();
			objectValidator.validate(LeiData.class, leiData);
		}
		
		return leiData;
	}

	protected abstract LeiData.LeiDataBuilder doEvaluate(List<? extends LeiData> preEnriched, String lei);

	protected abstract MapperS<? extends LeiData> preEnrichedDataForLei(List<? extends LeiData> preEnriched, String lei);

	protected abstract MapperS<Boolean> isEnabled(List<? extends LeiData> preEnriched, String lei);

	public static class GetOrFetchLeiDataDefault extends GetOrFetchLeiData {
		@Override
		protected LeiData.LeiDataBuilder doEvaluate(List<? extends LeiData> preEnriched, String lei) {
			if (preEnriched == null) {
				preEnriched = Collections.emptyList();
			}
			LeiData.LeiDataBuilder leiData = LeiData.builder();
			return assignOutput(leiData, preEnriched, lei);
		}
		
		protected LeiData.LeiDataBuilder assignOutput(LeiData.LeiDataBuilder leiData, List<? extends LeiData> preEnriched, String lei) {
			if (areEqual(isEnabled(preEnriched, lei), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				leiData = null;
			} else if (exists(preEnrichedDataForLei(preEnriched, lei)).getOrDefault(false)) {
				leiData = toBuilder(preEnrichedDataForLei(preEnriched, lei).get());
			} else {
				leiData = toBuilder(aPI_GetLeiData.evaluate(lei));
			}
			
			return Optional.ofNullable(leiData)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends LeiData> preEnrichedDataForLei(List<? extends LeiData> preEnriched, String lei) {
			final MapperC<LeiData> thenArg = MapperC.<LeiData>of(preEnriched)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getLei", leiData -> leiData.getLei()), MapperS.of(lei), CardinalityOperator.All).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<Boolean> isEnabled(List<? extends LeiData> preEnriched, String lei) {
			final MapperC<LeiData> thenArg0 = MapperC.<LeiData>of(preEnriched)
				.filterItemNullSafe(item -> notExists(item.<String>map("getLei", leiData -> leiData.getLei())).get());
			final MapperC<Boolean> thenArg1 = thenArg0
				.mapItem(item -> item.<Boolean>map("getLeiValidation", leiData -> leiData.getLeiValidation()));
			return exists(MapperS.of(lei)).andNullSafe(exists(preEnrichedDataForLei(preEnriched, lei)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(preEnrichedDataForLei(preEnriched, lei).<Boolean>map("getLeiValidation", leiData -> leiData.getLeiValidation()).getOrDefault(true)))).orNullSafe(notExists(preEnrichedDataForLei(preEnriched, lei)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(MapperS.of(distinctIgnoringPrecision(thenArg1).get()).getOrDefault(true)))))).asMapper();
		}
	}
}
