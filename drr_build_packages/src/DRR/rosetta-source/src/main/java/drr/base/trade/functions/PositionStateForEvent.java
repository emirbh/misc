package drr.base.trade.functions;

import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.CounterpartyPositionState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PositionStateForEvent.PositionStateForEventDefault.class)
public abstract class PositionStateForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableEvent 
	* @return reportablePositionState 
	*/
	public CounterpartyPositionState evaluate(ReportableEventBase reportableEvent) {
		CounterpartyPositionState.CounterpartyPositionStateBuilder reportablePositionStateBuilder = doEvaluate(reportableEvent);
		
		final CounterpartyPositionState reportablePositionState;
		if (reportablePositionStateBuilder == null) {
			reportablePositionState = null;
		} else {
			reportablePositionState = reportablePositionStateBuilder.build();
			objectValidator.validate(CounterpartyPositionState.class, reportablePositionState);
		}
		
		return reportablePositionState;
	}

	protected abstract CounterpartyPositionState.CounterpartyPositionStateBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class PositionStateForEventDefault extends PositionStateForEvent {
		@Override
		protected CounterpartyPositionState.CounterpartyPositionStateBuilder doEvaluate(ReportableEventBase reportableEvent) {
			CounterpartyPositionState.CounterpartyPositionStateBuilder reportablePositionState = CounterpartyPositionState.builder();
			return assignOutput(reportablePositionState, reportableEvent);
		}
		
		protected CounterpartyPositionState.CounterpartyPositionStateBuilder assignOutput(CounterpartyPositionState.CounterpartyPositionStateBuilder reportablePositionState, ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(reportableEvent).<CounterpartyPositionState>map("getReportablePosition", reportableEventBase -> reportableEventBase.getReportablePosition())).getOrDefault(false)) {
				reportablePositionState = toBuilder(MapperS.of(reportableEvent).<CounterpartyPositionState>map("getReportablePosition", reportableEventBase -> reportableEventBase.getReportablePosition()).get());
			} else {
				reportablePositionState = toBuilder(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<CounterpartyPositionState>mapC("getAfter", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getAfter()).get());
			}
			
			return Optional.ofNullable(reportablePositionState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
