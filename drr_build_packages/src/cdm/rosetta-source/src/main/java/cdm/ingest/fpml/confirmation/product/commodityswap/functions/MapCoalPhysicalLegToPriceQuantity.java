package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityClassificationListToObservableCommodityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.CoalPhysicalLeg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCoalPhysicalLegToPriceQuantity.MapCoalPhysicalLegToPriceQuantityDefault.class)
public abstract class MapCoalPhysicalLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithLocation mapCommodityClassificationListToObservableCommodityWithLocation;

	/**
	* @param fpmlCoalPhysicalLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(CoalPhysicalLeg fpmlCoalPhysicalLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlCoalPhysicalLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(CoalPhysicalLeg fpmlCoalPhysicalLeg);

	public static class MapCoalPhysicalLegToPriceQuantityDefault extends MapCoalPhysicalLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(CoalPhysicalLeg fpmlCoalPhysicalLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlCoalPhysicalLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, CoalPhysicalLeg fpmlCoalPhysicalLeg) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setObservable(mapCommodityClassificationListToObservableCommodityWithLocation.evaluate(MapperS.of(fpmlCoalPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", coalPhysicalLeg -> coalPhysicalLeg.getCommodityClassification()).getMulti(), fpmlCoalPhysicalLeg))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
