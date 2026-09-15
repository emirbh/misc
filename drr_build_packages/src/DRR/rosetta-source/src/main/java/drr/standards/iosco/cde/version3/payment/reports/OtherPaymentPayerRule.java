package drr.standards.iosco.cde.version3.payment.reports;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentPayerRule.OtherPaymentPayerRuleDefault.class)
public abstract class OtherPaymentPayerRule implements ReportFunction<TransferState, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.payment.reports.OtherPaymentPayerRule otherPaymentPayerRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransferState input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransferState input);

	public static class OtherPaymentPayerRuleDefault extends OtherPaymentPayerRule {
		@Override
		protected String doEvaluate(TransferState input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransferState input) {
			output = otherPaymentPayerRule.evaluate(input);
			
			return output;
		}
	}
}
