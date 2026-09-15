package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;


@ImplementedBy(DTCC_Leg1SettlementPeriodRule.DTCC_Leg1SettlementPeriodRuleDefault.class)
public abstract class DTCC_Leg1SettlementPeriodRule implements ReportFunction<TransactionReportInstruction, Void> {

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

	public static class DTCC_Leg1SettlementPeriodRuleDefault extends DTCC_Leg1SettlementPeriodRule {
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
