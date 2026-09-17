package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.common.EventIntentEnum;
import cdm.event.workflow.WorkflowStep;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlTrade;
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
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.ClearingConfirmed;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapClearingConfirmedToWorkflowStep.MapClearingConfirmedToWorkflowStepDefault.class)
public abstract class MapClearingConfirmedToWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetEffectiveDate getEffectiveDate;
	@Inject protected GetEventDate getEventDate;
	@Inject protected GetFpmlTrade getFpmlTrade;
	@Inject protected MapIntent mapIntent;
	@Inject protected MapWorkflowStep mapWorkflowStep;

	/**
	* @param fpmlClearingConfirmed 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(ClearingConfirmed fpmlClearingConfirmed) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlClearingConfirmed);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(ClearingConfirmed fpmlClearingConfirmed);

	protected abstract MapperS<? extends TradeNotionalChange> fpmlTermination(ClearingConfirmed fpmlClearingConfirmed);

	protected abstract MapperS<? extends Trade> fpmlTrade(ClearingConfirmed fpmlClearingConfirmed);

	protected abstract MapperS<Date> eventDate(ClearingConfirmed fpmlClearingConfirmed);

	protected abstract MapperS<Date> effectiveDate(ClearingConfirmed fpmlClearingConfirmed);

	protected abstract MapperS<EventIntentEnum> intent(ClearingConfirmed fpmlClearingConfirmed);

	public static class MapClearingConfirmedToWorkflowStepDefault extends MapClearingConfirmedToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(ClearingConfirmed fpmlClearingConfirmed) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlClearingConfirmed);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, ClearingConfirmed fpmlClearingConfirmed) {
			workflowStep = toBuilder(mapWorkflowStep.evaluate(MapperS.of(fpmlClearingConfirmed).<NotificationMessageHeader>map("getHeader", clearingConfirmed -> clearingConfirmed.getHeader()).<MessageId>map("getMessageId", notificationMessageHeader -> notificationMessageHeader.getMessageId()).get(), MapperS.of(fpmlClearingConfirmed).<NotificationMessageHeader>map("getHeader", clearingConfirmed -> clearingConfirmed.getHeader()).<ZonedDateTime>map("getCreationTimestamp", notificationMessageHeader -> notificationMessageHeader.getCreationTimestamp()).get(), MapperS.of(fpmlClearingConfirmed).<NotificationMessageHeader>map("getHeader", clearingConfirmed -> clearingConfirmed.getHeader()).<MessageAddress>map("getSentBy", notificationMessageHeader -> notificationMessageHeader.getSentBy()).get(), MapperS.of(fpmlClearingConfirmed).<NotificationMessageHeader>map("getHeader", clearingConfirmed -> clearingConfirmed.getHeader()).<MessageAddress>mapC("getSendTo", notificationMessageHeader -> notificationMessageHeader.getSendTo()).getMulti(), null, fpmlTrade(fpmlClearingConfirmed).get(), null, fpmlTermination(fpmlClearingConfirmed).get(), null, MapperS.of(fpmlClearingConfirmed).<Party>mapC("getParty", clearingConfirmed -> clearingConfirmed.getParty()).getMulti(), MapperS.of(fpmlClearingConfirmed).<Account>mapC("getAccount", clearingConfirmed -> clearingConfirmed.getAccount()).getMulti(), MapperS.of(fpmlClearingConfirmed).<BasicQuotation>mapC("getQuote", clearingConfirmed -> clearingConfirmed.getQuote()).getMulti(), intent(fpmlClearingConfirmed).get(), eventDate(fpmlClearingConfirmed).get(), effectiveDate(fpmlClearingConfirmed).get(), null, Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends TradeNotionalChange> fpmlTermination(ClearingConfirmed fpmlClearingConfirmed) {
			return MapperS.of(fpmlClearingConfirmed).<TradeNotionalChange>map("getTermination", clearingConfirmed -> clearingConfirmed.getTermination());
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(ClearingConfirmed fpmlClearingConfirmed) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlClearingConfirmed).<TradePackage>map("getTradePackage", clearingConfirmed -> clearingConfirmed.getTradePackage()).get(), MapperS.of(fpmlClearingConfirmed).<Trade>map("getTrade", clearingConfirmed -> clearingConfirmed.getTrade()).get(), null, null, null));
		}
		
		@Override
		protected MapperS<Date> eventDate(ClearingConfirmed fpmlClearingConfirmed) {
			return MapperS.of(getEventDate.evaluate(null, fpmlTermination(fpmlClearingConfirmed).get(), null, fpmlTrade(fpmlClearingConfirmed).get()));
		}
		
		@Override
		protected MapperS<Date> effectiveDate(ClearingConfirmed fpmlClearingConfirmed) {
			return MapperS.of(getEffectiveDate.evaluate(null, fpmlTermination(fpmlClearingConfirmed).get(), null));
		}
		
		@Override
		protected MapperS<EventIntentEnum> intent(ClearingConfirmed fpmlClearingConfirmed) {
			return MapperS.of(mapIntent.evaluate(fpmlTrade(fpmlClearingConfirmed).get(), MapperS.of(fpmlClearingConfirmed).<OriginatingEvent>map("getOriginatingEvent", clearingConfirmed -> clearingConfirmed.getOriginatingEvent()).get(), MapperS.of(fpmlClearingConfirmed).<TerminatingEvent>map("getTerminatingEvent", clearingConfirmed -> clearingConfirmed.getTerminatingEvent()).get(), null, null, null, null));
		}
	}
}
