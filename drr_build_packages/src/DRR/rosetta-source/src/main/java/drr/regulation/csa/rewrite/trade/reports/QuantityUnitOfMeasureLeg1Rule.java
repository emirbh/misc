package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodityOption;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.qualification.product.functions.IsEquityForward;
import drr.base.qualification.product.functions.IsEquityOption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.quantity.reports.UnitOfMeasureFromQuantityRule;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.CommodityLeg1;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityUnitOfMeasureLeg1Rule.QuantityUnitOfMeasureLeg1RuleDefault.class)
public abstract class QuantityUnitOfMeasureLeg1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg1 commodityLeg1;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCommodityOption isCommodityOption;
	@Inject protected IsEquity isEquity;
	@Inject protected IsEquityForward isEquityForward;
	@Inject protected IsEquityOption isEquityOption;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected TradeForEvent tradeForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;
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

	public static class QuantityUnitOfMeasureLeg1RuleDefault extends QuantityUnitOfMeasureLeg1Rule {
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
			final MapperS<NonNegativeQuantitySchedule> thenArg2 = thenArg1
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(MapperS.of(productForTrade.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(commodityLeg1.evaluate(productForTrade.evaluate(item.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue());
					}
					if (areEqual(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(MapperS.of(productForTrade.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue());
					}
					if (areEqual(MapperS.of(qualify_Commodity_Swaption.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(MapperS.of(underlierForProduct.evaluate(productForTrade.evaluate(item.get()))).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).getOrDefault(false)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue());
					}
					if (areEqual(MapperS.of(qualify_Commodity_Swaption.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(MapperS.of(underlierForProduct.evaluate(productForTrade.evaluate(item.get()))).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).getOrDefault(false)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue());
					}
					final Boolean _boolean = isCommodityOption.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule4 -> referenceWithMetaNonNegativeQuantitySchedule4 == null ? null : referenceWithMetaNonNegativeQuantitySchedule4.getValue());
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isEquityOption.evaluate(productForTrade.evaluate(item.get())))).andNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()))).getOrDefault(false)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule5 -> referenceWithMetaNonNegativeQuantitySchedule5 == null ? null : referenceWithMetaNonNegativeQuantitySchedule5.getValue());
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isEquityForward.evaluate(productForTrade.evaluate(item.get())))).andNullSafe(exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule6 -> referenceWithMetaNonNegativeQuantitySchedule6 == null ? null : referenceWithMetaNonNegativeQuantitySchedule6.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()))).getOrDefault(false)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule7 -> referenceWithMetaNonNegativeQuantitySchedule7 == null ? null : referenceWithMetaNonNegativeQuantitySchedule7.getValue());
					}
					if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule8 -> referenceWithMetaNonNegativeQuantitySchedule8 == null ? null : referenceWithMetaNonNegativeQuantitySchedule8.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get()))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule9 -> referenceWithMetaNonNegativeQuantitySchedule9 == null ? null : referenceWithMetaNonNegativeQuantitySchedule9.getValue());
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(productForTrade.evaluate(item.get())))).andNullSafe(exists(item.<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", _fieldWithMetaNonNegativeQuantitySchedule -> _fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()))).getOrDefault(false)) {
						final MapperC<FieldWithMetaNonNegativeQuantitySchedule> _thenArg0 = MapperS.of(item.<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
						final MapperC<FieldWithMetaNonNegativeQuantitySchedule> _thenArg1 = _thenArg0
							.filterItemNullSafe(_item -> exists(_item.<NonNegativeQuantitySchedule>map("Type coercion", _fieldWithMetaNonNegativeQuantitySchedule -> _fieldWithMetaNonNegativeQuantitySchedule == null ? null : _fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).get());
						return MapperS.of(_thenArg1.get()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue());
					}
					return MapperS.<NonNegativeQuantitySchedule>ofNull();
				});
			output = thenArg2
				.mapSingleToItem(item -> MapperS.of(MapperS.of(unitOfMeasureFromQuantityRule.evaluate(item.get())).getOrDefault("OTHR"))).get();
			
			return output;
		}
	}
}
