package drr.regulation.common.emir.reports;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.template.EconomicTerms;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.price.functions.Contract_Price;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.FXFarLeg;
import drr.standards.iosco.cde.version2.price.functions.StrikePrice;
import drr.standards.iso.functions.FormatToBaseOne18Rate;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ForwardExchangeRateRule.ForwardExchangeRateRuleDefault.class)
public abstract class ForwardExchangeRateRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Contract_Price contract_Price;
	@Inject protected FXFarLeg fXFarLeg;
	@Inject protected FormatToBaseOne18Rate formatToBaseOne18Rate;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected IsFXOption isFXOption;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
	@Inject protected StrikePrice strikePrice;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class ForwardExchangeRateRuleDefault extends ForwardExchangeRateRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<BigDecimal> thenArg1 = thenArg0
				.mapSingleToItem(reportableEvent -> {
					final MapperS<TransactionReportInstruction> _thenArg0 = thenArg0
						.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(item.get()))).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDF.evaluate(MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(item.get()))).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(productForTrade.evaluate(tradeForEvent.evaluate(item.get())))))).get());
					final MapperS<Trade> _thenArg1 = thenArg0
						.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(reportableEvent.get())));
					final MapperS<Trade> thenArg2 = _thenArg1
						.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(MapperS.of(productForTrade.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(MapperS.of(productForTrade.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).get());
					final MapperC<PriceQuantity> thenArg3 = thenArg2
						.mapSingleToList(trade -> trade.<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity())
							.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(fXFarLeg.evaluate(productForTrade.evaluate(trade.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), CardinalityOperator.Any).andNullSafe(areEqual(item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(fXFarLeg.evaluate(productForTrade.evaluate(trade.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), CardinalityOperator.Any)).get()));
					final MapperListOfLists<FieldWithMetaPriceSchedule> thenArg4 = thenArg3
						.mapItemToList(item -> item.<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()));
					final MapperC<FieldWithMetaPriceSchedule> thenArg5 = thenArg4
						.flattenList();
					final MapperC<BigDecimal> thenArg6 = MapperC.<PriceSchedule>of(_thenArg0
						.mapSingleToItem(item -> {
							final MapperC<PriceSchedule> thenArg = MapperC.<PriceSchedule>of(MapperC.<PriceSchedule>of(contract_Price.evaluate(item.get())), MapperS.of(strikePrice.evaluate(item.get())))
								.filterItemNullSafe(_item -> areEqual(_item.<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).andNullSafe(notExists(_item.<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()))).get());
							return thenArg
								.last();
						}), thenArg5
						.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).andNullSafe(notExists(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()))).get()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()))
						.mapItem(item -> item.<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
					return thenArg6
						.last();
				});
			output = MapperS.of(formatToBaseOne18Rate.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
