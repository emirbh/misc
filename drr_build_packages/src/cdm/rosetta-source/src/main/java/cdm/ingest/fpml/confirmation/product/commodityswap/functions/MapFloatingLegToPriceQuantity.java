package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.math.CapacityUnitEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapCapacityUnitEnum;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityNotionalQuantityToQuantityListWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommoditySpreadToPriceWithLocation;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommoditySpread;
import fpml.consolidated.com.FloatingLeg;
import fpml.consolidated.com.FloatingLegCalculation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingLegToPriceQuantity.MapFloatingLegToPriceQuantityDefault.class)
public abstract class MapFloatingLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithLocation mapAssetToObservableWithLocation;
	@Inject protected MapCapacityUnitEnum mapCapacityUnitEnum;
	@Inject protected MapCommodityNotionalQuantityToQuantityListWithLocation mapCommodityNotionalQuantityToQuantityListWithLocation;
	@Inject protected MapCommoditySpreadToPriceWithLocation mapCommoditySpreadToPriceWithLocation;

	/**
	* @param fpmlFloatingLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(FloatingLeg fpmlFloatingLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlFloatingLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(FloatingLeg fpmlFloatingLeg);

	protected abstract MapperS<CapacityUnitEnum> priceCapacityUnit(FloatingLeg fpmlFloatingLeg);

	public static class MapFloatingLegToPriceQuantityDefault extends MapFloatingLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(FloatingLeg fpmlFloatingLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlFloatingLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, FloatingLeg fpmlFloatingLeg) {
			final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = mapCommoditySpreadToPriceWithLocation.evaluate(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<CommoditySpread>map("getSpread", floatingLegCalculation -> floatingLegCalculation.getSpread()).get(), priceCapacityUnit(fpmlFloatingLeg).get(), fpmlFloatingLeg);
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setQuantity(new ArrayList(mapCommodityNotionalQuantityToQuantityListWithLocation.evaluate(MapperS.of(fpmlFloatingLeg).<CommodityNotionalQuantity>map("getNotionalQuantity", floatingLeg -> floatingLeg.getNotionalQuantity()).get(), MapperS.of(fpmlFloatingLeg).<BigDecimal>map("getTotalNotionalQuantity", floatingLeg -> floatingLeg.getTotalNotionalQuantity()).get(), MapperS.of(fpmlFloatingLeg).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", floatingLeg -> floatingLeg.getNotionalQuantitySchedule()).get(), fpmlFloatingLeg)))
				.setObservable(mapAssetToObservableWithLocation.evaluate(MapperS.of(fpmlFloatingLeg).<Commodity>map("getCommodity", floatingLeg -> floatingLeg.getCommodity()).get()))
				.setPrice((fieldWithMetaPriceSchedule == null ? Collections.<FieldWithMetaPriceSchedule>emptyList() : Collections.singletonList(fieldWithMetaPriceSchedule)))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<CapacityUnitEnum> priceCapacityUnit(FloatingLeg fpmlFloatingLeg) {
			return MapperS.of(mapCapacityUnitEnum.evaluate(MapperS.of(fpmlFloatingLeg).<CommodityNotionalQuantity>map("getNotionalQuantity", floatingLeg -> floatingLeg.getNotionalQuantity()).<QuantityUnit>map("getQuantityUnit", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityUnit()).<String>map("getValue", quantityUnit -> quantityUnit.getValue()).get()));
		}
	}
}
