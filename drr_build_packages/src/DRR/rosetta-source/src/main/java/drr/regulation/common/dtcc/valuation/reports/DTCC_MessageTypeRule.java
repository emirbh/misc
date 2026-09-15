package drr.regulation.common.dtcc.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;


@ImplementedBy(DTCC_MessageTypeRule.DTCC_MessageTypeRuleDefault.class)
public abstract class DTCC_MessageTypeRule implements ReportFunction<ValuationReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class DTCC_MessageTypeRuleDefault extends DTCC_MessageTypeRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = "Valuation";
			
			return output;
		}
	}
}
