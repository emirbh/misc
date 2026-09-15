package drr.base.qualification.event.functions;

import cdm.event.common.ActionEnum;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.CounterpartyPositionState;
import cdm.event.position.CounterpartyPosition;
import cdm.event.workflow.WorkflowStep;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import java.time.LocalDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypePositionMODI.IsActionTypePositionMODIDefault.class)
public abstract class IsActionTypePositionMODI implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return isActionTypePositionModi 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypePositionModi = doEvaluate(reportableEvent);
		
		return isActionTypePositionModi;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<Date> openPositionDate(ReportableEventBase reportableEvent);

	protected abstract MapperS<Date> eventDate(ReportableEventBase reportableEvent);

	public static class IsActionTypePositionMODIDefault extends IsActionTypePositionMODI {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypePositionModi = null;
			return assignOutput(isActionTypePositionModi, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypePositionModi, ReportableEventBase reportableEvent) {
			if (areEqual(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction()), MapperS.of(ActionEnum.NEW), CardinalityOperator.All).andNullSafe(exists(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()))).andNullSafe(lessThan(openPositionDate(reportableEvent), eventDate(reportableEvent), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				isActionTypePositionModi = true;
			} else {
				isActionTypePositionModi = false;
			}
			
			return isActionTypePositionModi;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent)));
		}
		
		@Override
		protected MapperS<Date> openPositionDate(ReportableEventBase reportableEvent) {
			return MapperS.of(distinctIgnoringPrecision(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<CounterpartyPositionState>mapC("getAfter", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getAfter()).<CounterpartyPosition>map("getCounterpartyPosition", counterpartyPositionState -> counterpartyPositionState.getCounterpartyPosition()).<LocalDateTime>map("getOpenDateTime", counterpartyPosition -> counterpartyPosition.getOpenDateTime()).<Date>map("Date", dt -> Date.of(dt.toLocalDate()))).get());
		}
		
		@Override
		protected MapperS<Date> eventDate(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<Date>map("getEventDate", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getEventDate());
		}
	}
}
