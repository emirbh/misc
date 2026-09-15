package drr.standards.iosco.cde.version3.payment.reports;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.PaymentType4Code;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentTypeRule.OtherPaymentTypeRuleDefault.class)
public abstract class OtherPaymentTypeRule implements ReportFunction<TransferState, PaymentType4Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.payment.reports.OtherPaymentTypeRule otherPaymentTypeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PaymentType4Code evaluate(TransferState input) {
		PaymentType4Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract PaymentType4Code doEvaluate(TransferState input);

	public static class OtherPaymentTypeRuleDefault extends OtherPaymentTypeRule {
		@Override
		protected PaymentType4Code doEvaluate(TransferState input) {
			PaymentType4Code output = null;
			return assignOutput(output, input);
		}
		
		protected PaymentType4Code assignOutput(PaymentType4Code output, TransferState input) {
			output = otherPaymentTypeRule.evaluate(input);
			
			return output;
		}
	}
}
