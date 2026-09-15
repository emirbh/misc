package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilityLegToPriceQuantity.MapVolatilityLegToPriceQuantityDefault.class)
public abstract class MapVolatilityLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapUnderlyerToObservableWithLocation mapUnderlyerToObservableWithLocation;
	@Inject protected MapVolatilityLegToNonNegativeQuantityScheduleWithLocation mapVolatilityLegToNonNegativeQuantityScheduleWithLocation;

	/**
	* @param fpmlVolatilityLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(VolatilityLeg fpmlVolatilityLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlVolatilityLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg);

	public static class MapVolatilityLegToPriceQuantityDefault extends MapVolatilityLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlVolatilityLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, VolatilityLeg fpmlVolatilityLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = mapVolatilityLegToNonNegativeQuantityScheduleWithLocation.evaluate(fpmlVolatilityLeg);
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setObservable(mapUnderlyerToObservableWithLocation.evaluate(MapperS.of(fpmlVolatilityLeg).<Underlyer>map("getUnderlyer", volatilityLeg -> volatilityLeg.getUnderlyer()).get()))
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
