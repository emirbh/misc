package drr.base.qualification.event.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.Instruction;
import cdm.event.common.State;
import cdm.event.common.TradeState;
import cdm.event.common.functions.QuantityDecreasedToZero;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.position.PositionStatusEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.TradeStateForEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypeTERM.IsActionTypeTERMDefault.class)
public abstract class IsActionTypeTERM implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityDecreasedToZero quantityDecreasedToZero;
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param reportableEvent 
	* @return isActionTypeTerm 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypeTerm = doEvaluate(reportableEvent);
		
		return isActionTypeTerm;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	public static class IsActionTypeTERMDefault extends IsActionTypeTERM {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypeTerm = null;
			return assignOutput(isActionTypeTerm, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypeTerm, ReportableEventBase reportableEvent) {
			if (areEqual(MapperS.of(quantityDecreasedToZero.evaluate(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState.getValue()).getMulti(), MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter()).getMulti())), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<State>map("getState", tradeState -> tradeState.getState()).<PositionStatusEnum>map("getPositionState", state -> state.getPositionState()), MapperS.of(PositionStatusEnum.CLOSED), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<CounterpartyPositionState>mapC("getAfter", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getAfter()).<State>map("getState", counterpartyPositionState -> counterpartyPositionState.getState()).<PositionStatusEnum>map("getPositionState", state -> state.getPositionState()).get()), MapperS.of(PositionStatusEnum.CLOSED), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.EARLY_TERMINATION_PROVISION), CardinalityOperator.All)).getOrDefault(false)) {
				isActionTypeTerm = true;
			} else {
				isActionTypeTerm = false;
			}
			
			return isActionTypeTerm;
		}
	}
}
