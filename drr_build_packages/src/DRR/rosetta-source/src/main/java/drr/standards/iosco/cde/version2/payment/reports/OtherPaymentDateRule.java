package drr.standards.iosco.cde.version2.payment.reports;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentDateRule.OtherPaymentDateRuleDefault.class)
public abstract class OtherPaymentDateRule implements ReportFunction<TransferState, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.payment.reports.OtherPaymentDateRule otherPaymentDateRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransferState input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransferState input);

	public static class OtherPaymentDateRuleDefault extends OtherPaymentDateRule {
		@Override
		protected Date doEvaluate(TransferState input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransferState input) {
			output = otherPaymentDateRule.evaluate(input);
			
			return output;
		}
	}
}
