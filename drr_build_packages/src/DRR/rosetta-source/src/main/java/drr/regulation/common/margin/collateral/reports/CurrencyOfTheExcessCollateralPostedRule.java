package drr.regulation.common.margin.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.reports.CurrencyOfExcessCollateralPostedRule;
import javax.inject.Inject;


@ImplementedBy(CurrencyOfTheExcessCollateralPostedRule.CurrencyOfTheExcessCollateralPostedRuleDefault.class)
public abstract class CurrencyOfTheExcessCollateralPostedRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyOfExcessCollateralPostedRule currencyOfExcessCollateralPostedRule;

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

	public static class CurrencyOfTheExcessCollateralPostedRuleDefault extends CurrencyOfTheExcessCollateralPostedRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = currencyOfExcessCollateralPostedRule.evaluate(input);
			
			return output;
		}
	}
}
