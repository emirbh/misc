package cdm.observable.asset.fro.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.fro.FloatingRateIndexDefinition;
import cdm.observable.asset.fro.FloatingRateIndexIdentification;
import cdm.observable.asset.fro.FroHistory;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FilterInvalidFloatingRateIndexTradeDate.FilterInvalidFloatingRateIndexTradeDateDefault.class)
public abstract class FilterInvalidFloatingRateIndexTradeDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingRateIndexMetadata floatingRateIndexMetadata;

	/**
	* @param tradeState The input is a trade to validate its floating rate index based on the trade date
	* @return invalidFloatingRateIndex The invalid floating rate index or indices of a trade based on their metadata and the trade date.
	*/
	public List<FloatingRateIndexEnum> evaluate(TradeState tradeState) {
		List<FloatingRateIndexEnum> invalidFloatingRateIndex = doEvaluate(tradeState);
		
		return invalidFloatingRateIndex;
	}

	protected abstract List<FloatingRateIndexEnum> doEvaluate(TradeState tradeState);

	public static class FilterInvalidFloatingRateIndexTradeDateDefault extends FilterInvalidFloatingRateIndexTradeDate {
		@Override
		protected List<FloatingRateIndexEnum> doEvaluate(TradeState tradeState) {
			List<FloatingRateIndexEnum> invalidFloatingRateIndex = new ArrayList<>();
			return assignOutput(invalidFloatingRateIndex, tradeState);
		}
		
		protected List<FloatingRateIndexEnum> assignOutput(List<FloatingRateIndexEnum> invalidFloatingRateIndex, TradeState tradeState) {
			final MapperC<FloatingRateIndexDefinition> thenArg0 = MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex())
				.mapItem(item -> {
					final FieldWithMetaFloatingRateIndexEnum fieldWithMetaFloatingRateIndexEnum = item.get();
					return MapperS.of(floatingRateIndexMetadata.evaluate((fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue())));
				});
			final MapperC<FloatingRateIndexDefinition> thenArg1 = thenArg0
				.filterItemNullSafe(item -> greaterThan(item.<FroHistory>map("getHistory", floatingRateIndexDefinition -> floatingRateIndexDefinition.getHistory()).<Date>map("getStartDate", froHistory -> froHistory.getStartDate()), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<FieldWithMetaDate>map("getTradeDate", trade -> trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate0 -> fieldWithMetaDate0 == null ? null : fieldWithMetaDate0.getValue()), CardinalityOperator.All).orNullSafe(lessThan(item.<FroHistory>map("getHistory", floatingRateIndexDefinition -> floatingRateIndexDefinition.getHistory()).<Date>map("getEndDate", froHistory -> froHistory.getEndDate()), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<FieldWithMetaDate>map("getTradeDate", trade -> trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate1 -> fieldWithMetaDate1 == null ? null : fieldWithMetaDate1.getValue()), CardinalityOperator.All)).get());
			invalidFloatingRateIndex = thenArg1
				.mapItem(item -> item.<FloatingRateIndexIdentification>map("getFro", floatingRateIndexDefinition -> floatingRateIndexDefinition.getFro()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndexIdentification -> floatingRateIndexIdentification.getFloatingRateIndex())).<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum.getValue()).getMulti();
			
			return invalidFloatingRateIndex;
		}
	}
}
