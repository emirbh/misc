package drr.enrichment.common.trade.functions;

import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.common.ReportableEvent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ReportableEvent.Create_ReportableEventDefault.class)
public abstract class Create_ReportableEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PostEnrich postEnrich;

	/**
	* @param tradeState 
	* @param enrichedWorkflowStep 
	* @return reportableEvent 
	*/
	public ReportableEvent evaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
		ReportableEvent.ReportableEventBuilder reportableEventBuilder = doEvaluate(tradeState, enrichedWorkflowStep);
		
		final ReportableEvent reportableEvent;
		if (reportableEventBuilder == null) {
			reportableEvent = null;
		} else {
			reportableEvent = reportableEventBuilder.build();
			objectValidator.validate(ReportableEvent.class, reportableEvent);
		}
		
		return reportableEvent;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep);

	public static class Create_ReportableEventDefault extends Create_ReportableEvent {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
			ReportableEvent.ReportableEventBuilder reportableEvent = ReportableEvent.builder();
			return assignOutput(reportableEvent, tradeState, enrichedWorkflowStep);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder reportableEvent, TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
			reportableEvent = toBuilder(ReportableEvent.builder()
				.setOriginatingWorkflowStep(enrichedWorkflowStep)
				.setReportableTrade(tradeState)
				.setReportableInformation(postEnrich.evaluate(tradeState, enrichedWorkflowStep))
				.build());
			
			return Optional.ofNullable(reportableEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
