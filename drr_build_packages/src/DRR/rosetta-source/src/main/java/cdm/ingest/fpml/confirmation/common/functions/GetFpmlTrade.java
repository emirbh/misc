package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.doc.Trade;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlTrade.GetFpmlTradeDefault.class)
public abstract class GetFpmlTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlTradePackage 
	* @param fpmlInputTrade 
	* @param fpmlNovation 
	* @param fpmlTermination 
	* @param fpmlAmendment 
	* @return fpmlTrade 
	*/
	public Trade evaluate(TradePackage fpmlTradePackage, Trade fpmlInputTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment) {
		Trade.TradeBuilder fpmlTradeBuilder = doEvaluate(fpmlTradePackage, fpmlInputTrade, fpmlNovation, fpmlTermination, fpmlAmendment);
		
		final Trade fpmlTrade;
		if (fpmlTradeBuilder == null) {
			fpmlTrade = null;
		} else {
			fpmlTrade = fpmlTradeBuilder.build();
			objectValidator.validate(Trade.class, fpmlTrade);
		}
		
		return fpmlTrade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(TradePackage fpmlTradePackage, Trade fpmlInputTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment);

	public static class GetFpmlTradeDefault extends GetFpmlTrade {
		@Override
		protected Trade.TradeBuilder doEvaluate(TradePackage fpmlTradePackage, Trade fpmlInputTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment) {
			Trade.TradeBuilder fpmlTrade = Trade.builder();
			return assignOutput(fpmlTrade, fpmlTradePackage, fpmlInputTrade, fpmlNovation, fpmlTermination, fpmlAmendment);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder fpmlTrade, TradePackage fpmlTradePackage, Trade fpmlInputTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment) {
			if (exists(MapperS.of(fpmlTradePackage).<Trade>mapC("getTrade", tradePackage -> tradePackage.getTrade())).getOrDefault(false)) {
				fpmlTrade = toBuilder(MapperS.of(fpmlTradePackage).<Trade>mapC("getTrade", tradePackage -> tradePackage.getTrade()).get());
			} else if (exists(MapperS.of(fpmlInputTrade)).getOrDefault(false)) {
				fpmlTrade = toBuilder(fpmlInputTrade);
			} else if (exists(MapperS.of(fpmlTermination).<Trade>map("getOriginalTrade", tradeNotionalChange -> tradeNotionalChange.getOriginalTrade())).getOrDefault(false)) {
				fpmlTrade = toBuilder(MapperS.of(fpmlTermination).<Trade>map("getOriginalTrade", tradeNotionalChange -> tradeNotionalChange.getOriginalTrade()).get());
			} else if (exists(MapperS.of(fpmlNovation).<Trade>map("getOldTrade", tradeNovationContent -> tradeNovationContent.getOldTrade())).getOrDefault(false)) {
				fpmlTrade = toBuilder(MapperS.of(fpmlNovation).<Trade>map("getOldTrade", tradeNovationContent -> tradeNovationContent.getOldTrade()).get());
			} else if (exists(MapperS.of(fpmlNovation).<Trade>map("getFeeTrade", tradeNovationContent -> tradeNovationContent.getFeeTrade())).getOrDefault(false)) {
				fpmlTrade = toBuilder(MapperS.of(fpmlNovation).<Trade>map("getFeeTrade", tradeNovationContent -> tradeNovationContent.getFeeTrade()).get());
			} else if (exists(MapperS.of(fpmlAmendment).<Trade>map("getTrade", tradeAmendmentContent -> tradeAmendmentContent.getTrade())).getOrDefault(false)) {
				fpmlTrade = toBuilder(MapperS.of(fpmlAmendment).<Trade>map("getTrade", tradeAmendmentContent -> tradeAmendmentContent.getTrade()).get());
			} else {
				fpmlTrade = null;
			}
			
			return Optional.ofNullable(fpmlTrade)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
