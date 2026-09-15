package drr.ingest.fpml.recordkeeping.message.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReport;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTradeHeaderForNonpublicExecutionReport.GetTradeHeaderForNonpublicExecutionReportDefault.class)
public abstract class GetTradeHeaderForNonpublicExecutionReport implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlNonpublicExecutionReport 
	* @return fpmlTradeHeader 
	*/
	public TradeHeader evaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
		TradeHeader.TradeHeaderBuilder fpmlTradeHeaderBuilder = doEvaluate(fpmlNonpublicExecutionReport);
		
		final TradeHeader fpmlTradeHeader;
		if (fpmlTradeHeaderBuilder == null) {
			fpmlTradeHeader = null;
		} else {
			fpmlTradeHeader = fpmlTradeHeaderBuilder.build();
			objectValidator.validate(TradeHeader.class, fpmlTradeHeader);
		}
		
		return fpmlTradeHeader;
	}

	protected abstract TradeHeader.TradeHeaderBuilder doEvaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	public static class GetTradeHeaderForNonpublicExecutionReportDefault extends GetTradeHeaderForNonpublicExecutionReport {
		@Override
		protected TradeHeader.TradeHeaderBuilder doEvaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			TradeHeader.TradeHeaderBuilder fpmlTradeHeader = TradeHeader.builder();
			return assignOutput(fpmlTradeHeader, fpmlNonpublicExecutionReport);
		}
		
		protected TradeHeader.TradeHeaderBuilder assignOutput(TradeHeader.TradeHeaderBuilder fpmlTradeHeader, NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			if (exists(MapperS.of(fpmlNonpublicExecutionReport).<Trade>map("getTrade", nonpublicExecutionReport -> nonpublicExecutionReport.getTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader())).getOrDefault(false)) {
				fpmlTradeHeader = toBuilder(MapperS.of(fpmlNonpublicExecutionReport).<Trade>map("getTrade", nonpublicExecutionReport -> nonpublicExecutionReport.getTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).get());
			} else if (exists(MapperS.of(fpmlNonpublicExecutionReport).<TradeNovationContent>map("getNovation", nonpublicExecutionReport -> nonpublicExecutionReport.getNovation()).<Trade>map("getOldTrade", tradeNovationContent -> tradeNovationContent.getOldTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader())).getOrDefault(false)) {
				fpmlTradeHeader = toBuilder(MapperS.of(fpmlNonpublicExecutionReport).<TradeNovationContent>map("getNovation", nonpublicExecutionReport -> nonpublicExecutionReport.getNovation()).<Trade>map("getOldTrade", tradeNovationContent -> tradeNovationContent.getOldTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).get());
			} else if (exists(MapperS.of(fpmlNonpublicExecutionReport).<TradeNotionalChange>map("getTermination", nonpublicExecutionReport -> nonpublicExecutionReport.getTermination()).<Trade>map("getOriginalTrade", tradeNotionalChange -> tradeNotionalChange.getOriginalTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader())).getOrDefault(false)) {
				fpmlTradeHeader = toBuilder(MapperS.of(fpmlNonpublicExecutionReport).<TradeNotionalChange>map("getTermination", nonpublicExecutionReport -> nonpublicExecutionReport.getTermination()).<Trade>map("getOriginalTrade", tradeNotionalChange -> tradeNotionalChange.getOriginalTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).get());
			} else if (exists(MapperS.of(fpmlNonpublicExecutionReport).<TradeAmendmentContent>map("getAmendment", nonpublicExecutionReport -> nonpublicExecutionReport.getAmendment()).<Trade>map("getTrade", tradeAmendmentContent -> tradeAmendmentContent.getTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader())).getOrDefault(false)) {
				fpmlTradeHeader = toBuilder(MapperS.of(fpmlNonpublicExecutionReport).<TradeAmendmentContent>map("getAmendment", nonpublicExecutionReport -> nonpublicExecutionReport.getAmendment()).<Trade>map("getTrade", tradeAmendmentContent -> tradeAmendmentContent.getTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).get());
			} else {
				fpmlTradeHeader = null;
			}
			
			return Optional.ofNullable(fpmlTradeHeader)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
