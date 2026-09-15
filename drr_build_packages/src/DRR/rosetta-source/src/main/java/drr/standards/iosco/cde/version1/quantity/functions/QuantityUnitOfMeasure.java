package drr.standards.iosco.cde.version1.quantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.product.asset.CommodityPayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.quantity.reports.CommodityFixedPriceQuantityRule;
import drr.base.trade.quantity.reports.UnitOfMeasureFromQuantityRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityUnitOfMeasure.QuantityUnitOfMeasureDefault.class)
public abstract class QuantityUnitOfMeasure implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityFixedPriceQuantityRule commodityFixedPriceQuantityRule;
	@Inject protected UnitOfMeasureFromQuantityRule unitOfMeasureFromQuantityRule;

	/**
	* @param payout 
	* @return quantityUnitOfMeasure 
	*/
	public String evaluate(PayoutLegWithAuxiliary payout) {
		String quantityUnitOfMeasure = doEvaluate(payout);
		
		return quantityUnitOfMeasure;
	}

	protected abstract String doEvaluate(PayoutLegWithAuxiliary payout);

	public static class QuantityUnitOfMeasureDefault extends QuantityUnitOfMeasure {
		@Override
		protected String doEvaluate(PayoutLegWithAuxiliary payout) {
			String quantityUnitOfMeasure = null;
			return assignOutput(quantityUnitOfMeasure, payout);
		}
		
		protected String assignOutput(String quantityUnitOfMeasure, PayoutLegWithAuxiliary payout) {
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg1 = MapperS.of(thenArg0.getOrDefault(MapperS.of(payout).<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg2 = MapperS.of(thenArg1.getOrDefault(MapperS.of(payout).<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg3 = MapperS.of(thenArg2.getOrDefault(MapperS.of(payout).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg4 = MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg5 = thenArg4
				.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).get());
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg6 = thenArg5
				.filterItemNullSafe(item -> {
					final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = item.get();
					return exists(MapperS.of(unitOfMeasureFromQuantityRule.evaluate((fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue())))).get();
				});
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = MapperS.of(thenArg6.get()).get();
			final MapperS<NonNegativeQuantitySchedule> thenArg7 = MapperS.of(thenArg3.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).getOrDefault((fieldWithMetaNonNegativeQuantitySchedule0 == null ? null : fieldWithMetaNonNegativeQuantitySchedule0.getValue())));
			final MapperC<String> thenArg8 = MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.mapItem(item -> {
					final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = item.get();
					return MapperS.of(unitOfMeasureFromQuantityRule.evaluate((fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue())));
				});
			NonNegativeQuantitySchedule ifThenElseResult = null;
			if (areEqual(MapperS.of(distinctIgnoringPrecision(thenArg8).resultCount()), MapperS.of(1), CardinalityOperator.All).asMapper().getOrDefault(false)) {
				if (notExists(MapperS.of(payout).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout())).getOrDefault(false)) {
					final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = MapperS.of(commodityFixedPriceQuantityRule.evaluate(MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).get())).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
						.first().get();
					ifThenElseResult = fieldWithMetaNonNegativeQuantitySchedule1 == null ? null : fieldWithMetaNonNegativeQuantitySchedule1.getValue();
				} else {
					final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule2 = MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
						.first().get();
					ifThenElseResult = fieldWithMetaNonNegativeQuantitySchedule2 == null ? null : fieldWithMetaNonNegativeQuantitySchedule2.getValue();
				}
			}
			final MapperS<NonNegativeQuantitySchedule> thenArg9 = MapperS.of(thenArg7.getOrDefault(ifThenElseResult));
			quantityUnitOfMeasure = thenArg9
				.mapSingleToItem(item -> MapperS.of(unitOfMeasureFromQuantityRule.evaluate(item.get()))).get();
			
			return quantityUnitOfMeasure;
		}
	}
}
