package drr.regulation.sec.rewrite.dtcc.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(DTCC_ResponsibleDataSubmitterIDTypeRule.DTCC_ResponsibleDataSubmitterIDTypeRuleDefault.class)
public abstract class DTCC_ResponsibleDataSubmitterIDTypeRule implements ReportFunction<TransactionReportInstruction, Void> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_ResponsibleDataSubmitterIDTypeRule dTCC_ResponsibleDataSubmitterIDTypeRule;

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

	public static class DTCC_ResponsibleDataSubmitterIDTypeRuleDefault extends DTCC_ResponsibleDataSubmitterIDTypeRule {
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
