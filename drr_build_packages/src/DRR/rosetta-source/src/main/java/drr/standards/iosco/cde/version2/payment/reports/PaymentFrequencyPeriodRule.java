package drr.standards.iosco.cde.version2.payment.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(PaymentFrequencyPeriodRule.PaymentFrequencyPeriodRuleDefault.class)
public abstract class PaymentFrequencyPeriodRule implements ReportFunction<InterestRatePayout, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.payment.reports.PaymentFrequencyPeriodRule paymentFrequencyPeriodRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FrequencyPeriodEnum evaluate(InterestRatePayout input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(InterestRatePayout input);

	public static class PaymentFrequencyPeriodRuleDefault extends PaymentFrequencyPeriodRule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(InterestRatePayout input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, InterestRatePayout input) {
			output = paymentFrequencyPeriodRule.evaluate(input);
			
			return output;
		}
	}
}
