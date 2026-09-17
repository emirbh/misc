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
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.business.events.WithdrawalReason;
import fpml.consolidated.confirmation.processes.ExecutionAdviceRetracted;
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

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapExecutionAdviceRetractedToWorkflowStep.MapExecutionAdviceRetractedToWorkflowStepDefault.class)
public abstract class MapExecutionAdviceRetractedToWorkflowStep implements RosettaFunction {
	
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
	* @param fpmlExecutionAdviceRetracted 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlExecutionAdviceRetracted);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<? extends Trade> fpmlTrade(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<? extends TradeNotionalChange> fpmlTermination(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<? extends TradeNovationContent> fpmlNovation(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<? extends TradeAmendmentContent> fpmlAmendment(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<ActionEnum> action(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<EventIntentEnum> intent(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<Date> eventDate(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	protected abstract MapperS<Date> effectiveDate(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted);

	public static class MapExecutionAdviceRetractedToWorkflowStepDefault extends MapExecutionAdviceRetractedToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlExecutionAdviceRetracted);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			workflowStep = toBuilder(mapWorkflowStep.evaluate(MapperS.of(fpmlExecutionAdviceRetracted).<RequestMessageHeader>map("getHeader", executionAdviceRetracted -> executionAdviceRetracted.getHeader()).<MessageId>map("getMessageId", requestMessageHeader -> requestMessageHeader.getMessageId()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<RequestMessageHeader>map("getHeader", executionAdviceRetracted -> executionAdviceRetracted.getHeader()).<ZonedDateTime>map("getCreationTimestamp", requestMessageHeader -> requestMessageHeader.getCreationTimestamp()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<RequestMessageHeader>map("getHeader", executionAdviceRetracted -> executionAdviceRetracted.getHeader()).<MessageAddress>map("getSentBy", requestMessageHeader -> requestMessageHeader.getSentBy()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<RequestMessageHeader>map("getHeader", executionAdviceRetracted -> executionAdviceRetracted.getHeader()).<MessageAddress>mapC("getSendTo", requestMessageHeader -> requestMessageHeader.getSendTo()).getMulti(), action(fpmlExecutionAdviceRetracted).get(), fpmlTrade(fpmlExecutionAdviceRetracted).get(), fpmlNovation(fpmlExecutionAdviceRetracted).get(), fpmlTermination(fpmlExecutionAdviceRetracted).get(), fpmlAmendment(fpmlExecutionAdviceRetracted).get(), MapperS.of(fpmlExecutionAdviceRetracted).<Party>mapC("getParty", executionAdviceRetracted -> executionAdviceRetracted.getParty()).getMulti(), MapperS.of(fpmlExecutionAdviceRetracted).<Account>mapC("getAccount", executionAdviceRetracted -> executionAdviceRetracted.getAccount()).getMulti(), Collections.<BasicQuotation>emptyList(), intent(fpmlExecutionAdviceRetracted).get(), eventDate(fpmlExecutionAdviceRetracted).get(), effectiveDate(fpmlExecutionAdviceRetracted).get(), null, Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlExecutionAdviceRetracted).<TradePackage>map("getTradePackage", executionAdviceRetracted -> executionAdviceRetracted.getTradePackage()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<Trade>map("getTrade", executionAdviceRetracted -> executionAdviceRetracted.getTrade()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<TradeNovationContent>map("getNovation", executionAdviceRetracted -> executionAdviceRetracted.getNovation()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<TradeNotionalChange>map("getTermination", executionAdviceRetracted -> executionAdviceRetracted.getTermination()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<TradeAmendmentContent>map("getAmendment", executionAdviceRetracted -> executionAdviceRetracted.getAmendment()).get()));
		}
		
		@Override
		protected MapperS<? extends TradeNotionalChange> fpmlTermination(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(fpmlExecutionAdviceRetracted).<TradeNotionalChange>map("getTermination", executionAdviceRetracted -> executionAdviceRetracted.getTermination());
		}
		
		@Override
		protected MapperS<? extends TradeNovationContent> fpmlNovation(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(fpmlExecutionAdviceRetracted).<TradeNovationContent>map("getNovation", executionAdviceRetracted -> executionAdviceRetracted.getNovation());
		}
		
		@Override
		protected MapperS<? extends TradeAmendmentContent> fpmlAmendment(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(fpmlExecutionAdviceRetracted).<TradeAmendmentContent>map("getAmendment", executionAdviceRetracted -> executionAdviceRetracted.getAmendment());
		}
		
		@Override
		protected MapperS<ActionEnum> action(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(mapMessageAction.evaluate(null, MapperS.of(distinct(MapperS.of(fpmlExecutionAdviceRetracted).<Withdrawal>map("getWithdrawal", executionAdviceRetracted -> executionAdviceRetracted.getWithdrawal()).<WithdrawalReason>mapC("getReason", withdrawal -> withdrawal.getReason())).get()).<String>map("getValue", withdrawalReason -> withdrawalReason.getValue()).get()));
		}
		
		@Override
		protected MapperS<EventIntentEnum> intent(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(mapIntent.evaluate(fpmlTrade(fpmlExecutionAdviceRetracted).get(), MapperS.of(fpmlExecutionAdviceRetracted).<OriginatingEvent>map("getOriginatingEvent", executionAdviceRetracted -> executionAdviceRetracted.getOriginatingEvent()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<TerminatingEvent>map("getTerminatingEvent", executionAdviceRetracted -> executionAdviceRetracted.getTerminatingEvent()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<TradeNovationContent>map("getNovation", executionAdviceRetracted -> executionAdviceRetracted.getNovation()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<TradeNotionalChange>map("getTermination", executionAdviceRetracted -> executionAdviceRetracted.getTermination()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<TradeAmendmentContent>map("getAmendment", executionAdviceRetracted -> executionAdviceRetracted.getAmendment()).get(), MapperS.of(fpmlExecutionAdviceRetracted).<OptionExercise>map("getOptionExercise", executionAdviceRetracted -> executionAdviceRetracted.getOptionExercise()).get()));
		}
		
		@Override
		protected MapperS<Date> eventDate(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(getEventDate.evaluate(fpmlAmendment(fpmlExecutionAdviceRetracted).get(), fpmlTermination(fpmlExecutionAdviceRetracted).get(), fpmlNovation(fpmlExecutionAdviceRetracted).get(), fpmlTrade(fpmlExecutionAdviceRetracted).get()));
		}
		
		@Override
		protected MapperS<Date> effectiveDate(ExecutionAdviceRetracted fpmlExecutionAdviceRetracted) {
			return MapperS.of(getEffectiveDate.evaluate(fpmlAmendment(fpmlExecutionAdviceRetracted).get(), fpmlTermination(fpmlExecutionAdviceRetracted).get(), fpmlNovation(fpmlExecutionAdviceRetracted).get()));
		}
	}
}
