package drr.regulation.common.trade.link.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IntendedToClear;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.FindLatestAssignedIdentifier;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iso.EventTypeEnum;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingSwapUSIIDRule.ClearingSwapUSIIDRuleDefault.class)
public abstract class ClearingSwapUSIIDRule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected FindLatestAssignedIdentifier findLatestAssignedIdentifier;
	@Inject protected IntendedToClear intendedToClear;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsCleared isCleared;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<String> evaluate(TransactionReportInstruction input) {
		List<String> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction input);

	public static class ClearingSwapUSIIDRuleDefault extends ClearingSwapUSIIDRule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<BusinessEvent> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(intendedToClear.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get()))))).andNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(item.get())), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
						return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent());
					}
					return MapperS.<BusinessEvent>ofNull();
				});
			final MapperC<AssignedIdentifier> thenArg1 = thenArg0
				.mapSingleToList(businessEvent -> {
					final MapperC<TradeIdentifier> _thenArg0 = businessEvent.<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
						.filterItemNullSafe(item -> notEqual(businessEvent.<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()), item, CardinalityOperator.All).get());
					final MapperC<TradeIdentifier> _thenArg1 = _thenArg0
						.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.All).get());
					return _thenArg1
						.mapItem(item -> MapperS.of(findLatestAssignedIdentifier.evaluate(item.get())));
				});
			output = thenArg1
				.mapItem(item -> item.<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti();
			
			return output;
		}
	}
}
