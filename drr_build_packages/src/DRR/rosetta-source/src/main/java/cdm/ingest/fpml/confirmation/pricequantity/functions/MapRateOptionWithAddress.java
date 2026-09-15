package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
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


@ImplementedBy(MapRateOptionWithAddress.MapRateOptionWithAddressDefault.class)
public abstract class MapRateOptionWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateInterestRateIndexWithAddress createInterestRateIndexWithAddress;
	@Inject protected CreateKey createKey;

	/**
	* @param fpmlRate 
	* @param fpmlLeg 
	* @return rateOption 
	*/
	public ReferenceWithMetaInterestRateIndex evaluate(Rate fpmlRate, Leg fpmlLeg) {
		ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder rateOptionBuilder = doEvaluate(fpmlRate, fpmlLeg);
		
		final ReferenceWithMetaInterestRateIndex rateOption;
		if (rateOptionBuilder == null) {
			rateOption = null;
		} else {
			rateOption = rateOptionBuilder.build();
			objectValidator.validate(ReferenceWithMetaInterestRateIndex.class, rateOption);
		}
		
		return rateOption;
	}

	protected abstract ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder doEvaluate(Rate fpmlRate, Leg fpmlLeg);

	protected abstract MapperS<Boolean> isRateCalculation(Rate fpmlRate, Leg fpmlLeg);

	public static class MapRateOptionWithAddressDefault extends MapRateOptionWithAddress {
		@Override
		protected ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder doEvaluate(Rate fpmlRate, Leg fpmlLeg) {
			ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder rateOption = ReferenceWithMetaInterestRateIndex.builder();
			return assignOutput(rateOption, fpmlRate, fpmlLeg);
		}
		
		protected ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder assignOutput(ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder rateOption, Rate fpmlRate, Leg fpmlLeg) {
			if (isRateCalculation(fpmlRate, fpmlLeg).getOrDefault(false)) {
				rateOption = toBuilder(createInterestRateIndexWithAddress.evaluate(createKey.evaluate("InterestRateIndex", null, fpmlLeg)));
			} else {
				rateOption = toBuilder(ReferenceWithMetaInterestRateIndex.builder().build());
			}
			
			return Optional.ofNullable(rateOption)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Boolean> isRateCalculation(Rate fpmlRate, Leg fpmlLeg) {
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
