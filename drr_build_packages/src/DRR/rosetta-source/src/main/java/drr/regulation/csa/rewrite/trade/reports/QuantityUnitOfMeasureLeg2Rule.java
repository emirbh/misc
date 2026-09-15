package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommoditySwap;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.quantity.reports.UnitOfMeasureFromQuantityRule;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.csa.rewrite.trade.functions.CommodityLeg2;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityUnitOfMeasureLeg2Rule.QuantityUnitOfMeasureLeg2RuleDefault.class)
public abstract class QuantityUnitOfMeasureLeg2Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg2 commodityLeg2;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCommoditySwap isCommoditySwap;
	@Inject protected IsEquity isEquity;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;
	@Inject protected UnitOfMeasureFromQuantityRule unitOfMeasureFromQuantityRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class QuantityUnitOfMeasureLeg2RuleDefault extends QuantityUnitOfMeasureLeg2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<Trade> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg2 = thenArg1
				.mapSingleToItem(item -> {
					final Boolean _boolean = isCommoditySwap.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(commodityLeg2.evaluate(productForTrade.evaluate(item.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(productForTrade.evaluate(item.get())))).andNullSafe(exists(MapperS.of(interestRateLeg2.evaluate(productForTrade.evaluate(item.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()))).getOrDefault(false)) {
						return MapperS.of(interestRateLeg2.evaluate(productForTrade.evaluate(item.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
					}
					return MapperS.<ReferenceWithMetaNonNegativeQuantitySchedule>ofNull();
				});
			output = thenArg2
				.mapSingleToItem(item -> {
					final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule = item.get();
					return MapperS.of(MapperS.of(unitOfMeasureFromQuantityRule.evaluate((referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()))).getOrDefault("OTHR"));
				}).get();
			
			return output;
		}
	}
}
