package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapZoneDateTimeToDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetEventDate.GetEventDateDefault.class)
public abstract class GetEventDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected MapZoneDateTimeToDate mapZoneDateTimeToDate;

	/**
	* @param fpmlAmendment 
	* @param fpmlTermination 
	* @param fpmlNovation 
	* @param fpmlTrade 
	* @return eventDate 
	*/
	public Date evaluate(TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation, Trade fpmlTrade) {
		Date eventDate = doEvaluate(fpmlAmendment, fpmlTermination, fpmlNovation, fpmlTrade);
		
		return eventDate;
	}

	protected abstract Date doEvaluate(TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation, Trade fpmlTrade);

	public static class GetEventDateDefault extends GetEventDate {
		@Override
		protected Date doEvaluate(TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation, Trade fpmlTrade) {
			Date eventDate = null;
			return assignOutput(eventDate, fpmlAmendment, fpmlTermination, fpmlNovation, fpmlTrade);
		}
		
		protected Date assignOutput(Date eventDate, TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation, Trade fpmlTrade) {
			if (exists(MapperS.of(fpmlAmendment).<ZonedDateTime>map("getAgreementDate", tradeAmendmentContent -> tradeAmendmentContent.getAgreementDate())).getOrDefault(false)) {
				eventDate = mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlAmendment).<ZonedDateTime>map("getAgreementDate", tradeAmendmentContent -> tradeAmendmentContent.getAgreementDate()).get());
			} else if (exists(MapperS.of(fpmlTermination).<ZonedDateTime>map("getAgreementDate", tradeNotionalChange -> tradeNotionalChange.getAgreementDate())).getOrDefault(false)) {
				eventDate = mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlTermination).<ZonedDateTime>map("getAgreementDate", tradeNotionalChange -> tradeNotionalChange.getAgreementDate()).get());
			} else if (exists(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<ExecutionDateTime>map("getExecutionDateTime", partyTradeInformation -> partyTradeInformation.getExecutionDateTime()).<ZonedDateTime>map("getValue", executionDateTime -> executionDateTime.getValue())).getOrDefault(false)) {
				final MapperC<ZonedDateTime> thenArg = MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<ExecutionDateTime>map("getExecutionDateTime", partyTradeInformation -> partyTradeInformation.getExecutionDateTime()).<ZonedDateTime>map("getValue", executionDateTime -> executionDateTime.getValue())
					.filterItemNullSafe(item -> exists(item).get());
				eventDate = mapZoneDateTimeToDate.evaluate(MapperS.of(thenArg.get()).get());
			} else if (exists(MapperS.of(fpmlNovation).<ZonedDateTime>map("getNovationDate", tradeNovationContent -> tradeNovationContent.getNovationDate())).getOrDefault(false)) {
				eventDate = mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlNovation).<ZonedDateTime>map("getNovationDate", tradeNovationContent -> tradeNovationContent.getNovationDate()).get());
			} else {
				eventDate = null;
			}
			
			return eventDate;
		}
	}
}
