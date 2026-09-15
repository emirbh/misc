package drr.regulation.common.emir.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.AdjustFrequencyPeriod;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.payment.reports.FloatingRateResetFrequencyPeriodMultiplierRule;
import drr.regulation.common.trade.payment.reports.FloatingRateResetFrequencyPeriodRule;
import javax.inject.Inject;


@ImplementedBy(FloatingRateResetFrequencyMultiplierOfLeg2Rule.FloatingRateResetFrequencyMultiplierOfLeg2RuleDefault.class)
public abstract class FloatingRateResetFrequencyMultiplierOfLeg2Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierRule floatingRateResetFrequencyPeriodMultiplierRule;
	@Inject protected FloatingRateResetFrequencyPeriodRule floatingRateResetFrequencyPeriodRule;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

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

	public static class FloatingRateResetFrequencyMultiplierOfLeg2RuleDefault extends FloatingRateResetFrequencyMultiplierOfLeg2Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())));
			output = MapperS.of(adjustFrequencyPeriod.evaluate(floatingRateResetFrequencyPeriodRule.evaluate(thenArg1.get()), floatingRateResetFrequencyPeriodMultiplierRule.evaluate(thenArg1.get()))).<Integer>map("getPeriodMultiplier", quantityFrequency -> quantityFrequency.getPeriodMultiplier()).get();
			
			return output;
		}
	}
}
