package drr.standards.iosco.cde.version2.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(CurrencyOfExcessCollateralPostedRule.CurrencyOfExcessCollateralPostedRuleDefault.class)
public abstract class CurrencyOfExcessCollateralPostedRule implements ReportFunction<CollateralReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.collateral.reports.CurrencyOfExcessCollateralPostedRule currencyOfExcessCollateralPostedRule;

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
			output = currencyOfExcessCollateralPostedRule.evaluate(input);
			
			return output;
		}
	}
}
