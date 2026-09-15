package drr.regulation.common.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;


@ImplementedBy(DTCC_VersionPPDRule.DTCC_VersionPPDRuleDefault.class)
public abstract class DTCC_VersionPPDRule implements ReportFunction<TransactionReportInstruction, String> {

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

	public static class DTCC_VersionPPDRuleDefault extends DTCC_VersionPPDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = "PPD1.0";
			
			return output;
		}
	}
}
