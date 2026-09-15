package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.common.ActionEnum;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.Instruction;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import cdm.ingest.fpml.confirmation.datetime.functions.MapEventTimestamp;
import cdm.ingest.fpml.confirmation.tradestate.functions.MapTradeState;
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
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapWorkflowStep.MapWorkflowStepDefault.class)
public abstract class MapWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEventIdentifier mapEventIdentifier;
	@Inject protected MapEventTimestamp mapEventTimestamp;
	@Inject protected MapMessageInformation mapMessageInformation;
	@Inject protected MapNextEvent mapNextEvent;
	@Inject protected MapPrimitiveInstruction mapPrimitiveInstruction;
	@Inject protected MapTradeState mapTradeState;

	/**
	* @param fpmlMessageId 
	* @param creationTimestamp 
	* @param fpmlSentBy 
	* @param fpmlSendToList 
	* @param action 
	* @param fpmlTrade 
	* @param fpmlNovation 
	* @param fpmlTermination 
	* @param fpmlAmendment 
	* @param fpmlPartyList 
	* @param fpmlAccountList 
	* @param fpmlQuoteList 
	* @param intent 
	* @param eventDate 
	* @param effectiveDate 
	* @param fpmlTradingEvents 
	* @param fpmlAdditionalPartyTradeIdentifierList Additional PartyTradeIdentifier - i.e., not specified on the FpML trade.
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(MessageId fpmlMessageId, ZonedDateTime creationTimestamp, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList, ActionEnum action, Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, EventIntentEnum intent, Date eventDate, Date effectiveDate, TradingEventSummary fpmlTradingEvents, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlMessageId, creationTimestamp, fpmlSentBy, fpmlSendToList, action, fpmlTrade, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlPartyList, fpmlAccountList, fpmlQuoteList, intent, eventDate, effectiveDate, fpmlTradingEvents, fpmlAdditionalPartyTradeIdentifierList);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(MessageId fpmlMessageId, ZonedDateTime creationTimestamp, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList, ActionEnum action, Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, EventIntentEnum intent, Date eventDate, Date effectiveDate, TradingEventSummary fpmlTradingEvents, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList);

	public static class MapWorkflowStepDefault extends MapWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(MessageId fpmlMessageId, ZonedDateTime creationTimestamp, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList, ActionEnum action, Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, EventIntentEnum intent, Date eventDate, Date effectiveDate, TradingEventSummary fpmlTradingEvents, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
			if (fpmlSendToList == null) {
				fpmlSendToList = Collections.emptyList();
			}
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			if (fpmlAccountList == null) {
				fpmlAccountList = Collections.emptyList();
			}
			if (fpmlQuoteList == null) {
				fpmlQuoteList = Collections.emptyList();
			}
			if (fpmlAdditionalPartyTradeIdentifierList == null) {
				fpmlAdditionalPartyTradeIdentifierList = Collections.emptyList();
			}
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlMessageId, creationTimestamp, fpmlSentBy, fpmlSendToList, action, fpmlTrade, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlPartyList, fpmlAccountList, fpmlQuoteList, intent, eventDate, effectiveDate, fpmlTradingEvents, fpmlAdditionalPartyTradeIdentifierList);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, MessageId fpmlMessageId, ZonedDateTime creationTimestamp, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList, ActionEnum action, Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, EventIntentEnum intent, Date eventDate, Date effectiveDate, TradingEventSummary fpmlTradingEvents, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
			workflowStep = toBuilder(WorkflowStep.builder()
				.setProposedEvent(EventInstruction.builder()
					.setIntent(intent)
					.setEventDate(eventDate)
					.setEffectiveDate(effectiveDate)
					.setInstruction(MapperC.<Instruction>of(MapperS.of(Instruction.builder()
						.setPrimitiveInstruction(mapPrimitiveInstruction.evaluate(fpmlTrade, fpmlNovation, fpmlTermination, fpmlAmendment))
						.setBeforeValue(mapTradeState.evaluate(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList))
						.build())).getMulti())
					.build())
				.setTimestamp(new ArrayList(mapEventTimestamp.evaluate(creationTimestamp, fpmlTrade)))
				.setEventIdentifier(new ArrayList(mapEventIdentifier.evaluate(fpmlMessageId, fpmlTradingEvents)))
				.setMessageInformation(mapMessageInformation.evaluate(fpmlMessageId, fpmlSentBy, fpmlSendToList))
				.setAction(action)
				.setNextEvent(mapNextEvent.evaluate(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).getMulti()))
				.build());
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
