package drr.standards.iosco.cde.version3.payment.reports;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentReceiverRule.OtherPaymentReceiverRuleDefault.class)
public abstract class OtherPaymentReceiverRule implements ReportFunction<TransferState, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.payment.reports.OtherPaymentReceiverRule otherPaymentReceiverRule;

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

	public static class OtherPaymentReceiverRuleDefault extends OtherPaymentReceiverRule {
		@Override
		protected String doEvaluate(TransferState input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransferState input) {
			output = otherPaymentReceiverRule.evaluate(input);
			
			return output;
		}
	}
}
