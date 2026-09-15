package drr.standards.iosco.cde.version3.valuation.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(ValuationCurrencyRule.ValuationCurrencyRuleDefault.class)
public abstract class ValuationCurrencyRule implements ReportFunction<TransactionReportInstructionBase, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.valuation.reports.ValuationCurrencyRule valuationCurrencyRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransactionReportInstructionBase input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input);

	public static class ValuationCurrencyRuleDefault extends ValuationCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstructionBase input) {
			output = valuationCurrencyRule.evaluate(input);
			
			return output;
		}
	}
}
