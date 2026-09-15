package drr.regulation.common.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.Quantity;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityCommodityLeg1.CommodityCommodityLeg1Default.class)
public abstract class CommodityCommodityLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriodToDaysCommodities calculationPeriodToDaysCommodities;

	/**
	* @param commodityPayouts 
	* @return commodityLeg1 
	*/
	public CommodityPayout evaluate(List<? extends CommodityPayout> commodityPayouts) {
		CommodityPayout.CommodityPayoutBuilder commodityLeg1Builder = doEvaluate(commodityPayouts);
		
		final CommodityPayout commodityLeg1;
		if (commodityLeg1Builder == null) {
			commodityLeg1 = null;
		} else {
			commodityLeg1 = commodityLeg1Builder.build();
			objectValidator.validate(CommodityPayout.class, commodityLeg1);
		}
		
		return commodityLeg1;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(List<? extends CommodityPayout> commodityPayouts);

	public static class CommodityCommodityLeg1Default extends CommodityCommodityLeg1 {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(List<? extends CommodityPayout> commodityPayouts) {
			if (commodityPayouts == null) {
				commodityPayouts = Collections.emptyList();
			}
			CommodityPayout.CommodityPayoutBuilder commodityLeg1 = CommodityPayout.builder();
			return assignOutput(commodityLeg1, commodityPayouts);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder commodityLeg1, List<? extends CommodityPayout> commodityPayouts) {
			if (exists(MapperC.<CommodityPayout>of(commodityPayouts).map("getMeta", a->a.getMeta()).map("getKey", a->a.getExternalKey())).getOrDefault(false)) {
				commodityLeg1 = toBuilder(MapperC.<CommodityPayout>of(commodityPayouts)
					.min(item -> item.map("getMeta", a->a.getMeta()).map("getKey", a->a.getExternalKey())).get());
			} else if (areEqual(MapperS.of(distinctIgnoringPrecision(MapperC.<CommodityPayout>of(commodityPayouts).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<Quantity>map("getResolvedQuantity", resolvablePriceQuantity -> resolvablePriceQuantity.getResolvedQuantity()).<BigDecimal>map("getValue", quantity -> quantity.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				commodityLeg1 = toBuilder(MapperC.<CommodityPayout>of(commodityPayouts)
					.min(item -> MapperS.of(calculationPeriodToDaysCommodities.evaluate(item.get()))).get());
			} else {
				commodityLeg1 = toBuilder(MapperC.<CommodityPayout>of(commodityPayouts)
					.max(item -> item.<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).get());
			}
			
			return Optional.ofNullable(commodityLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
