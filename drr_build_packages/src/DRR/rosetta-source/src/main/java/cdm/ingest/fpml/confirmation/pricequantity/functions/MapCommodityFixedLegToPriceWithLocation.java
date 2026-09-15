package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityFixedLegToPriceWithLocation.MapCommodityFixedLegToPriceWithLocationDefault.class)
public abstract class MapCommodityFixedLegToPriceWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithLocation createPriceWithLocation;
	@Inject protected MapCommmodityFixedPriceScheduleToPriceSchedule mapCommmodityFixedPriceScheduleToPriceSchedule;
	@Inject protected MapCommmodityFixedPriceToPriceSchedule mapCommmodityFixedPriceToPriceSchedule;

	/**
	* @param fpmlFixedPrice 
	* @param fpmlFixedPriceSchedule 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public FieldWithMetaPriceSchedule evaluate(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg) {
		FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlFixedPrice, fpmlFixedPriceSchedule, fpmlLeg);
		
		final FieldWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg);

	protected abstract MapperS<? extends PriceSchedule> fixedPrice(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg);

	public static class MapCommodityFixedLegToPriceWithLocationDefault extends MapCommodityFixedLegToPriceWithLocation {
		@Override
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg) {
			FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule = FieldWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlFixedPrice, fpmlFixedPriceSchedule, fpmlLeg);
		}
		
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder assignOutput(FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule, CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg) {
			if (exists(fixedPrice(fpmlFixedPrice, fpmlFixedPriceSchedule, fpmlLeg)).getOrDefault(false)) {
				priceSchedule = toBuilder(createPriceWithLocation.evaluate(fixedPrice(fpmlFixedPrice, fpmlFixedPriceSchedule, fpmlLeg).get(), createPriceKey.evaluate("fixedPrice", fpmlLeg)));
			} else {
				priceSchedule = toBuilder(FieldWithMetaPriceSchedule.builder().build());
			}
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PriceSchedule> fixedPrice(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedPrice)).getOrDefault(false)) {
				return MapperS.of(mapCommmodityFixedPriceToPriceSchedule.evaluate(fpmlFixedPrice));
			}
			if (exists(MapperS.of(fpmlFixedPriceSchedule)).getOrDefault(false)) {
				return MapperS.of(mapCommmodityFixedPriceScheduleToPriceSchedule.evaluate(fpmlFixedPriceSchedule));
			}
			return MapperS.<PriceSchedule>ofNull();
		}
	}
}
