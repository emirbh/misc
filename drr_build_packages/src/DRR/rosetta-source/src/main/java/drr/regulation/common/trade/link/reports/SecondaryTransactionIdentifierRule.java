package drr.regulation.common.trade.link.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SecondaryTransactionIdentifierRule.SecondaryTransactionIdentifierRuleDefault.class)
public abstract class SecondaryTransactionIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
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

	public static class SecondaryTransactionIdentifierRuleDefault extends SecondaryTransactionIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			final MapperC<TradeIdentifier> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()));
			final MapperC<TradeIdentifier> thenArg2 = thenArg1
				.filterItemNullSafe(item -> notEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.Any).andNullSafe(notEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.Any)).get());
			final MapperListOfLists<FieldWithMetaString> thenArg3 = thenArg2
				.mapItemToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final MapperC<FieldWithMetaString> thenArg4 = thenArg3
				.flattenList();
			final MapperC<FieldWithMetaString> thenArg5 = distinctIgnoringPrecision(thenArg4);
			final FieldWithMetaString fieldWithMetaString = MapperS.of(thenArg5.get()).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
