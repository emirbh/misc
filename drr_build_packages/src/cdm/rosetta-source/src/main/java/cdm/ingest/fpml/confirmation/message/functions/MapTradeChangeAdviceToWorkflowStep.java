package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.common.ActionEnum;
import cdm.event.common.EventIntentEnum;
import cdm.event.workflow.WorkflowStep;
import cdm.ingest.fpml.confirmation.common.functions.MapMessageAction;
import cdm.ingest.fpml.confirmation.workflowstep.functions.GetEffectiveDate;
import cdm.ingest.fpml.confirmation.workflowstep.functions.GetEventDate;
import cdm.ingest.fpml.confirmation.workflowstep.functions.MapIntent;
import cdm.ingest.fpml.confirmation.workflowstep.functions.MapWorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.confirmation.processes.TradeChangeAdvice;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTradeChangeAdviceToWorkflowStep.MapTradeChangeAdviceToWorkflowStepDefault.class)
public abstract class MapTradeChangeAdviceToWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetEffectiveDate getEffectiveDate;
	@Inject protected GetEventDate getEventDate;
	@Inject protected MapIntent mapIntent;
	@Inject protected MapMessageAction mapMessageAction;
	@Inject protected MapWorkflowStep mapWorkflowStep;

	/**
	* @param fpmlTradeChangeAdvice 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(TradeChangeAdvice fpmlTradeChangeAdvice) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlTradeChangeAdvice);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(TradeChangeAdvice fpmlTradeChangeAdvice);

	protected abstract MapperS<? extends Trade> fpmlTrade(TradeChangeAdvice fpmlTradeChangeAdvice);

	protected abstract MapperS<EventIntentEnum> intent(TradeChangeAdvice fpmlTradeChangeAdvice);

	protected abstract MapperS<Date> eventDate(TradeChangeAdvice fpmlTradeChangeAdvice);

	protected abstract MapperS<Date> effectiveDate(TradeChangeAdvice fpmlTradeChangeAdvice);

	protected abstract MapperS<ActionEnum> action(TradeChangeAdvice fpmlTradeChangeAdvice);

	public static class MapTradeChangeAdviceToWorkflowStepDefault extends MapTradeChangeAdviceToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(TradeChangeAdvice fpmlTradeChangeAdvice) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlTradeChangeAdvice);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, TradeChangeAdvice fpmlTradeChangeAdvice) {
			workflowStep = toBuilder(mapWorkflowStep.evaluate(MapperS.of(fpmlTradeChangeAdvice).<RequestMessageHeader>map("getHeader", tradeChangeAdvice -> tradeChangeAdvice.getHeader()).<MessageId>map("getMessageId", requestMessageHeader -> requestMessageHeader.getMessageId()).get(), MapperS.of(fpmlTradeChangeAdvice).<RequestMessageHeader>map("getHeader", tradeChangeAdvice -> tradeChangeAdvice.getHeader()).<ZonedDateTime>map("getCreationTimestamp", requestMessageHeader -> requestMessageHeader.getCreationTimestamp()).get(), MapperS.of(fpmlTradeChangeAdvice).<RequestMessageHeader>map("getHeader", tradeChangeAdvice -> tradeChangeAdvice.getHeader()).<MessageAddress>map("getSentBy", requestMessageHeader -> requestMessageHeader.getSentBy()).get(), MapperS.of(fpmlTradeChangeAdvice).<RequestMessageHeader>map("getHeader", tradeChangeAdvice -> tradeChangeAdvice.getHeader()).<MessageAddress>mapC("getSendTo", requestMessageHeader -> requestMessageHeader.getSendTo()).getMulti(), action(fpmlTradeChangeAdvice).get(), fpmlTrade(fpmlTradeChangeAdvice).get(), null, null, null, MapperS.of(fpmlTradeChangeAdvice).<Party>mapC("getParty", tradeChangeAdvice -> tradeChangeAdvice.getParty()).getMulti(), MapperS.of(fpmlTradeChangeAdvice).<Account>mapC("getAccount", tradeChangeAdvice -> tradeChangeAdvice.getAccount()).getMulti(), MapperS.of(fpmlTradeChangeAdvice).<BasicQuotation>mapC("getQuote", tradeChangeAdvice -> tradeChangeAdvice.getQuote()).getMulti(), intent(fpmlTradeChangeAdvice).get(), eventDate(fpmlTradeChangeAdvice).get(), effectiveDate(fpmlTradeChangeAdvice).get(), null, Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(TradeChangeAdvice fpmlTradeChangeAdvice) {
			return MapperS.of(fpmlTradeChangeAdvice).<TradeChangeContent>map("getChange", tradeChangeAdvice -> tradeChangeAdvice.getChange()).<Trade>map("getTrade", tradeChangeContent -> tradeChangeContent.getTrade());
		}
		
		@Override
		protected MapperS<EventIntentEnum> intent(TradeChangeAdvice fpmlTradeChangeAdvice) {
			return MapperS.of(mapIntent.evaluate(fpmlTrade(fpmlTradeChangeAdvice).get(), null, null, null, null, null, null));
		}
		
		@Override
		protected MapperS<Date> eventDate(TradeChangeAdvice fpmlTradeChangeAdvice) {
			return MapperS.of(getEventDate.evaluate(null, null, null, fpmlTrade(fpmlTradeChangeAdvice).get()));
		}
		
		@Override
		protected MapperS<Date> effectiveDate(TradeChangeAdvice fpmlTradeChangeAdvice) {
			return MapperS.of(getEffectiveDate.evaluate(null, null, null));
		}
		
		@Override
		protected MapperS<ActionEnum> action(TradeChangeAdvice fpmlTradeChangeAdvice) {
			return MapperS.of(mapMessageAction.evaluate(MapperS.of(fpmlTradeChangeAdvice).<Boolean>map("getIsCorrection", tradeChangeAdvice -> tradeChangeAdvice.getIsCorrection()).get(), null));
		}
	}
}
