package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityClassificationListToObservableCommodityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.OilPhysicalLeg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOilPhysicalLegToPriceQuantity.MapOilPhysicalLegToPriceQuantityDefault.class)
public abstract class MapOilPhysicalLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithLocation mapCommodityClassificationListToObservableCommodityWithLocation;

	/**
	* @param fpmlOilPhysicalLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(OilPhysicalLeg fpmlOilPhysicalLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlOilPhysicalLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(OilPhysicalLeg fpmlOilPhysicalLeg);

	public static class MapOilPhysicalLegToPriceQuantityDefault extends MapOilPhysicalLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(OilPhysicalLeg fpmlOilPhysicalLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlOilPhysicalLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, OilPhysicalLeg fpmlOilPhysicalLeg) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setObservable(mapCommodityClassificationListToObservableCommodityWithLocation.evaluate(MapperS.of(fpmlOilPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", oilPhysicalLeg -> oilPhysicalLeg.getCommodityClassification()).getMulti(), fpmlOilPhysicalLeg))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
