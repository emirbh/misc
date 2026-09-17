package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityFixedLegToPriceWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityNotionalQuantityToQuantityListWithLocation;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.FixedLeg;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFixedLegToPriceQuantity.MapFixedLegToPriceQuantityDefault.class)
public abstract class MapFixedLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityFixedLegToPriceWithLocation mapCommodityFixedLegToPriceWithLocation;
	@Inject protected MapCommodityNotionalQuantityToQuantityListWithLocation mapCommodityNotionalQuantityToQuantityListWithLocation;

	/**
	* @param fpmlFixedLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(FixedLeg fpmlFixedLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlFixedLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(FixedLeg fpmlFixedLeg);

	public static class MapFixedLegToPriceQuantityDefault extends MapFixedLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(FixedLeg fpmlFixedLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlFixedLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, FixedLeg fpmlFixedLeg) {
			final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = mapCommodityFixedLegToPriceWithLocation.evaluate(MapperS.of(fpmlFixedLeg).<CommodityFixedPrice>map("getFixedPrice", fixedLeg -> fixedLeg.getFixedPrice()).get(), MapperS.of(fpmlFixedLeg).<CommodityFixedPriceSchedule>map("getFixedPriceSchedule", fixedLeg -> fixedLeg.getFixedPriceSchedule()).get(), fpmlFixedLeg);
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setQuantity(new ArrayList(mapCommodityNotionalQuantityToQuantityListWithLocation.evaluate(MapperS.of(fpmlFixedLeg).<CommodityNotionalQuantity>map("getNotionalQuantity", fixedLeg -> fixedLeg.getNotionalQuantity()).get(), MapperS.of(fpmlFixedLeg).<BigDecimal>map("getTotalNotionalQuantity", fixedLeg -> fixedLeg.getTotalNotionalQuantity()).get(), MapperS.of(fpmlFixedLeg).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", fixedLeg -> fixedLeg.getNotionalQuantitySchedule()).get(), fpmlFixedLeg)))
				.setPrice((fieldWithMetaPriceSchedule == null ? Collections.<FieldWithMetaPriceSchedule>emptyList() : Collections.singletonList(fieldWithMetaPriceSchedule)))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
