package drr.base.trade.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TradeStateForEvent.TradeStateForEventDefault.class)
public abstract class TradeStateForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableEvent 
	* @return reportableTradeState 
	*/
	public TradeState evaluate(ReportableEventBase reportableEvent) {
		TradeState.TradeStateBuilder reportableTradeStateBuilder = doEvaluate(reportableEvent);
		
		final TradeState reportableTradeState;
		if (reportableTradeStateBuilder == null) {
			reportableTradeState = null;
		} else {
			reportableTradeState = reportableTradeStateBuilder.build();
			objectValidator.validate(TradeState.class, reportableTradeState);
		}
		
		return reportableTradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class TradeStateForEventDefault extends TradeStateForEvent {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(ReportableEventBase reportableEvent) {
			TradeState.TradeStateBuilder reportableTradeState = TradeState.builder();
			return assignOutput(reportableTradeState, reportableEvent);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder reportableTradeState, ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(reportableEvent).<TradeState>map("getReportableTrade", reportableEventBase -> reportableEventBase.getReportableTrade())).getOrDefault(false)) {
				reportableTradeState = toBuilder(MapperS.of(reportableEvent).<TradeState>map("getReportableTrade", reportableEventBase -> reportableEventBase.getReportableTrade()).get());
			} else {
				reportableTradeState = toBuilder(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter()).get());
			}
			
			return Optional.ofNullable(reportableTradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
