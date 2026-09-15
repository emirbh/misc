package drr.standards.iosco.cde.version3.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionPriceValueRule.PackageTransactionPriceValueRuleDefault.class)
public abstract class PackageTransactionPriceValueRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.price.reports.PackageTransactionPriceValueRule packageTransactionPriceValueRule;

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

	public static class PackageTransactionPriceValueRuleDefault extends PackageTransactionPriceValueRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			output = packageTransactionPriceValueRule.evaluate(input);
			
			return output;
		}
	}
}
