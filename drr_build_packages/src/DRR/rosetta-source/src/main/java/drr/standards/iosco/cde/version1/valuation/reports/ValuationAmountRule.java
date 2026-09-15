package drr.standards.iosco.cde.version1.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.valuation.functions.GetValuation;
import drr.standards.iosco.cde.version1.valuation.functions.ValuationAmountFromValuation;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ValuationAmountRule.ValuationAmountRuleDefault.class)
public abstract class ValuationAmountRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetValuation getValuation;
	@Inject protected ValuationAmountFromValuation valuationAmountFromValuation;

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

	public static class ValuationAmountRuleDefault extends ValuationAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(valuationAmountFromValuation.evaluate(getValuation.evaluate(item.get())))).get();
			
			return output;
		}
	}
}
