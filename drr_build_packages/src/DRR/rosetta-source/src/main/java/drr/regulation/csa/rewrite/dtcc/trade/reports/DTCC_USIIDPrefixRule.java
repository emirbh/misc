package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;


@ImplementedBy(DTCC_USIIDPrefixRule.DTCC_USIIDPrefixRuleDefault.class)
public abstract class DTCC_USIIDPrefixRule implements ReportFunction<TransactionReportInstruction, Void> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Void evaluate(TransactionReportInstruction input) {
		Void output = doEvaluate(input);
		
		return output;
	}

	protected abstract Void doEvaluate(TransactionReportInstruction input);

	public static class DTCC_USIIDPrefixRuleDefault extends DTCC_USIIDPrefixRule {
		@Override
		protected Void doEvaluate(TransactionReportInstruction input) {
			Void output = null;
			return assignOutput(output, input);
		}
		
		protected Void assignOutput(Void output, TransactionReportInstruction input) {
			output = null;
			
			return output;
		}
	}
}
