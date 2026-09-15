package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version2.price.functions.StrikePrice;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(StrikePriceValueRule.StrikePriceValueRuleDefault.class)
public abstract class StrikePriceValueRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected StrikePrice strikePrice;

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

	public static class StrikePriceValueRuleDefault extends StrikePriceValueRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			output = MapperS.of(strikePrice.evaluate(input)).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).get();
			
			return output;
		}
	}
}
