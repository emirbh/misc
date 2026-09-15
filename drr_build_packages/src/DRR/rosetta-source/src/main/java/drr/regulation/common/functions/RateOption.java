package drr.regulation.common.functions;

import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(RateOption.RateOptionDefault.class)
public abstract class RateOption implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param interestRatePayout 
	* @return rateOption 
	*/
	public InterestRateIndex evaluate(InterestRatePayout interestRatePayout) {
		InterestRateIndex.InterestRateIndexBuilder rateOptionBuilder = doEvaluate(interestRatePayout);
		
		final InterestRateIndex rateOption;
		if (rateOptionBuilder == null) {
			rateOption = null;
		} else {
			rateOption = rateOptionBuilder.build();
			objectValidator.validate(InterestRateIndex.class, rateOption);
		}
		
		return rateOption;
	}

	protected abstract InterestRateIndex.InterestRateIndexBuilder doEvaluate(InterestRatePayout interestRatePayout);

	public static class RateOptionDefault extends RateOption {
		@Override
		protected InterestRateIndex.InterestRateIndexBuilder doEvaluate(InterestRatePayout interestRatePayout) {
			InterestRateIndex.InterestRateIndexBuilder rateOption = InterestRateIndex.builder();
			return assignOutput(rateOption, interestRatePayout);
		}
		
		protected InterestRateIndex.InterestRateIndexBuilder assignOutput(InterestRateIndex.InterestRateIndexBuilder rateOption, InterestRatePayout interestRatePayout) {
			if (exists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).getOrDefault(false)) {
				final ReferenceWithMetaInterestRateIndex referenceWithMetaInterestRateIndex0 = MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).get();
				if (referenceWithMetaInterestRateIndex0 == null) {
					rateOption = null;
				} else {
					rateOption = toBuilder(referenceWithMetaInterestRateIndex0.getValue());
				}
			} else if (exists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())).getOrDefault(false)) {
				final ReferenceWithMetaInterestRateIndex referenceWithMetaInterestRateIndex1 = MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).get();
				if (referenceWithMetaInterestRateIndex1 == null) {
					rateOption = null;
				} else {
					rateOption = toBuilder(referenceWithMetaInterestRateIndex1.getValue());
				}
			} else {
				rateOption = null;
			}
			
			return Optional.ofNullable(rateOption)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
