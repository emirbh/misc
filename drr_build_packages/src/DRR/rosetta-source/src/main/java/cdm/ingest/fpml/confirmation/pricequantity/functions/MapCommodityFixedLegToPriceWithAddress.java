package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
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

@ImplementedBy(MapCommodityFixedLegToPriceWithAddress.MapCommodityFixedLegToPriceWithAddressDefault.class)
public abstract class MapCommodityFixedLegToPriceWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithAddress createPriceWithAddress;
	@Inject protected MapCommmodityFixedPriceScheduleToPriceSchedule mapCommmodityFixedPriceScheduleToPriceSchedule;
	@Inject protected MapCommmodityFixedPriceToPriceSchedule mapCommmodityFixedPriceToPriceSchedule;

	/**
	* @param fpmlFixedPrice 
	* @param fpmlFixedPriceSchedule 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public ReferenceWithMetaPriceSchedule evaluate(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg) {
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlFixedPrice, fpmlFixedPriceSchedule, fpmlLeg);
		
		final ReferenceWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg);

	protected abstract MapperS<? extends PriceSchedule> fixedPrice(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg);

	public static class MapCommodityFixedLegToPriceWithAddressDefault extends MapCommodityFixedLegToPriceWithAddress {
		@Override
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg) {
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule = ReferenceWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlFixedPrice, fpmlFixedPriceSchedule, fpmlLeg);
		}
		
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder assignOutput(ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule, CommodityFixedPrice fpmlFixedPrice, CommodityFixedPriceSchedule fpmlFixedPriceSchedule, Leg fpmlLeg) {
			if (exists(fixedPrice(fpmlFixedPrice, fpmlFixedPriceSchedule, fpmlLeg)).getOrDefault(false)) {
				priceSchedule = toBuilder(createPriceWithAddress.evaluate(createPriceKey.evaluate("fixedPrice", fpmlLeg)));
			} else {
				priceSchedule = toBuilder(ReferenceWithMetaPriceSchedule.builder().build());
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
