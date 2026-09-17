package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityClassificationListToObservableCommodityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEnvironmentalPhysicalLegToPriceQuantity.MapEnvironmentalPhysicalLegToPriceQuantityDefault.class)
public abstract class MapEnvironmentalPhysicalLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithLocation mapCommodityClassificationListToObservableCommodityWithLocation;

	/**
	* @param fpmlEnvironmentalPhysicalLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlEnvironmentalPhysicalLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg);

	public static class MapEnvironmentalPhysicalLegToPriceQuantityDefault extends MapEnvironmentalPhysicalLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlEnvironmentalPhysicalLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setObservable(mapCommodityClassificationListToObservableCommodityWithLocation.evaluate(MapperS.of(fpmlEnvironmentalPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", environmentalPhysicalLeg -> environmentalPhysicalLeg.getCommodityClassification()).getMulti(), fpmlEnvironmentalPhysicalLeg))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
