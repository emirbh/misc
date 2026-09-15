package drr.regulation.sec.rewrite.dtcc.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(DTCC_ResponsibleDataSubmitterIDRule.DTCC_ResponsibleDataSubmitterIDRuleDefault.class)
public abstract class DTCC_ResponsibleDataSubmitterIDRule implements ReportFunction<TransactionReportInstruction, Void> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_ResponsibleDataSubmitterIDRule dTCC_ResponsibleDataSubmitterIDRule;

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

	public static class DTCC_ResponsibleDataSubmitterIDRuleDefault extends DTCC_ResponsibleDataSubmitterIDRule {
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
