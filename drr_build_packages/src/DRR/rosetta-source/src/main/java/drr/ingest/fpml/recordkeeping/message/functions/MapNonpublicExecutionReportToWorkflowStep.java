package drr.ingest.fpml.recordkeeping.message.functions;

import cdm.event.common.ActionEnum;
import cdm.event.workflow.WorkflowStep;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlTrade;
import cdm.ingest.fpml.confirmation.common.functions.MapMessageAction;
import cdm.ingest.fpml.confirmation.datetime.functions.MapZoneDateTimeToDate;
import cdm.ingest.fpml.confirmation.workflowstep.functions.MapWorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradingEventSummary;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReport;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNonpublicExecutionReportToWorkflowStep.MapNonpublicExecutionReportToWorkflowStepDefault.class)
public abstract class MapNonpublicExecutionReportToWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlTrade getFpmlTrade;
	@Inject protected MapIntent mapIntent;
	@Inject protected MapMessageAction mapMessageAction;
	@Inject protected MapWorkflowStep mapWorkflowStep;
	@Inject protected MapZoneDateTimeToDate mapZoneDateTimeToDate;

	/**
	* @param fpmlNonpublicExecutionReport 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlNonpublicExecutionReport);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<? extends Trade> fpmlTrade(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<ActionEnum> action(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<? extends TradeNotionalChange> fpmlTermination(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<? extends TradeNovationContent> fpmlNovation(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<? extends TradeAmendmentContent> fpmlAmendment(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<Date> eventDate(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<ZonedDateTime> tradingEventEffectiveDate(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperS<Date> effectiveDate(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperC<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifier(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	public static class MapNonpublicExecutionReportToWorkflowStepDefault extends MapNonpublicExecutionReportToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlNonpublicExecutionReport);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			workflowStep = toBuilder(mapWorkflowStep.evaluate(MapperS.of(fpmlNonpublicExecutionReport).<RequestMessageHeader>map("getHeader", nonpublicExecutionReport -> nonpublicExecutionReport.getHeader()).<MessageId>map("getMessageId", requestMessageHeader -> requestMessageHeader.getMessageId()).get(), MapperS.of(fpmlNonpublicExecutionReport).<RequestMessageHeader>map("getHeader", nonpublicExecutionReport -> nonpublicExecutionReport.getHeader()).<ZonedDateTime>map("getCreationTimestamp", requestMessageHeader -> requestMessageHeader.getCreationTimestamp()).get(), MapperS.of(fpmlNonpublicExecutionReport).<RequestMessageHeader>map("getHeader", nonpublicExecutionReport -> nonpublicExecutionReport.getHeader()).<MessageAddress>map("getSentBy", requestMessageHeader -> requestMessageHeader.getSentBy()).get(), MapperS.of(fpmlNonpublicExecutionReport).<RequestMessageHeader>map("getHeader", nonpublicExecutionReport -> nonpublicExecutionReport.getHeader()).<MessageAddress>mapC("getSendTo", requestMessageHeader -> requestMessageHeader.getSendTo()).getMulti(), action(fpmlNonpublicExecutionReport).get(), fpmlTrade(fpmlNonpublicExecutionReport).get(), MapperS.of(fpmlNonpublicExecutionReport).<TradeNovationContent>map("getNovation", nonpublicExecutionReport -> nonpublicExecutionReport.getNovation()).get(), MapperS.of(fpmlNonpublicExecutionReport).<TradeNotionalChange>map("getTermination", nonpublicExecutionReport -> nonpublicExecutionReport.getTermination()).get(), MapperS.of(fpmlNonpublicExecutionReport).<TradeAmendmentContent>map("getAmendment", nonpublicExecutionReport -> nonpublicExecutionReport.getAmendment()).get(), MapperS.of(fpmlNonpublicExecutionReport).<Party>mapC("getParty", nonpublicExecutionReport -> nonpublicExecutionReport.getParty()).getMulti(), MapperS.of(fpmlNonpublicExecutionReport).<Account>mapC("getAccount", nonpublicExecutionReport -> nonpublicExecutionReport.getAccount()).getMulti(), MapperS.of(fpmlNonpublicExecutionReport).<BasicQuotation>mapC("getQuote", nonpublicExecutionReport -> nonpublicExecutionReport.getQuote()).getMulti(), mapIntent.evaluate(fpmlNonpublicExecutionReport), eventDate(fpmlNonpublicExecutionReport).get(), effectiveDate(fpmlNonpublicExecutionReport).get(), MapperS.of(fpmlNonpublicExecutionReport).<TradingEventSummary>mapC("getTradingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getTradingEvent()).get(), fpmlAdditionalPartyTradeIdentifier(fpmlNonpublicExecutionReport).getMulti()));
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(MapperS.of(fpmlNonpublicExecutionReport).<Trade>map("getTrade", nonpublicExecutionReport -> nonpublicExecutionReport.getTrade()).getOrDefault(getFpmlTrade.evaluate(null, null, MapperS.of(fpmlNonpublicExecutionReport).<TradeNovationContent>map("getNovation", nonpublicExecutionReport -> nonpublicExecutionReport.getNovation()).get(), MapperS.of(fpmlNonpublicExecutionReport).<TradeNotionalChange>map("getTermination", nonpublicExecutionReport -> nonpublicExecutionReport.getTermination()).get(), MapperS.of(fpmlNonpublicExecutionReport).<TradeAmendmentContent>map("getAmendment", nonpublicExecutionReport -> nonpublicExecutionReport.getAmendment()).get())));
		}
		
		@Override
		protected MapperS<ActionEnum> action(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(mapMessageAction.evaluate(MapperS.of(fpmlNonpublicExecutionReport).<Boolean>map("getIsCorrection", nonpublicExecutionReport -> nonpublicExecutionReport.getIsCorrection()).get(), null));
		}
		
		@Override
		protected MapperS<? extends TradeNotionalChange> fpmlTermination(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(fpmlNonpublicExecutionReport).<TradeNotionalChange>map("getTermination", nonpublicExecutionReport -> nonpublicExecutionReport.getTermination());
		}
		
		@Override
		protected MapperS<? extends TradeNovationContent> fpmlNovation(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(fpmlNonpublicExecutionReport).<TradeNovationContent>map("getNovation", nonpublicExecutionReport -> nonpublicExecutionReport.getNovation());
		}
		
		@Override
		protected MapperS<? extends TradeAmendmentContent> fpmlAmendment(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(fpmlNonpublicExecutionReport).<TradeAmendmentContent>map("getAmendment", nonpublicExecutionReport -> nonpublicExecutionReport.getAmendment());
		}
		
		@Override
		protected MapperS<Date> eventDate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			if (exists(fpmlNovation(fpmlNonpublicExecutionReport)).getOrDefault(false)) {
				return MapperS.<Date>ofNull();
			}
			final MapperS<ZonedDateTime> thenArg0 = fpmlAmendment(fpmlNonpublicExecutionReport).<ZonedDateTime>map("getAgreementDate", tradeAmendmentContent -> tradeAmendmentContent.getAgreementDate());
			final MapperS<ZonedDateTime> thenArg1 = MapperS.of(thenArg0.getOrDefault(fpmlAmendment(fpmlNonpublicExecutionReport).<Trade>map("getTrade", tradeAmendmentContent -> tradeAmendmentContent.getTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<ExecutionDateTime>map("getExecutionDateTime", partyTradeInformation -> partyTradeInformation.getExecutionDateTime()).<ZonedDateTime>map("getValue", executionDateTime -> executionDateTime.getValue())
				.first().get()));
			final MapperS<ZonedDateTime> thenArg2 = MapperS.of(thenArg1.getOrDefault(fpmlTermination(fpmlNonpublicExecutionReport).<ZonedDateTime>map("getAgreementDate", tradeNotionalChange -> tradeNotionalChange.getAgreementDate()).get()));
			final MapperS<ZonedDateTime> thenArg3 = MapperS.of(thenArg2.getOrDefault(fpmlTermination(fpmlNonpublicExecutionReport).<Trade>map("getOriginalTrade", tradeNotionalChange -> tradeNotionalChange.getOriginalTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<ExecutionDateTime>map("getExecutionDateTime", partyTradeInformation -> partyTradeInformation.getExecutionDateTime()).<ZonedDateTime>map("getValue", executionDateTime -> executionDateTime.getValue())
				.first().get()));
			final MapperS<ZonedDateTime> thenArg4 = MapperS.of(thenArg3.getOrDefault(fpmlTrade(fpmlNonpublicExecutionReport).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<ExecutionDateTime>map("getExecutionDateTime", partyTradeInformation -> partyTradeInformation.getExecutionDateTime()).<ZonedDateTime>map("getValue", executionDateTime -> executionDateTime.getValue())
				.first().get()));
			final MapperS<ZonedDateTime> thenArg5 = MapperS.of(thenArg4.getOrDefault(MapperS.of(fpmlNonpublicExecutionReport).<TradingEventSummary>mapC("getTradingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getTradingEvent()).<ZonedDateTime>map("getAgreementDate", tradingEventSummary -> tradingEventSummary.getAgreementDate())
				.first().get()));
			final MapperS<ZonedDateTime> thenArg6 = MapperS.of(thenArg5.getOrDefault(fpmlNovation(fpmlNonpublicExecutionReport).<ZonedDateTime>map("getNovationDate", tradeNovationContent -> tradeNovationContent.getNovationDate()).get()));
			final MapperS<ZonedDateTime> thenArg7 = MapperS.of(thenArg6.getOrDefault(fpmlNovation(fpmlNonpublicExecutionReport).<ZonedDateTime>map("getNovationTradeDate", tradeNovationContent -> tradeNovationContent.getNovationTradeDate()).get()));
			return MapperS.of(mapZoneDateTimeToDate.evaluate(thenArg7.get()));
		}
		
		@Override
		protected MapperS<ZonedDateTime> tradingEventEffectiveDate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(fpmlNonpublicExecutionReport).<TradingEventSummary>mapC("getTradingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getTradingEvent()).<ZonedDateTime>map("getEffectiveDate", tradingEventSummary -> tradingEventSummary.getEffectiveDate())
				.first();
		}
		
		@Override
		protected MapperS<Date> effectiveDate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			final MapperS<ZonedDateTime> thenArg = MapperS.of(tradingEventEffectiveDate(fpmlNonpublicExecutionReport).getOrDefault(fpmlTermination(fpmlNonpublicExecutionReport).<ZonedDateTime>map("getEffectiveDate", tradeNotionalChange -> tradeNotionalChange.getEffectiveDate()).get()));
			return MapperS.of(mapZoneDateTimeToDate.evaluate(thenArg.get()));
		}
		
		@Override
		protected MapperC<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifier(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(fpmlNonpublicExecutionReport).<Withdrawal>map("getWithdrawal", nonpublicExecutionReport -> nonpublicExecutionReport.getWithdrawal()).<PartyTradeIdentifier>mapC("getPartyTradeIdentifier", withdrawal -> withdrawal.getPartyTradeIdentifier());
		}
	}
}
