package drr.base.trade.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(BeforeTradeByUTI.BeforeTradeByUTIDefault.class)
public abstract class BeforeTradeByUTI implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableEvent 
	* @param afterTradeUTI 
	* @return trade 
	*/
	public Trade evaluate(ReportableEventBase reportableEvent, String afterTradeUTI) {
		Trade.TradeBuilder tradeBuilder = doEvaluate(reportableEvent, afterTradeUTI);
		
		final Trade trade;
		if (tradeBuilder == null) {
			trade = null;
		} else {
			trade = tradeBuilder.build();
			objectValidator.validate(Trade.class, trade);
		}
		
		return trade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent, String afterTradeUTI);

	public static class BeforeTradeByUTIDefault extends BeforeTradeByUTI {
		@Override
		protected Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent, String afterTradeUTI) {
			Trade.TradeBuilder trade = Trade.builder();
			return assignOutput(trade, reportableEvent, afterTradeUTI);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder trade, ReportableEventBase reportableEvent, String afterTradeUTI) {
			final MapperC<Trade> thenArg = MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade())
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifier>mapC("getTradeIdentifier", _trade -> _trade.getTradeIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of(afterTradeUTI), CardinalityOperator.Any).get());
			trade = toBuilder(MapperS.of(thenArg.get()).get());
			
			return Optional.ofNullable(trade)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
