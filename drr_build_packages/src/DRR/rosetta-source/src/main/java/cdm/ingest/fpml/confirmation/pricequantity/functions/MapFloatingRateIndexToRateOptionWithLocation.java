package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriod;
import cdm.ingest.fpml.confirmation.other.functions.MapFloatingRateIndexEnum;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Period;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFloatingRateIndexToRateOptionWithLocation.MapFloatingRateIndexToRateOptionWithLocationDefault.class)
public abstract class MapFloatingRateIndexToRateOptionWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateInterestRateIndexWithLocation createInterestRateIndexWithLocation;
	@Inject protected CreateKey createKey;
	@Inject protected MapFloatingRateIndexEnum mapFloatingRateIndexEnum;
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlFloatingRateIndex 
	* @param fpmlIndexTenor 
	* @param fpmlLeg 
	* @return interestRateIndex 
	*/
	public FieldWithMetaInterestRateIndex evaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
		FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndexBuilder = doEvaluate(fpmlFloatingRateIndex, fpmlIndexTenor, fpmlLeg);
		
		final FieldWithMetaInterestRateIndex interestRateIndex;
		if (interestRateIndexBuilder == null) {
			interestRateIndex = null;
		} else {
			interestRateIndex = interestRateIndexBuilder.build();
			objectValidator.validate(FieldWithMetaInterestRateIndex.class, interestRateIndex);
		}
		
		return interestRateIndex;
	}

	protected abstract FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder doEvaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg);

	public static class MapFloatingRateIndexToRateOptionWithLocationDefault extends MapFloatingRateIndexToRateOptionWithLocation {
		@Override
		protected FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder doEvaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
			FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndex = FieldWithMetaInterestRateIndex.builder();
			return assignOutput(interestRateIndex, fpmlFloatingRateIndex, fpmlIndexTenor, fpmlLeg);
		}
		
		protected FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder assignOutput(FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndex, FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFloatingRateIndex)).andNullSafe(exists(MapperS.of(fpmlIndexTenor))).getOrDefault(false)) {
				final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
					.setIdentifierValue(MapperS.of(fpmlFloatingRateIndex).<String>map("getValue", floatingRateIndex -> floatingRateIndex.getValue()).get())
					.setIdentifierType(AssetIdTypeEnum.OTHER)
					.build();
				interestRateIndex = toBuilder(createInterestRateIndexWithLocation.evaluate(InterestRateIndex.builder()
					.setFloatingRateIndex(cdm.observable.asset.FloatingRateIndex.builder()
						.setIdentifier((assetIdentifier == null ? Collections.<AssetIdentifier>emptyList() : Collections.singletonList(assetIdentifier)))
						.setAssetClass(AssetClassEnum.INTEREST_RATE)
						.setFloatingRateIndexValue(mapFloatingRateIndexEnum.evaluate(MapperS.of(fpmlFloatingRateIndex).<String>map("getValue", floatingRateIndex -> floatingRateIndex.getValue()).get()))
						.setIndexTenor(mapPeriod.evaluate(fpmlIndexTenor))
						.build())
					.build(), createKey.evaluate("InterestRateIndex", null, fpmlLeg)));
			} else {
				interestRateIndex = toBuilder(FieldWithMetaInterestRateIndex.builder().build());
			}
			
			return Optional.ofNullable(interestRateIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
