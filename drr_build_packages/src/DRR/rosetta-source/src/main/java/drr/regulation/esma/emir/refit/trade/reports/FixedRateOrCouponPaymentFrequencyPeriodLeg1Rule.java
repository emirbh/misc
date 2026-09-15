package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.reports.FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule;
import drr.regulation.common.functions.AdjustFrequencyPeriod;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(FixedRateOrCouponPaymentFrequencyPeriodLeg1Rule.FixedRateOrCouponPaymentFrequencyPeriodLeg1RuleDefault.class)
public abstract class FixedRateOrCouponPaymentFrequencyPeriodLeg1Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected drr.regulation.common.emir.reports.FixedRateOrCouponPaymentFrequencyPeriodLeg1Rule fixedRateOrCouponPaymentFrequencyPeriodLeg1Rule;
	@Inject protected FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule fixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FrequencyPeriodEnum evaluate(TransactionReportInstruction input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input);

	public static class FixedRateOrCouponPaymentFrequencyPeriodLeg1RuleDefault extends FixedRateOrCouponPaymentFrequencyPeriodLeg1Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			output = MapperS.of(adjustFrequencyPeriod.evaluate(fixedRateOrCouponPaymentFrequencyPeriodLeg1Rule.evaluate(input), fixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule.evaluate(input))).<FrequencyPeriodEnum>map("getPeriod", quantityFrequency -> quantityFrequency.getPeriod()).get();
			
			return output;
		}
	}
}
