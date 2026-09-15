package drr.standards.iosco.cde.version1.price.reports;

import cdm.observable.asset.Price;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionPriceValueRule.PackageTransactionPriceValueRuleDefault.class)
public abstract class PackageTransactionPriceValueRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;

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
			final MapperS<Price> thenArg = MapperS.of(packageTransactionPriceRule.evaluate(input));
			output = thenArg.<BigDecimal>map("getValue", price -> price.getValue()).get();
			
			return output;
		}
	}
}
