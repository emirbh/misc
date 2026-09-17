package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityClassificationListToObservableCommodityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.ElectricityPhysicalLeg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapElectricityPhysicalLegToPriceQuantity.MapElectricityPhysicalLegToPriceQuantityDefault.class)
public abstract class MapElectricityPhysicalLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithLocation mapCommodityClassificationListToObservableCommodityWithLocation;

	/**
	* @param fpmlElectricityPhysicalLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(ElectricityPhysicalLeg fpmlElectricityPhysicalLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlElectricityPhysicalLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(ElectricityPhysicalLeg fpmlElectricityPhysicalLeg);

	public static class MapElectricityPhysicalLegToPriceQuantityDefault extends MapElectricityPhysicalLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(ElectricityPhysicalLeg fpmlElectricityPhysicalLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlElectricityPhysicalLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, ElectricityPhysicalLeg fpmlElectricityPhysicalLeg) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setObservable(mapCommodityClassificationListToObservableCommodityWithLocation.evaluate(MapperS.of(fpmlElectricityPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", electricityPhysicalLeg -> electricityPhysicalLeg.getCommodityClassification()).getMulti(), fpmlElectricityPhysicalLeg))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
