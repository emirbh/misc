package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.reports.FixedRateOrCouponPaymentFrequencyPeriodLeg1Rule;
import drr.regulation.common.functions.AdjustFrequencyPeriod;
import javax.inject.Inject;


@ImplementedBy(FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule.FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1RuleDefault.class)
public abstract class FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected FixedRateOrCouponPaymentFrequencyPeriodLeg1Rule fixedRateOrCouponPaymentFrequencyPeriodLeg1Rule;
	@Inject protected drr.regulation.common.emir.reports.FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule fixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Integer evaluate(TransactionReportInstruction input) {
		Integer output = doEvaluate(input);
		
		return output;
	}

	protected abstract Integer doEvaluate(TransactionReportInstruction input);

	public static class FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1RuleDefault extends FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			output = MapperS.of(adjustFrequencyPeriod.evaluate(fixedRateOrCouponPaymentFrequencyPeriodLeg1Rule.evaluate(input), fixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule.evaluate(input))).<Integer>map("getPeriodMultiplier", quantityFrequency -> quantityFrequency.getPeriodMultiplier()).get();
			
			return output;
		}
	}
}
