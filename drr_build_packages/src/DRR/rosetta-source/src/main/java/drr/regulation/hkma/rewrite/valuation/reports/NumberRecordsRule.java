package drr.regulation.hkma.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;


@ImplementedBy(NumberRecordsRule.NumberRecordsRuleDefault.class)
public abstract class NumberRecordsRule implements ReportFunction<ValuationReportInstruction, Void> {

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

	public static class NumberRecordsRuleDefault extends NumberRecordsRule {
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
