package drr.standards.iosco.cde.version3.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(CollateralPortfolioCodeRule.CollateralPortfolioCodeRuleDefault.class)
public abstract class CollateralPortfolioCodeRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.collateral.reports.CollateralPortfolioCodeRule collateralPortfolioCodeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class CollateralPortfolioCodeRuleDefault extends CollateralPortfolioCodeRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = collateralPortfolioCodeRule.evaluate(input);
			
			return output;
		}
	}
}
