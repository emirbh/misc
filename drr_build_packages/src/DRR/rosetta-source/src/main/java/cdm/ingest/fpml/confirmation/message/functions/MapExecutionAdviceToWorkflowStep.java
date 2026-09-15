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
import fpml.consolidated.confirmation.processes.ExecutionAdvice;
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

@ImplementedBy(MapExecutionAdviceToWorkflowStep.MapExecutionAdviceToWorkflowStepDefault.class)
public abstract class MapExecutionAdviceToWorkflowStep implements RosettaFunction {
	
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
	* @param fpmlExecutionAdvice 
	* @return workflowStep 
	*/
	public WorkflowStep evaluate(ExecutionAdvice fpmlExecutionAdvice) {
		WorkflowStep.WorkflowStepBuilder workflowStepBuilder = doEvaluate(fpmlExecutionAdvice);
		
		final WorkflowStep workflowStep;
		if (workflowStepBuilder == null) {
			workflowStep = null;
		} else {
			workflowStep = workflowStepBuilder.build();
			objectValidator.validate(WorkflowStep.class, workflowStep);
		}
		
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<? extends Trade> fpmlTrade(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<? extends TradeNotionalChange> fpmlTermination(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<? extends TradeNovationContent> fpmlNovation(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<? extends TradeAmendmentContent> fpmlAmendment(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<ActionEnum> action(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<EventIntentEnum> intent(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<Date> eventDate(ExecutionAdvice fpmlExecutionAdvice);

	protected abstract MapperS<Date> effectiveDate(ExecutionAdvice fpmlExecutionAdvice);

	public static class MapExecutionAdviceToWorkflowStepDefault extends MapExecutionAdviceToWorkflowStep {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(ExecutionAdvice fpmlExecutionAdvice) {
			WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();
			return assignOutput(workflowStep, fpmlExecutionAdvice);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, ExecutionAdvice fpmlExecutionAdvice) {
			workflowStep = toBuilder(mapWorkflowStep.evaluate(MapperS.of(fpmlExecutionAdvice).<RequestMessageHeader>map("getHeader", executionAdvice -> executionAdvice.getHeader()).<MessageId>map("getMessageId", requestMessageHeader -> requestMessageHeader.getMessageId()).get(), MapperS.of(fpmlExecutionAdvice).<RequestMessageHeader>map("getHeader", executionAdvice -> executionAdvice.getHeader()).<ZonedDateTime>map("getCreationTimestamp", requestMessageHeader -> requestMessageHeader.getCreationTimestamp()).get(), MapperS.of(fpmlExecutionAdvice).<RequestMessageHeader>map("getHeader", executionAdvice -> executionAdvice.getHeader()).<MessageAddress>map("getSentBy", requestMessageHeader -> requestMessageHeader.getSentBy()).get(), MapperS.of(fpmlExecutionAdvice).<RequestMessageHeader>map("getHeader", executionAdvice -> executionAdvice.getHeader()).<MessageAddress>mapC("getSendTo", requestMessageHeader -> requestMessageHeader.getSendTo()).getMulti(), action(fpmlExecutionAdvice).get(), fpmlTrade(fpmlExecutionAdvice).get(), fpmlNovation(fpmlExecutionAdvice).get(), fpmlTermination(fpmlExecutionAdvice).get(), fpmlAmendment(fpmlExecutionAdvice).get(), MapperS.of(fpmlExecutionAdvice).<Party>mapC("getParty", executionAdvice -> executionAdvice.getParty()).getMulti(), MapperS.of(fpmlExecutionAdvice).<Account>mapC("getAccount", executionAdvice -> executionAdvice.getAccount()).getMulti(), MapperS.of(fpmlExecutionAdvice).<BasicQuotation>mapC("getQuote", executionAdvice -> executionAdvice.getQuote()).getMulti(), intent(fpmlExecutionAdvice).get(), eventDate(fpmlExecutionAdvice).get(), effectiveDate(fpmlExecutionAdvice).get(), null, Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(workflowStep)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlExecutionAdvice).<TradePackage>map("getTradePackage", executionAdvice -> executionAdvice.getTradePackage()).get(), MapperS.of(fpmlExecutionAdvice).<Trade>map("getTrade", executionAdvice -> executionAdvice.getTrade()).get(), MapperS.of(fpmlExecutionAdvice).<TradeNovationContent>map("getNovation", executionAdvice -> executionAdvice.getNovation()).get(), MapperS.of(fpmlExecutionAdvice).<TradeNotionalChange>map("getTermination", executionAdvice -> executionAdvice.getTermination()).get(), MapperS.of(fpmlExecutionAdvice).<TradeAmendmentContent>map("getAmendment", executionAdvice -> executionAdvice.getAmendment()).get()));
		}
		
		@Override
		protected MapperS<? extends TradeNotionalChange> fpmlTermination(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(fpmlExecutionAdvice).<TradeNotionalChange>map("getTermination", executionAdvice -> executionAdvice.getTermination());
		}
		
		@Override
		protected MapperS<? extends TradeNovationContent> fpmlNovation(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(fpmlExecutionAdvice).<TradeNovationContent>map("getNovation", executionAdvice -> executionAdvice.getNovation());
		}
		
		@Override
		protected MapperS<? extends TradeAmendmentContent> fpmlAmendment(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(fpmlExecutionAdvice).<TradeAmendmentContent>map("getAmendment", executionAdvice -> executionAdvice.getAmendment());
		}
		
		@Override
		protected MapperS<ActionEnum> action(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(mapMessageAction.evaluate(MapperS.of(fpmlExecutionAdvice).<Boolean>map("getIsCorrection", executionAdvice -> executionAdvice.getIsCorrection()).get(), MapperS.of(distinctIgnoringPrecision(MapperS.of(fpmlExecutionAdvice).<Withdrawal>map("getWithdrawal", executionAdvice -> executionAdvice.getWithdrawal()).<WithdrawalReason>mapC("getReason", withdrawal -> withdrawal.getReason())).get()).<String>map("getValue", withdrawalReason -> withdrawalReason.getValue()).get()));
		}
		
		@Override
		protected MapperS<EventIntentEnum> intent(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(mapIntent.evaluate(fpmlTrade(fpmlExecutionAdvice).get(), MapperS.of(fpmlExecutionAdvice).<OriginatingEvent>map("getOriginatingEvent", executionAdvice -> executionAdvice.getOriginatingEvent()).get(), MapperS.of(fpmlExecutionAdvice).<TerminatingEvent>map("getTerminatingEvent", executionAdvice -> executionAdvice.getTerminatingEvent()).get(), MapperS.of(fpmlExecutionAdvice).<TradeNovationContent>map("getNovation", executionAdvice -> executionAdvice.getNovation()).get(), MapperS.of(fpmlExecutionAdvice).<TradeNotionalChange>map("getTermination", executionAdvice -> executionAdvice.getTermination()).get(), MapperS.of(fpmlExecutionAdvice).<TradeAmendmentContent>map("getAmendment", executionAdvice -> executionAdvice.getAmendment()).get(), MapperS.of(fpmlExecutionAdvice).<OptionExercise>map("getOptionExercise", executionAdvice -> executionAdvice.getOptionExercise()).get()));
		}
		
		@Override
		protected MapperS<Date> eventDate(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(getEventDate.evaluate(fpmlAmendment(fpmlExecutionAdvice).get(), fpmlTermination(fpmlExecutionAdvice).get(), fpmlNovation(fpmlExecutionAdvice).get(), fpmlTrade(fpmlExecutionAdvice).get()));
		}
		
		@Override
		protected MapperS<Date> effectiveDate(ExecutionAdvice fpmlExecutionAdvice) {
			return MapperS.of(getEffectiveDate.evaluate(fpmlAmendment(fpmlExecutionAdvice).get(), fpmlTermination(fpmlExecutionAdvice).get(), fpmlNovation(fpmlExecutionAdvice).get()));
		}
	}
}
