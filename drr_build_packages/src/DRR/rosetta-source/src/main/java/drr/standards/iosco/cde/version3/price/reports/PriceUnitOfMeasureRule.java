package drr.standards.iosco.cde.version3.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(PriceUnitOfMeasureRule.PriceUnitOfMeasureRuleDefault.class)
public abstract class PriceUnitOfMeasureRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.price.reports.PriceUnitOfMeasureRule priceUnitOfMeasureRule;

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

	public static class PriceUnitOfMeasureRuleDefault extends PriceUnitOfMeasureRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = priceUnitOfMeasureRule.evaluate(input);
			
			return output;
		}
	}
}
