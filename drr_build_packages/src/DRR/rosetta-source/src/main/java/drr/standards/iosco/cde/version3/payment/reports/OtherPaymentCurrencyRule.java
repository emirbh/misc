package drr.standards.iosco.cde.version3.payment.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentCurrencyRule.OtherPaymentCurrencyRuleDefault.class)
public abstract class OtherPaymentCurrencyRule implements ReportFunction<TransferState, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.payment.reports.OtherPaymentCurrencyRule otherPaymentCurrencyRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransferState input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransferState input);

	public static class OtherPaymentCurrencyRuleDefault extends OtherPaymentCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransferState input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransferState input) {
			output = otherPaymentCurrencyRule.evaluate(input);
			
			return output;
		}
	}
}
