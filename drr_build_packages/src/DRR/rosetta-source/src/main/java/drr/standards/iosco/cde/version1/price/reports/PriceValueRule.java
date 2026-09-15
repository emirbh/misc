package drr.standards.iosco.cde.version1.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.functions.CurrentSchedulePeriod;
import drr.base.trade.price.functions.ExtractPriceValue;
import drr.standards.iosco.cde.version1.price.functions.Price;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(PriceValueRule.PriceValueRuleDefault.class)
public abstract class PriceValueRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrentSchedulePeriod currentSchedulePeriod;
	@Inject protected ExtractPriceValue extractPriceValue;
	@Inject protected Price price;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstructionBase input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstructionBase input);

	public static class PriceValueRuleDefault extends PriceValueRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			output = extractPriceValue.evaluate(price.evaluate(input), currentSchedulePeriod.evaluate(input));
			
			return output;
		}
	}
}
