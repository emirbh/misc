package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(DTCC_CorporateActionNewTradeParty1LEIRule.DTCC_CorporateActionNewTradeParty1LEIRuleDefault.class)
public abstract class DTCC_CorporateActionNewTradeParty1LEIRule implements ReportFunction<TransactionReportInstruction, Void> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_CorporateActionNewTradeParty1LEIRule dTCC_CorporateActionNewTradeParty1LEIRule;

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

	public static class DTCC_CorporateActionNewTradeParty1LEIRuleDefault extends DTCC_CorporateActionNewTradeParty1LEIRule {
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
