package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.common.ActionEnum;
import cdm.event.common.EventIntentEnum;
import cdm.event.workflow.WorkflowStep;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlTrade;
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
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.ExecutionNotification;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExecutionNotificationToWorkflowStep.MapExecutionNotificationToWorkflowStepDefault.class)
public abstract class MapExecutionNotificationToWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetEffectiveDate getEffectiveDate;
	@Inject protected GetEventDate getEventDate;
	@Inject protected GetFpmlTrade getFpmlTrade;
	@Inject protected MapIntent mapIntent;
	@Inject protected MapMessageAction mapMessageAction;
	@Inject protected MapWorkflowStep mapWorkflowStep;

	/**
	* @param fpmlExecutionNotification 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(ExecutionNotification fpmlExecutionNotification) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlExecutionNotification);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(ExecutionNotification fpmlExecutionNotification);

	protected abstract MapperS<? extends Trade> fpmlTrade(ExecutionNotification fpmlExecutionNotification);

	protected abstract MapperS<ActionEnum> action(ExecutionNotification fpmlExecutionNotification);

	protected abstract MapperS<EventIntentEnum> intent(ExecutionNotification fpmlExecutionNotification);

	protected abstract MapperS<Date> eventDate(ExecutionNotification fpmlExecutionNotification);

	protected abstract MapperS<Date> effectiveDate(ExecutionNotification fpmlExecutionNotification);

	public static class MapExecutionNotificationToWorkflowStepDefault extends MapExecutionNotificationToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(ExecutionNotification fpmlExecutionNotification) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlExecutionNotification);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, ExecutionNotification fpmlExecutionNotification) {
			workflowStep = toBuilder(mapWorkflowStep.evaluate(MapperS.of(fpmlExecutionNotification).<RequestMessageHeader>map("getHeader", executionNotification -> executionNotification.getHeader()).<MessageId>map("getMessageId", requestMessageHeader -> requestMessageHeader.getMessageId()).get(), MapperS.of(fpmlExecutionNotification).<RequestMessageHeader>map("getHeader", executionNotification -> executionNotification.getHeader()).<ZonedDateTime>map("getCreationTimestamp", requestMessageHeader -> requestMessageHeader.getCreationTimestamp()).get(), MapperS.of(fpmlExecutionNotification).<RequestMessageHeader>map("getHeader", executionNotification -> executionNotification.getHeader()).<MessageAddress>map("getSentBy", requestMessageHeader -> requestMessageHeader.getSentBy()).get(), MapperS.of(fpmlExecutionNotification).<RequestMessageHeader>map("getHeader", executionNotification -> executionNotification.getHeader()).<MessageAddress>mapC("getSendTo", requestMessageHeader -> requestMessageHeader.getSendTo()).getMulti(), action(fpmlExecutionNotification).get(), fpmlTrade(fpmlExecutionNotification).get(), null, null, null, MapperS.of(fpmlExecutionNotification).<Party>mapC("getParty", executionNotification -> executionNotification.getParty()).getMulti(), MapperS.of(fpmlExecutionNotification).<Account>mapC("getAccount", executionNotification -> executionNotification.getAccount()).getMulti(), MapperS.of(fpmlExecutionNotification).<BasicQuotation>mapC("getQuote", executionNotification -> executionNotification.getQuote()).getMulti(), intent(fpmlExecutionNotification).get(), eventDate(fpmlExecutionNotification).get(), effectiveDate(fpmlExecutionNotification).get(), null, Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(ExecutionNotification fpmlExecutionNotification) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlExecutionNotification).<TradePackage>map("getTradePackage", executionNotification -> executionNotification.getTradePackage()).get(), MapperS.of(fpmlExecutionNotification).<Trade>map("getTrade", executionNotification -> executionNotification.getTrade()).get(), null, null, null));
		}
		
		@Override
		protected MapperS<ActionEnum> action(ExecutionNotification fpmlExecutionNotification) {
			return MapperS.of(mapMessageAction.evaluate(MapperS.of(fpmlExecutionNotification).<Boolean>map("getIsCorrection", executionNotification -> executionNotification.getIsCorrection()).get(), null));
		}
		
		@Override
		protected MapperS<EventIntentEnum> intent(ExecutionNotification fpmlExecutionNotification) {
			return MapperS.of(mapIntent.evaluate(fpmlTrade(fpmlExecutionNotification).get(), MapperS.of(fpmlExecutionNotification).<OriginatingEvent>map("getOriginatingEvent", executionNotification -> executionNotification.getOriginatingEvent()).get(), null, null, null, null, MapperS.of(fpmlExecutionNotification).<OptionExercise>map("getOptionExercise", executionNotification -> executionNotification.getOptionExercise()).get()));
		}
		
		@Override
		protected MapperS<Date> eventDate(ExecutionNotification fpmlExecutionNotification) {
			return MapperS.of(getEventDate.evaluate(null, null, null, fpmlTrade(fpmlExecutionNotification).get()));
		}
		
		@Override
		protected MapperS<Date> effectiveDate(ExecutionNotification fpmlExecutionNotification) {
			return MapperS.of(getEffectiveDate.evaluate(null, null, null));
		}
	}
}
