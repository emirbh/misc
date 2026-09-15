package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(DTCC_TradeParty1ExecutionAgentIDRule.DTCC_TradeParty1ExecutionAgentIDRuleDefault.class)
public abstract class DTCC_TradeParty1ExecutionAgentIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ExecutionAgentIDRule dTCC_TradeParty1ExecutionAgentIDRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

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

	public static class DTCC_TradeParty1ExecutionAgentIDRuleDefault extends DTCC_TradeParty1ExecutionAgentIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(dTCC_TradeParty1ExecutionAgentIDRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
