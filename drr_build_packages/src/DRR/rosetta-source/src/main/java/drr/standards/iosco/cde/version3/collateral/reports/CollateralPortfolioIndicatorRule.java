package drr.standards.iosco.cde.version3.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(CollateralPortfolioIndicatorRule.CollateralPortfolioIndicatorRuleDefault.class)
public abstract class CollateralPortfolioIndicatorRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.collateral.reports.CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstructionBase input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstructionBase input);

	public static class CollateralPortfolioIndicatorRuleDefault extends CollateralPortfolioIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = collateralPortfolioIndicatorRule.evaluate(input);
			
			return output;
		}
	}
}
