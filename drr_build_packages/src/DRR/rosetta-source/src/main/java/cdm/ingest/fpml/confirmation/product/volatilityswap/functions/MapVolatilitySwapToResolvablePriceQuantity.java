package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapToResolvablePriceQuantity.MapVolatilitySwapToResolvablePriceQuantityDefault.class)
public abstract class MapVolatilitySwapToResolvablePriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVolatilityLegToNonNegativeQuantityScheduleWithAddress mapVolatilityLegToNonNegativeQuantityScheduleWithAddress;

	/**
	* @param fpmlVolatilitySwap 
	* @return priceQuantityList 
	*/
	public ResolvablePriceQuantity evaluate(VolatilityLeg fpmlVolatilitySwap) {
		ResolvablePriceQuantity.ResolvablePriceQuantityBuilder priceQuantityListBuilder = doEvaluate(fpmlVolatilitySwap);
		
		final ResolvablePriceQuantity priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.build();
			objectValidator.validate(ResolvablePriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract ResolvablePriceQuantity.ResolvablePriceQuantityBuilder doEvaluate(VolatilityLeg fpmlVolatilitySwap);

	public static class MapVolatilitySwapToResolvablePriceQuantityDefault extends MapVolatilitySwapToResolvablePriceQuantity {
		@Override
		protected ResolvablePriceQuantity.ResolvablePriceQuantityBuilder doEvaluate(VolatilityLeg fpmlVolatilitySwap) {
			ResolvablePriceQuantity.ResolvablePriceQuantityBuilder priceQuantityList = ResolvablePriceQuantity.builder();
			return assignOutput(priceQuantityList, fpmlVolatilitySwap);
		}
		
		protected ResolvablePriceQuantity.ResolvablePriceQuantityBuilder assignOutput(ResolvablePriceQuantity.ResolvablePriceQuantityBuilder priceQuantityList, VolatilityLeg fpmlVolatilitySwap) {
			priceQuantityList = toBuilder(ResolvablePriceQuantity.builder()
				.setQuantitySchedule(mapVolatilityLegToNonNegativeQuantityScheduleWithAddress.evaluate(fpmlVolatilitySwap))
				.build());
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
