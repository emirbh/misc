package drr.regulation.common.trade.quantity.functions;

import cdm.base.datetime.Frequency;
import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.quantity.functions.CommodityForwardObservablePriceQuantity;
import drr.base.trade.quantity.functions.CommodityObservablePriceQuantity;
import drr.base.trade.quantity.reports.CommodityFixedPriceQuantityRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityQuantityWithFrequency.CommodityQuantityWithFrequencyDefault.class)
public abstract class CommodityQuantityWithFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityFixedPriceQuantityRule commodityFixedPriceQuantityRule;
	@Inject protected CommodityForwardObservablePriceQuantity commodityForwardObservablePriceQuantity;
	@Inject protected CommodityObservablePriceQuantity commodityObservablePriceQuantity;

	/**
	* @param payout 
	* @return quantity 
	*/
	public NonNegativeQuantitySchedule evaluate(PayoutLegWithAuxiliary payout) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantityBuilder = doEvaluate(payout);
		
		final NonNegativeQuantitySchedule quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, quantity);
		}
		
		return quantity;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(PayoutLegWithAuxiliary payout);

	public static class CommodityQuantityWithFrequencyDefault extends CommodityQuantityWithFrequency {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(PayoutLegWithAuxiliary payout) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity = NonNegativeQuantitySchedule.builder();
			return assignOutput(quantity, payout);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity, PayoutLegWithAuxiliary payout) {
			final MapperS<PriceQuantity> thenArg0 = MapperS.of(commodityObservablePriceQuantity.evaluate(MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).get(), MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).get()));
			final MapperS<PriceQuantity> thenArg1 = MapperS.of(thenArg0.getOrDefault(commodityFixedPriceQuantityRule.evaluate(MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).get())));
			final MapperS<PriceQuantity> thenArg2 = MapperS.of(thenArg1.getOrDefault(commodityForwardObservablePriceQuantity.evaluate(MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).get(), MapperS.of(payout).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).get())));
			final MapperS<PriceQuantity> thenArg3 = MapperS.of(thenArg2.getOrDefault(MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).get()));
			final MapperC<PriceQuantity> thenArg4 = MapperS.of(payout).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity())
				.filterItemNullSafe(pq -> exists(pq.<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())).get());
			final MapperS<PriceQuantity> thenArg5 = MapperS.of(thenArg3.getOrDefault(MapperS.of(thenArg4.get()).get()));
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg6 = thenArg5.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule0 -> fieldWithMetaNonNegativeQuantitySchedule0 == null ? null : fieldWithMetaNonNegativeQuantitySchedule0.getValue()).<Frequency>map("getFrequency", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getFrequency())).andNullSafe(exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule1 -> fieldWithMetaNonNegativeQuantitySchedule1 == null ? null : fieldWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).orNullSafe(areEqual(MapperS.of(distinctIgnoringPrecision(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule2 -> fieldWithMetaNonNegativeQuantitySchedule2 == null ? null : fieldWithMetaNonNegativeQuantitySchedule2.getValue()).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All))).get());
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = MapperS.of(thenArg6.get()).get();
			if (fieldWithMetaNonNegativeQuantitySchedule == null) {
				quantity = null;
			} else {
				quantity = toBuilder(fieldWithMetaNonNegativeQuantitySchedule.getValue());
			}
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
