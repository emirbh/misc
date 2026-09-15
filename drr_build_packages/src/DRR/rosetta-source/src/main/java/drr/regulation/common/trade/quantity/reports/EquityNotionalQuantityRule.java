package drr.regulation.common.trade.quantity.reports;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EquityNotionalQuantityRule.EquityNotionalQuantityRuleDefault.class)
public abstract class EquityNotionalQuantityRule implements ReportFunction<PayoutLegWithAuxiliary, BigDecimal> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(PayoutLegWithAuxiliary input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(PayoutLegWithAuxiliary input);

	public static class EquityNotionalQuantityRuleDefault extends EquityNotionalQuantityRule {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, PayoutLegWithAuxiliary input) {
			final MapperS<NonNegativeQuantitySchedule> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						return item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue());
					}
					if (exists(item.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						return item.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue());
					}
					if (exists(item.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule4 -> referenceWithMetaNonNegativeQuantitySchedule4 == null ? null : referenceWithMetaNonNegativeQuantitySchedule4.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						return item.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule5 -> referenceWithMetaNonNegativeQuantitySchedule5 == null ? null : referenceWithMetaNonNegativeQuantitySchedule5.getValue());
					}
					if (exists(item.<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", _fieldWithMetaNonNegativeQuantitySchedule -> _fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = item.<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
						final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = thenArg0
							.filterItemNullSafe(_item -> exists(_item.<NonNegativeQuantitySchedule>map("Type coercion", _fieldWithMetaNonNegativeQuantitySchedule -> _fieldWithMetaNonNegativeQuantitySchedule == null ? null : _fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).get());
						return MapperS.of(thenArg1.get()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue());
					}
					return MapperS.<NonNegativeQuantitySchedule>ofNull();
				});
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(item.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
						return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(item.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), item.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue()));
					}
					return item.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue());
				}).get();
			
			return output;
		}
	}
}
