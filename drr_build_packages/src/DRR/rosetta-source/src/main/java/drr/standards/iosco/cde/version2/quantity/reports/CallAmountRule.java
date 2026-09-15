package drr.standards.iosco.cde.version2.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(CallAmountRule.CallAmountRuleDefault.class)
public abstract class CallAmountRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.quantity.reports.CallAmountRule callAmountRule;

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

	public static class CallAmountRuleDefault extends CallAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(callAmountRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
