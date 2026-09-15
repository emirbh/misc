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

@ImplementedBy(CommodityCommodityLeg2.CommodityCommodityLeg2Default.class)
public abstract class CommodityCommodityLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriodToDaysCommodities calculationPeriodToDaysCommodities;

	/**
	* @param commodityPayouts 
	* @return commodityLeg2 
	*/
	public CommodityPayout evaluate(List<? extends CommodityPayout> commodityPayouts) {
		CommodityPayout.CommodityPayoutBuilder commodityLeg2Builder = doEvaluate(commodityPayouts);
		
		final CommodityPayout commodityLeg2;
		if (commodityLeg2Builder == null) {
			commodityLeg2 = null;
		} else {
			commodityLeg2 = commodityLeg2Builder.build();
			objectValidator.validate(CommodityPayout.class, commodityLeg2);
		}
		
		return commodityLeg2;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(List<? extends CommodityPayout> commodityPayouts);

	public static class CommodityCommodityLeg2Default extends CommodityCommodityLeg2 {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(List<? extends CommodityPayout> commodityPayouts) {
			if (commodityPayouts == null) {
				commodityPayouts = Collections.emptyList();
			}
			CommodityPayout.CommodityPayoutBuilder commodityLeg2 = CommodityPayout.builder();
			return assignOutput(commodityLeg2, commodityPayouts);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder commodityLeg2, List<? extends CommodityPayout> commodityPayouts) {
			if (exists(MapperC.<CommodityPayout>of(commodityPayouts).map("getMeta", a->a.getMeta()).map("getKey", a->a.getExternalKey())).getOrDefault(false)) {
				commodityLeg2 = toBuilder(MapperC.<CommodityPayout>of(commodityPayouts)
					.max(item -> item.map("getMeta", a->a.getMeta()).map("getKey", a->a.getExternalKey())).get());
			} else if (areEqual(MapperS.of(distinctIgnoringPrecision(MapperC.<CommodityPayout>of(commodityPayouts).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<Quantity>map("getResolvedQuantity", resolvablePriceQuantity -> resolvablePriceQuantity.getResolvedQuantity()).<BigDecimal>map("getValue", quantity -> quantity.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				commodityLeg2 = toBuilder(MapperC.<CommodityPayout>of(commodityPayouts)
					.max(item -> MapperS.of(calculationPeriodToDaysCommodities.evaluate(item.get()))).get());
			} else {
				commodityLeg2 = toBuilder(MapperC.<CommodityPayout>of(commodityPayouts)
					.min(item -> item.<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).get());
			}
			
			return Optional.ofNullable(commodityLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
