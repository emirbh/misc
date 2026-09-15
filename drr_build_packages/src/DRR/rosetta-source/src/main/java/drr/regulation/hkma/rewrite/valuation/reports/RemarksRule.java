package drr.regulation.hkma.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;


@ImplementedBy(RemarksRule.RemarksRuleDefault.class)
public abstract class RemarksRule implements ReportFunction<ValuationReportInstruction, Void> {

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

	public static class RemarksRuleDefault extends RemarksRule {
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
