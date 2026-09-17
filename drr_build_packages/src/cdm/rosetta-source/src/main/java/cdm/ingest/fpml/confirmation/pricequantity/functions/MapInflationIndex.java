package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriod;
import cdm.ingest.fpml.confirmation.other.functions.MapInflationRateIndexEnum;
import cdm.observable.asset.InflationIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInflationIndex.MapInflationIndexDefault.class)
public abstract class MapInflationIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInflationRateIndexEnum mapInflationRateIndexEnum;
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlInflationRateCalculation 
	* @return inflationIndex 
	*/
	public InflationIndex evaluate(InflationRateCalculation fpmlInflationRateCalculation) {
		InflationIndex.InflationIndexBuilder inflationIndexBuilder = doEvaluate(fpmlInflationRateCalculation);
		
		final InflationIndex inflationIndex;
		if (inflationIndexBuilder == null) {
			inflationIndex = null;
		} else {
			inflationIndex = inflationIndexBuilder.build();
			objectValidator.validate(InflationIndex.class, inflationIndex);
		}
		
		return inflationIndex;
	}

	protected abstract InflationIndex.InflationIndexBuilder doEvaluate(InflationRateCalculation fpmlInflationRateCalculation);

	public static class MapInflationIndexDefault extends MapInflationIndex {
		@Override
		protected InflationIndex.InflationIndexBuilder doEvaluate(InflationRateCalculation fpmlInflationRateCalculation) {
			InflationIndex.InflationIndexBuilder inflationIndex = InflationIndex.builder();
			return assignOutput(inflationIndex, fpmlInflationRateCalculation);
		}
		
		protected InflationIndex.InflationIndexBuilder assignOutput(InflationIndex.InflationIndexBuilder inflationIndex, InflationRateCalculation fpmlInflationRateCalculation) {
			inflationIndex = toBuilder(InflationIndex.builder()
				.setIdentifier(Collections.<AssetIdentifier>emptyList())
				.setAssetClass(AssetClassEnum.INTEREST_RATE)
				.setInflationRateIndexValue(mapInflationRateIndexEnum.evaluate(MapperS.of(fpmlInflationRateCalculation).<FloatingRateIndex>map("getFloatingRateIndex", inflationRateCalculation -> inflationRateCalculation.getFloatingRateIndex()).<String>map("getValue", floatingRateIndex -> floatingRateIndex.getValue()).get()))
				.setIndexTenor(mapPeriod.evaluate(MapperS.of(fpmlInflationRateCalculation).<Period>map("getIndexTenor", inflationRateCalculation -> inflationRateCalculation.getIndexTenor()).get()))
				.build());
			
			return Optional.ofNullable(inflationIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
