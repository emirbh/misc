package drr.regulation.cftc.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;


@ImplementedBy(DTCC_Comment1Rule.DTCC_Comment1RuleDefault.class)
public abstract class DTCC_Comment1Rule implements ReportFunction<CollateralReportInstruction, Void> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Void evaluate(CollateralReportInstruction input) {
		Void output = doEvaluate(input);
		
		return output;
	}

	protected abstract Void doEvaluate(CollateralReportInstruction input);

	public static class DTCC_Comment1RuleDefault extends DTCC_Comment1Rule {
		@Override
		protected Void doEvaluate(CollateralReportInstruction input) {
			Void output = null;
			return assignOutput(output, input);
		}
		
		protected Void assignOutput(Void output, CollateralReportInstruction input) {
			output = null;
			
			return output;
		}
	}
}
