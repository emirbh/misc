package drr.standards.iosco.cde.version1.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralReportInstructionBase;


@ImplementedBy(CurrencyOfExcessCollateralPostedRule.CurrencyOfExcessCollateralPostedRuleDefault.class)
public abstract class CurrencyOfExcessCollateralPostedRule implements ReportFunction<CollateralReportInstructionBase, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstructionBase input);

	public static class CurrencyOfExcessCollateralPostedRuleDefault extends CurrencyOfExcessCollateralPostedRule {
		@Override
		protected String doEvaluate(CollateralReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstructionBase input) {
			output = "";
			
			return output;
		}
	}
}
