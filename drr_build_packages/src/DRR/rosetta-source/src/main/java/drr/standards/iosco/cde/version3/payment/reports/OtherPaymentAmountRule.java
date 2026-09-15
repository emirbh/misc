package drr.standards.iosco.cde.version3.payment.reports;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentAmountRule.OtherPaymentAmountRuleDefault.class)
public abstract class OtherPaymentAmountRule implements ReportFunction<TransferState, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.payment.reports.OtherPaymentAmountRule otherPaymentAmountRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransferState input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransferState input);

	public static class OtherPaymentAmountRuleDefault extends OtherPaymentAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransferState input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransferState input) {
			output = otherPaymentAmountRule.evaluate(input);
			
			return output;
		}
	}
}
