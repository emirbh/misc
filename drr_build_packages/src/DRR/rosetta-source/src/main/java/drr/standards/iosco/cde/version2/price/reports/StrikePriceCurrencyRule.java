package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.functions.CurrencyPairOrCurrencyFromPrice;
import drr.standards.iosco.cde.version2.price.functions.StrikePrice;
import javax.inject.Inject;


@ImplementedBy(StrikePriceCurrencyRule.StrikePriceCurrencyRuleDefault.class)
public abstract class StrikePriceCurrencyRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyPairOrCurrencyFromPrice currencyPairOrCurrencyFromPrice;
	@Inject protected StrikePrice strikePrice;

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

	public static class StrikePriceCurrencyRuleDefault extends StrikePriceCurrencyRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = currencyPairOrCurrencyFromPrice.evaluate(strikePrice.evaluate(input), true);
			
			return output;
		}
	}
}
