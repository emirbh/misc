package drr.standards.iosco.cde.version2.quantity.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(CallCurrencyRule.CallCurrencyRuleDefault.class)
public abstract class CallCurrencyRule implements ReportFunction<TransactionReportInstructionBase, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.quantity.reports.CallCurrencyRule callCurrencyRule;

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

	public static class CallCurrencyRuleDefault extends CallCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstructionBase input) {
			output = callCurrencyRule.evaluate(input);
			
			return output;
		}
	}
}
