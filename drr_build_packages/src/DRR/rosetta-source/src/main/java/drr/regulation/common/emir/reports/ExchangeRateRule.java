package drr.regulation.common.emir.reports;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.event.position.CounterpartyPosition;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.ProductForPosition;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.FXNearLeg;
import drr.standards.iso.functions.FormatToBaseOne18Rate;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExchangeRateRule.ExchangeRateRuleDefault.class)
public abstract class ExchangeRateRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FXNearLeg fXNearLeg;
	@Inject protected FormatToBaseOne18Rate formatToBaseOne18Rate;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected ProductForPosition productForPosition;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
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

	public static class ExchangeRateRuleDefault extends ExchangeRateRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<BigDecimal> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(tradeForEvent.evaluate(item.get()))).getOrDefault(false)) {
						final MapperS<Trade> _thenArg0 = item
							.mapSingleToItem(_item -> MapperS.of(tradeForEvent.evaluate(_item.get())));
						final MapperS<Trade> _thenArg1 = _thenArg0
							.filterSingleNullSafe(_item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTermsForProduct.evaluate(productForTrade.evaluate(_item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTermsForProduct.evaluate(productForTrade.evaluate(_item.get())))))).get());
						return _thenArg1
							.mapSingleToItem(trade -> {
								final MapperC<PriceQuantity> __thenArg0 = _thenArg1.<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity())
									.filterItemNullSafe(_item -> areEqual(_item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(fXNearLeg.evaluate(productForTrade.evaluate(trade.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), CardinalityOperator.Any).andNullSafe(areEqual(_item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(fXNearLeg.evaluate(productForTrade.evaluate(trade.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), CardinalityOperator.Any)).get());
								final MapperListOfLists<FieldWithMetaPriceSchedule> __thenArg1 = __thenArg0
									.mapItemToList(_item -> _item.<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()));
								final MapperC<FieldWithMetaPriceSchedule> _thenArg2 = __thenArg1
									.flattenList();
								final MapperC<FieldWithMetaPriceSchedule> _thenArg3 = _thenArg2
									.filterItemNullSafe(_item -> areEqual(_item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).andNullSafe(notExists(_item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()))).get());
								final MapperS<FieldWithMetaPriceSchedule> thenArg4 = MapperS.of(_thenArg3.get());
								return thenArg4
									.mapSingleToItem(_item -> _item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
							});
					}
					if (exists(MapperS.of(positionForEvent.evaluate(item.get()))).getOrDefault(false)) {
						final MapperS<CounterpartyPosition> thenArg2 = item
							.mapSingleToItem(_item -> MapperS.of(positionForEvent.evaluate(_item.get())));
						final MapperS<CounterpartyPosition> thenArg3 = thenArg2
							.filterSingleNullSafe(_item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTermsForProduct.evaluate(productForPosition.evaluate(_item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTermsForProduct.evaluate(productForPosition.evaluate(_item.get())))))).get());
						return thenArg3
							.mapSingleToItem(counterpartyPosition -> {
								final MapperC<PriceQuantity> __thenArg0 = thenArg3.<TradableProduct>map("getPositionBase", _counterpartyPosition -> _counterpartyPosition.getPositionBase()).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity())
									.filterItemNullSafe(_item -> areEqual(_item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(fXNearLeg.evaluate(productForPosition.evaluate(counterpartyPosition.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), CardinalityOperator.Any).andNullSafe(areEqual(_item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(fXNearLeg.evaluate(productForPosition.evaluate(counterpartyPosition.get()))).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), CardinalityOperator.Any)).get());
								final MapperListOfLists<FieldWithMetaPriceSchedule> __thenArg1 = __thenArg0
									.mapItemToList(_item -> _item.<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()));
								final MapperC<FieldWithMetaPriceSchedule> _thenArg2 = __thenArg1
									.flattenList();
								final MapperC<FieldWithMetaPriceSchedule> _thenArg3 = _thenArg2
									.filterItemNullSafe(_item -> areEqual(_item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).andNullSafe(notExists(_item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()))).get());
								final MapperS<FieldWithMetaPriceSchedule> thenArg4 = MapperS.of(_thenArg3.get());
								return thenArg4
									.mapSingleToItem(_item -> _item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
							});
					}
					return MapperS.<BigDecimal>ofNull();
				});
			output = MapperS.of(formatToBaseOne18Rate.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
