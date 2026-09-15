package drr.regulation.csa.rewrite.dtcc.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import drr.standards.iosco.uti.functions.UniqueSwapIdentifierForValuation;
import javax.inject.Inject;


@ImplementedBy(DTCC_USIIDRule.DTCC_USIIDRuleDefault.class)
public abstract class DTCC_USIIDRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;
	@Inject protected UniqueSwapIdentifierForValuation uniqueSwapIdentifierForValuation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class DTCC_USIIDRuleDefault extends DTCC_USIIDRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = uniqueSwapIdentifierForValuation.evaluate(input, supervisoryBodyForCSA.evaluate());
			
			return output;
		}
	}
}
