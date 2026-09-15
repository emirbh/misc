package drr.enrichment.common.trade.functions;

import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReportableEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(ReportableEvents.ReportableEventsDefault.class)
public abstract class ReportableEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ReportableEvent create_ReportableEvent;

	/**
	* @param eligibleTradeStates 
	* @param enrichedWorkflowStep 
	* @return reportableEvents 
	*/
	public List<? extends ReportableEvent> evaluate(List<? extends TradeState> eligibleTradeStates, WorkflowStep enrichedWorkflowStep) {
		List<ReportableEvent.ReportableEventBuilder> reportableEventsBuilder = doEvaluate(eligibleTradeStates, enrichedWorkflowStep);
		
		final List<? extends ReportableEvent> reportableEvents;
		if (reportableEventsBuilder == null) {
			reportableEvents = null;
		} else {
			reportableEvents = reportableEventsBuilder.stream().map(ReportableEvent::build).collect(Collectors.toList());
			objectValidator.validate(ReportableEvent.class, reportableEvents);
		}
		
		return reportableEvents;
	}

	protected abstract List<ReportableEvent.ReportableEventBuilder> doEvaluate(List<? extends TradeState> eligibleTradeStates, WorkflowStep enrichedWorkflowStep);

	public static class ReportableEventsDefault extends ReportableEvents {
		@Override
		protected List<ReportableEvent.ReportableEventBuilder> doEvaluate(List<? extends TradeState> eligibleTradeStates, WorkflowStep enrichedWorkflowStep) {
			if (eligibleTradeStates == null) {
				eligibleTradeStates = Collections.emptyList();
			}
			List<ReportableEvent.ReportableEventBuilder> reportableEvents = new ArrayList<>();
			return assignOutput(reportableEvents, eligibleTradeStates, enrichedWorkflowStep);
		}
		
		protected List<ReportableEvent.ReportableEventBuilder> assignOutput(List<ReportableEvent.ReportableEventBuilder> reportableEvents, List<? extends TradeState> eligibleTradeStates, WorkflowStep enrichedWorkflowStep) {
			reportableEvents.addAll(toBuilder(MapperC.<TradeState>of(eligibleTradeStates)
				.mapItem(item -> MapperS.of(create_ReportableEvent.evaluate(item.get(), enrichedWorkflowStep))).getMulti()));
			
			return Optional.ofNullable(reportableEvents)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
