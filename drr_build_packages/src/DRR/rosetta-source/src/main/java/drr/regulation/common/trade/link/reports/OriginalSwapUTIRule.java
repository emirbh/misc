package drr.regulation.common.trade.link.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsCleared;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iso.EventTypeEnum;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OriginalSwapUTIRule.OriginalSwapUTIRuleDefault.class)
public abstract class OriginalSwapUTIRule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
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

	public static class OriginalSwapUTIRuleDefault extends OriginalSwapUTIRule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeNEWT.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(item.get())), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(beforeTradeForEvent.evaluate(item.get()));
					}
					return MapperS.<Trade>ofNull();
				});
			final MapperC<TradeIdentifier> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()));
			final MapperC<TradeIdentifier> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			final MapperS<TradeIdentifier> thenArg3 = MapperS.of(thenArg2.get());
			output = thenArg3
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti();
			
			return output;
		}
	}
}
