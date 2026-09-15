package drr.regulation.common.trade.link.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriorUSIRule.PriorUSIRuleDefault.class)
public abstract class PriorUSIRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected Qualify_Compression qualify_Compression;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class PriorUSIRuleDefault extends PriorUSIRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (notEqual(MapperS.of(tradeForEvent.evaluate(item.get())).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue()), MapperS.of(beforeTradeForEvent.evaluate(item.get())).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(qualify_Compression.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get())), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(beforeTradeForEvent.evaluate(item.get()));
					}
					return MapperS.<Trade>ofNull();
				});
			final MapperC<TradeIdentifier> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()));
			final MapperC<TradeIdentifier> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.All).get());
			final MapperS<TradeIdentifier> thenArg3 = MapperS.of(thenArg2.get());
			final MapperC<FieldWithMetaString> thenArg4 = thenArg3
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = thenArg4
				.last().get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
