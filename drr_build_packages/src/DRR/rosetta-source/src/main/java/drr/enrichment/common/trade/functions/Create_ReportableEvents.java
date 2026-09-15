package drr.enrichment.common.trade.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.TradeState;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.functions.Create_AcceptedWorkflowStepFromInstruction;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReportableEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ReportableEvents.Create_ReportableEventsDefault.class)
public abstract class Create_ReportableEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AcceptedWorkflowStepFromInstruction create_AcceptedWorkflowStepFromInstruction;
	@Inject protected IsEligible isEligible;
	@Inject protected PreEnrich preEnrich;
	@Inject protected ReportableEvents reportableEvents;

	/**
	* @param workflowStep 
	* @return reportableEventsOut 
	*/
	public List<? extends ReportableEvent> evaluate(WorkflowStep workflowStep) {
		List<ReportableEvent.ReportableEventBuilder> reportableEventsOutBuilder = doEvaluate(workflowStep);
		
		final List<? extends ReportableEvent> reportableEventsOut;
		if (reportableEventsOutBuilder == null) {
			reportableEventsOut = null;
		} else {
			reportableEventsOut = reportableEventsOutBuilder.stream().map(ReportableEvent::build).collect(Collectors.toList());
			objectValidator.validate(ReportableEvent.class, reportableEventsOut);
		}
		
		return reportableEventsOut;
	}

	protected abstract List<ReportableEvent.ReportableEventBuilder> doEvaluate(WorkflowStep workflowStep);

	protected abstract MapperS<? extends WorkflowStep> workflowStepEvent(WorkflowStep workflowStep);

	protected abstract MapperS<? extends WorkflowStep> enrichedWorkflowStep(WorkflowStep workflowStep);

	protected abstract MapperC<? extends TradeState> eligibleTradeStates(WorkflowStep workflowStep);

	public static class Create_ReportableEventsDefault extends Create_ReportableEvents {
		@Override
		protected List<ReportableEvent.ReportableEventBuilder> doEvaluate(WorkflowStep workflowStep) {
			List<ReportableEvent.ReportableEventBuilder> reportableEventsOut = new ArrayList<>();
			return assignOutput(reportableEventsOut, workflowStep);
		}
		
		protected List<ReportableEvent.ReportableEventBuilder> assignOutput(List<ReportableEvent.ReportableEventBuilder> reportableEventsOut, WorkflowStep workflowStep) {
			reportableEventsOut.addAll(toBuilder(reportableEvents.evaluate(eligibleTradeStates(workflowStep).getMulti(), enrichedWorkflowStep(workflowStep).get())));
			
			return Optional.ofNullable(reportableEventsOut)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends WorkflowStep> workflowStepEvent(WorkflowStep workflowStep) {
			if (notExists(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent())).andNullSafe(exists(MapperS.of(workflowStep).<EventInstruction>map("getProposedEvent", _workflowStep -> _workflowStep.getProposedEvent()))).getOrDefault(false)) {
				return MapperS.of(create_AcceptedWorkflowStepFromInstruction.evaluate(workflowStep));
			}
			return MapperS.of(workflowStep);
		}
		
		@Override
		protected MapperS<? extends WorkflowStep> enrichedWorkflowStep(WorkflowStep workflowStep) {
			return MapperS.of(preEnrich.evaluate(workflowStepEvent(workflowStep).get()));
		}
		
		@Override
		protected MapperC<? extends TradeState> eligibleTradeStates(WorkflowStep workflowStep) {
			return enrichedWorkflowStep(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter())
				.filterItemNullSafe(item -> isEligible.evaluate(item.get(), enrichedWorkflowStep(workflowStep).get()));
		}
	}
}
