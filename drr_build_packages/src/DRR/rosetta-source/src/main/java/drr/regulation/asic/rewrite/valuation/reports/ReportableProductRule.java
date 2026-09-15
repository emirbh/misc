package drr.regulation.asic.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;


@ImplementedBy(ReportableProductRule.ReportableProductRuleDefault.class)
public abstract class ReportableProductRule implements ReportFunction<ValuationReportInstruction, Boolean> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(ValuationReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(ValuationReportInstruction input);

	public static class ReportableProductRuleDefault extends ReportableProductRule {
		@Override
		protected Boolean doEvaluate(ValuationReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, ValuationReportInstruction input) {
			output = true;
			
			return output;
		}
	}
}
