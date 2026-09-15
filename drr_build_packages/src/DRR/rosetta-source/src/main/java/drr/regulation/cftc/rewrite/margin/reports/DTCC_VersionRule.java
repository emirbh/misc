package drr.regulation.cftc.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;


@ImplementedBy(DTCC_VersionRule.DTCC_VersionRuleDefault.class)
public abstract class DTCC_VersionRule implements ReportFunction<CollateralReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class DTCC_VersionRuleDefault extends DTCC_VersionRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = "Coll1.0";
			
			return output;
		}
	}
}
