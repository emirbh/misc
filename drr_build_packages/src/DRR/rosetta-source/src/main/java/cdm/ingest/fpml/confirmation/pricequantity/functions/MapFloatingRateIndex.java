package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriod;
import cdm.ingest.fpml.confirmation.other.functions.MapFloatingRateIndexEnum;
import cdm.observable.asset.FloatingRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.Period;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingRateIndex.MapFloatingRateIndexDefault.class)
public abstract class MapFloatingRateIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFloatingRateIndexEnum mapFloatingRateIndexEnum;
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlFloatingRateCalculation 
	* @return floatingRateIndex 
	*/
	public FloatingRateIndex evaluate(FloatingRateCalculation fpmlFloatingRateCalculation) {
		FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndexBuilder = doEvaluate(fpmlFloatingRateCalculation);
		
		final FloatingRateIndex floatingRateIndex;
		if (floatingRateIndexBuilder == null) {
			floatingRateIndex = null;
		} else {
			floatingRateIndex = floatingRateIndexBuilder.build();
			objectValidator.validate(FloatingRateIndex.class, floatingRateIndex);
		}
		
		return floatingRateIndex;
	}

	protected abstract FloatingRateIndex.FloatingRateIndexBuilder doEvaluate(FloatingRateCalculation fpmlFloatingRateCalculation);

	public static class MapFloatingRateIndexDefault extends MapFloatingRateIndex {
		@Override
		protected FloatingRateIndex.FloatingRateIndexBuilder doEvaluate(FloatingRateCalculation fpmlFloatingRateCalculation) {
			FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex = FloatingRateIndex.builder();
			return assignOutput(floatingRateIndex, fpmlFloatingRateCalculation);
		}
		
		protected FloatingRateIndex.FloatingRateIndexBuilder assignOutput(FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex, FloatingRateCalculation fpmlFloatingRateCalculation) {
			final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
				.setIdentifierValue(MapperS.of(fpmlFloatingRateCalculation).<fpml.consolidated.shared.FloatingRateIndex>map("getFloatingRateIndex", floatingRateCalculation -> floatingRateCalculation.getFloatingRateIndex()).<String>map("getValue", _floatingRateIndex -> _floatingRateIndex.getValue()).get())
				.setIdentifierType(AssetIdTypeEnum.OTHER)
				.build();
			floatingRateIndex = toBuilder(FloatingRateIndex.builder()
				.setIdentifier((assetIdentifier == null ? Collections.<AssetIdentifier>emptyList() : Collections.singletonList(assetIdentifier)))
				.setAssetClass(AssetClassEnum.INTEREST_RATE)
				.setFloatingRateIndexValue(mapFloatingRateIndexEnum.evaluate(MapperS.of(fpmlFloatingRateCalculation).<fpml.consolidated.shared.FloatingRateIndex>map("getFloatingRateIndex", floatingRateCalculation -> floatingRateCalculation.getFloatingRateIndex()).<String>map("getValue", _floatingRateIndex -> _floatingRateIndex.getValue()).get()))
				.setIndexTenor(mapPeriod.evaluate(MapperS.of(fpmlFloatingRateCalculation).<Period>map("getIndexTenor", floatingRateCalculation -> floatingRateCalculation.getIndexTenor()).get()))
				.build());
			
			return Optional.ofNullable(floatingRateIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
