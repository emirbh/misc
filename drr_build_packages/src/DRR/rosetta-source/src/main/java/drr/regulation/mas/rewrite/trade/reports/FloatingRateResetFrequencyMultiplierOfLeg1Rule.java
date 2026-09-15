package drr.regulation.mas.rewrite.trade.reports;

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
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import javax.inject.Inject;


@ImplementedBy(FloatingRateResetFrequencyMultiplierOfLeg1Rule.FloatingRateResetFrequencyMultiplierOfLeg1RuleDefault.class)
public abstract class FloatingRateResetFrequencyMultiplierOfLeg1Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustFrequencyPeriod adjustFrequencyPeriod;
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierRule floatingRateResetFrequencyPeriodMultiplierRule;
	@Inject protected FloatingRateResetFrequencyPeriodRule floatingRateResetFrequencyPeriodRule;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;

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

	public static class FloatingRateResetFrequencyMultiplierOfLeg1RuleDefault extends FloatingRateResetFrequencyMultiplierOfLeg1Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg0.get())));
			output = MapperS.of(adjustFrequencyPeriod.evaluate(floatingRateResetFrequencyPeriodRule.evaluate(thenArg1.get()), floatingRateResetFrequencyPeriodMultiplierRule.evaluate(thenArg1.get()))).<Integer>map("getPeriodMultiplier", quantityFrequency -> quantityFrequency.getPeriodMultiplier()).get();
			
			return output;
		}
	}
}
