package drr.regulation.esma.emir.article9.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;


@ImplementedBy(BrokerIDRule.BrokerIDRuleDefault.class)
public abstract class BrokerIDRule implements ReportFunction<TransactionReportInstruction, String> {

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

	public static class BrokerIDRuleDefault extends BrokerIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = "Not Modelled";
			
			return output;
		}
	}
}
