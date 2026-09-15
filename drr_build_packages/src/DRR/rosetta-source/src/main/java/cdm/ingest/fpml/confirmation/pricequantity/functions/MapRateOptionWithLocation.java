package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Rate;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRateOptionWithLocation.MapRateOptionWithLocationDefault.class)
public abstract class MapRateOptionWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateInterestRateIndexWithLocation createInterestRateIndexWithLocation;
	@Inject protected CreateKey createKey;
	@Inject protected MapFloatingRateIndex mapFloatingRateIndex;
	@Inject protected MapInflationIndex mapInflationIndex;

	/**
	* @param fpmlRate 
	* @param fpmlLeg 
	* @return interestRateIndex 
	*/
	public FieldWithMetaInterestRateIndex evaluate(Rate fpmlRate, Leg fpmlLeg) {
		FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndexBuilder = doEvaluate(fpmlRate, fpmlLeg);
		
		final FieldWithMetaInterestRateIndex interestRateIndex;
		if (interestRateIndexBuilder == null) {
			interestRateIndex = null;
		} else {
			interestRateIndex = interestRateIndexBuilder.build();
			objectValidator.validate(FieldWithMetaInterestRateIndex.class, interestRateIndex);
		}
		
		return interestRateIndex;
	}

	protected abstract FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder doEvaluate(Rate fpmlRate, Leg fpmlLeg);

	protected abstract MapperS<Boolean> rateCalculationExists(Rate fpmlRate, Leg fpmlLeg);

	public static class MapRateOptionWithLocationDefault extends MapRateOptionWithLocation {
		@Override
		protected FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder doEvaluate(Rate fpmlRate, Leg fpmlLeg) {
			FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndex = FieldWithMetaInterestRateIndex.builder();
			return assignOutput(interestRateIndex, fpmlRate, fpmlLeg);
		}
		
		protected FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder assignOutput(FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder interestRateIndex, Rate fpmlRate, Leg fpmlLeg) {
			if (rateCalculationExists(fpmlRate, fpmlLeg).getOrDefault(false)) {
				final FloatingRateIndex ifThenElseResult0;
				if (fpmlRate == null) {
					ifThenElseResult0 = null;
				} else if (fpmlRate instanceof FloatingRateCalculation) {
					final FloatingRateCalculation floatingRateCalculation = (FloatingRateCalculation) fpmlRate;
					ifThenElseResult0 = mapFloatingRateIndex.evaluate(floatingRateCalculation);
				} else {
					ifThenElseResult0 = null;
				}
				final InflationIndex ifThenElseResult1;
				if (fpmlRate == null) {
					ifThenElseResult1 = null;
				} else if (fpmlRate instanceof InflationRateCalculation) {
					final InflationRateCalculation inflationRateCalculation = (InflationRateCalculation) fpmlRate;
					ifThenElseResult1 = mapInflationIndex.evaluate(inflationRateCalculation);
				} else {
					ifThenElseResult1 = null;
				}
				interestRateIndex = toBuilder(createInterestRateIndexWithLocation.evaluate(InterestRateIndex.builder()
					.setFloatingRateIndex(ifThenElseResult0)
					.setInflationIndex(ifThenElseResult1)
					.build(), createKey.evaluate("InterestRateIndex", null, fpmlLeg)));
			} else {
				interestRateIndex = toBuilder(FieldWithMetaInterestRateIndex.builder().build());
			}
			
			return Optional.ofNullable(interestRateIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Boolean> rateCalculationExists(Rate fpmlRate, Leg fpmlLeg) {
			if (fpmlRate == null) {
				return MapperS.<Boolean>ofNull();
			}
			if (fpmlRate instanceof FloatingRateCalculation) {
				final FloatingRateCalculation floatingRateCalculation = (FloatingRateCalculation) fpmlRate;
				return MapperS.of(true);
			}
			if (fpmlRate instanceof InflationRateCalculation) {
				final InflationRateCalculation inflationRateCalculation = (InflationRateCalculation) fpmlRate;
				return MapperS.of(true);
			}
			return MapperS.of(false);
		}
	}
}
