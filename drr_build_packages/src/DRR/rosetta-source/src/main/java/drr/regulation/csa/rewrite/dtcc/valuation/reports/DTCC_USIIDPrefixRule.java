package drr.regulation.csa.rewrite.dtcc.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;


@ImplementedBy(DTCC_USIIDPrefixRule.DTCC_USIIDPrefixRuleDefault.class)
public abstract class DTCC_USIIDPrefixRule implements ReportFunction<ValuationReportInstruction, Void> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Void evaluate(ValuationReportInstruction input) {
		Void output = doEvaluate(input);
		
		return output;
	}

	protected abstract Void doEvaluate(ValuationReportInstruction input);

	public static class DTCC_USIIDPrefixRuleDefault extends DTCC_USIIDPrefixRule {
		@Override
		protected Void doEvaluate(ValuationReportInstruction input) {
			Void output = null;
			return assignOutput(output, input);
		}
		
		protected Void assignOutput(Void output, ValuationReportInstruction input) {
			output = null;
			
			return output;
		}
	}
}
