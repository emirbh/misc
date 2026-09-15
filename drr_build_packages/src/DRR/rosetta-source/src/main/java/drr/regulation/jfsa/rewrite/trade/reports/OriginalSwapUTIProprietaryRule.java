package drr.regulation.jfsa.rewrite.trade.reports;

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
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OriginalSwapUTIProprietaryRule.OriginalSwapUTIProprietaryRuleDefault.class)
public abstract class OriginalSwapUTIProprietaryRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected IsCleared isCleared;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;

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

	public static class OriginalSwapUTIProprietaryRuleDefault extends OriginalSwapUTIProprietaryRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<Trade> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeNEWT.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(item.get())), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(beforeTradeForEvent.evaluate(item.get()));
					}
					return MapperS.<Trade>ofNull();
				});
			final MapperC<TradeIdentifier> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()));
			final MapperC<TradeIdentifier> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			final MapperS<TradeIdentifier> thenArg4 = MapperS.of(thenArg3.get());
			final MapperC<FieldWithMetaString> thenArg5 = thenArg4
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final MapperC<FieldWithMetaString> thenArg6 = thenArg5
				.filterItemNullSafe(item -> {
					final FieldWithMetaString _fieldWithMetaString = item.get();
					return areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate((_fieldWithMetaString == null ? null : _fieldWithMetaString.getValue()))), MapperS.of(false), CardinalityOperator.All).get();
				});
			final FieldWithMetaString fieldWithMetaString = thenArg6
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
