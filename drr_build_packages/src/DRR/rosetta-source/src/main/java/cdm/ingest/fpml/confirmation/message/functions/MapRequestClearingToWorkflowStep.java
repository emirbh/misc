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
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.RequestClearing;
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


@ImplementedBy(MapRequestClearingToWorkflowStep.MapRequestClearingToWorkflowStepDefault.class)
public abstract class MapRequestClearingToWorkflowStep implements RosettaFunction {
	
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
	* @param fpmlRequestClearing 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(RequestClearing fpmlRequestClearing) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlRequestClearing);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(RequestClearing fpmlRequestClearing);

	protected abstract MapperS<? extends Trade> fpmlTrade(RequestClearing fpmlRequestClearing);

	protected abstract MapperS<EventIntentEnum> intent(RequestClearing fpmlRequestClearing);

	protected abstract MapperS<Date> eventDate(RequestClearing fpmlRequestClearing);

	protected abstract MapperS<Date> effectiveDate(RequestClearing fpmlRequestClearing);

	protected abstract MapperS<ActionEnum> action(RequestClearing fpmlRequestClearing);

	public static class MapRequestClearingToWorkflowStepDefault extends MapRequestClearingToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(RequestClearing fpmlRequestClearing) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlRequestClearing);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, RequestClearing fpmlRequestClearing) {
			workflowStep = toBuilder(mapWorkflowStep.evaluate(MapperS.of(fpmlRequestClearing).<RequestMessageHeader>map("getHeader", requestClearing -> requestClearing.getHeader()).<MessageId>map("getMessageId", requestMessageHeader -> requestMessageHeader.getMessageId()).get(), MapperS.of(fpmlRequestClearing).<RequestMessageHeader>map("getHeader", requestClearing -> requestClearing.getHeader()).<ZonedDateTime>map("getCreationTimestamp", requestMessageHeader -> requestMessageHeader.getCreationTimestamp()).get(), MapperS.of(fpmlRequestClearing).<RequestMessageHeader>map("getHeader", requestClearing -> requestClearing.getHeader()).<MessageAddress>map("getSentBy", requestMessageHeader -> requestMessageHeader.getSentBy()).get(), MapperS.of(fpmlRequestClearing).<RequestMessageHeader>map("getHeader", requestClearing -> requestClearing.getHeader()).<MessageAddress>mapC("getSendTo", requestMessageHeader -> requestMessageHeader.getSendTo()).getMulti(), action(fpmlRequestClearing).get(), fpmlTrade(fpmlRequestClearing).get(), null, null, null, MapperS.of(fpmlRequestClearing).<Party>mapC("getParty", requestClearing -> requestClearing.getParty()).getMulti(), MapperS.of(fpmlRequestClearing).<Account>mapC("getAccount", requestClearing -> requestClearing.getAccount()).getMulti(), MapperS.of(fpmlRequestClearing).<BasicQuotation>mapC("getQuote", requestClearing -> requestClearing.getQuote()).getMulti(), intent(fpmlRequestClearing).get(), eventDate(fpmlRequestClearing).get(), effectiveDate(fpmlRequestClearing).get(), null, Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(RequestClearing fpmlRequestClearing) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlRequestClearing).<TradePackage>map("getTradePackage", requestClearing -> requestClearing.getTradePackage()).get(), MapperS.of(fpmlRequestClearing).<Trade>map("getTrade", requestClearing -> requestClearing.getTrade()).get(), null, null, null));
		}
		
		@Override
		protected MapperS<EventIntentEnum> intent(RequestClearing fpmlRequestClearing) {
			return MapperS.of(mapIntent.evaluate(fpmlTrade(fpmlRequestClearing).get(), MapperS.of(fpmlRequestClearing).<OriginatingEvent>map("getOriginatingEvent", requestClearing -> requestClearing.getOriginatingEvent()).get(), null, null, null, null, null));
		}
		
		@Override
		protected MapperS<Date> eventDate(RequestClearing fpmlRequestClearing) {
			return MapperS.of(getEventDate.evaluate(null, null, null, fpmlTrade(fpmlRequestClearing).get()));
		}
		
		@Override
		protected MapperS<Date> effectiveDate(RequestClearing fpmlRequestClearing) {
			return MapperS.of(getEffectiveDate.evaluate(null, null, null));
		}
		
		@Override
		protected MapperS<ActionEnum> action(RequestClearing fpmlRequestClearing) {
			return MapperS.of(mapMessageAction.evaluate(MapperS.of(fpmlRequestClearing).<Boolean>map("getIsCorrection", requestClearing -> requestClearing.getIsCorrection()).get(), null));
		}
	}
}
