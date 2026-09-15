package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityClassificationListToObservableCommodityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.GasPhysicalLeg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapGasPhysicalLegToPriceQuantity.MapGasPhysicalLegToPriceQuantityDefault.class)
public abstract class MapGasPhysicalLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithLocation mapCommodityClassificationListToObservableCommodityWithLocation;

	/**
	* @param fpmlGasPhysicalLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(GasPhysicalLeg fpmlGasPhysicalLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlGasPhysicalLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(GasPhysicalLeg fpmlGasPhysicalLeg);

	public static class MapGasPhysicalLegToPriceQuantityDefault extends MapGasPhysicalLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(GasPhysicalLeg fpmlGasPhysicalLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlGasPhysicalLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, GasPhysicalLeg fpmlGasPhysicalLeg) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setObservable(mapCommodityClassificationListToObservableCommodityWithLocation.evaluate(MapperS.of(fpmlGasPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", gasPhysicalLeg -> gasPhysicalLeg.getCommodityClassification()).getMulti(), fpmlGasPhysicalLeg))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
