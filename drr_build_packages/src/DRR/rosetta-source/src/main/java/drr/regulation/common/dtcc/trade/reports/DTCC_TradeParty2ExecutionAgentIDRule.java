package drr.regulation.common.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.reports.ExecutionAgentCounterparty2Rule;
import javax.inject.Inject;


@ImplementedBy(DTCC_TradeParty2ExecutionAgentIDRule.DTCC_TradeParty2ExecutionAgentIDRuleDefault.class)
public abstract class DTCC_TradeParty2ExecutionAgentIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExecutionAgentCounterparty2Rule executionAgentCounterparty2Rule;

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

	public static class DTCC_TradeParty2ExecutionAgentIDRuleDefault extends DTCC_TradeParty2ExecutionAgentIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(executionAgentCounterparty2Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
