package drr.standards.iosco.cde.version1.quantity.functions;

import cdm.base.math.DatedValue;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Measure;
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
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TotalNotionalQuantity.TotalNotionalQuantityDefault.class)
public abstract class TotalNotionalQuantity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;

	/**
	* @param payout 
	* @param defaultValue 
	* @return totalTotalNotionalQuantity 
	*/
	public BigDecimal evaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
		BigDecimal totalTotalNotionalQuantity = doEvaluate(payout, defaultValue);
		
		return totalTotalNotionalQuantity;
	}

	protected abstract BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue);

	public static class TotalNotionalQuantityDefault extends TotalNotionalQuantity {
		@Override
		protected BigDecimal doEvaluate(PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			BigDecimal totalTotalNotionalQuantity = null;
			return assignOutput(totalTotalNotionalQuantity, payout, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal totalTotalNotionalQuantity, PayoutLegWithAuxiliary payout, BigDecimal defaultValue) {
			final MapperS<PayoutLegWithAuxiliary> thenArg0 = MapperS.of(payout);
			final MapperS<BigDecimal> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final MapperS<NonNegativeQuantitySchedule> thenArg2;
					if (exists(item.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
						thenArg2 = item.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue());
					} else if (exists(item.<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
						thenArg2 = item.<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue());
					} else if (exists(item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						thenArg2 = item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue());
					} else if (exists(item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
						thenArg2 = item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule4 -> referenceWithMetaNonNegativeQuantitySchedule4 == null ? null : referenceWithMetaNonNegativeQuantitySchedule4.getValue());
					} else if (exists(item.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule5 -> referenceWithMetaNonNegativeQuantitySchedule5 == null ? null : referenceWithMetaNonNegativeQuantitySchedule5.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						thenArg2 = item.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule6 -> referenceWithMetaNonNegativeQuantitySchedule6 == null ? null : referenceWithMetaNonNegativeQuantitySchedule6.getValue());
					} else if (exists(item.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule7 -> referenceWithMetaNonNegativeQuantitySchedule7 == null ? null : referenceWithMetaNonNegativeQuantitySchedule7.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						thenArg2 = item.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule8 -> referenceWithMetaNonNegativeQuantitySchedule8 == null ? null : referenceWithMetaNonNegativeQuantitySchedule8.getValue());
					} else if (exists(item.<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", _fieldWithMetaNonNegativeQuantitySchedule -> _fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						final MapperC<FieldWithMetaNonNegativeQuantitySchedule> _thenArg0 = item.<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
						final MapperC<FieldWithMetaNonNegativeQuantitySchedule> _thenArg1 = _thenArg0
							.filterItemNullSafe(_item -> exists(_item.<NonNegativeQuantitySchedule>map("Type coercion", _fieldWithMetaNonNegativeQuantitySchedule -> _fieldWithMetaNonNegativeQuantitySchedule == null ? null : _fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).get());
						thenArg2 = MapperS.of(_thenArg1.get()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue());
					} else {
						thenArg2 = MapperS.<NonNegativeQuantitySchedule>ofNull();
					}
					return MapperS.of(thenArg2
						.mapSingleToItem(_item -> {
							if (exists(_item.<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue())).getOrDefault(false)) {
								return _item.<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue())
									.sumBigDecimal();
							}
							if (exists(_item.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
								return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(_item.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), _item.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue()));
							}
							return _item.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue());
						}).getOrDefault(defaultValue));
				});
			totalTotalNotionalQuantity = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg1.get())).get();
			
			return totalTotalNotionalQuantity;
		}
	}
}
