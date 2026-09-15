package drr.regulation.sec.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.payment.reports.FloatingRateResetFrequencyPeriodMultiplierRule;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FloatingRateResetFrequencyPeriodMultiplierLeg1Rule.FloatingRateResetFrequencyPeriodMultiplierLeg1RuleDefault.class)
public abstract class FloatingRateResetFrequencyPeriodMultiplierLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierRule floatingRateResetFrequencyPeriodMultiplierRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class FloatingRateResetFrequencyPeriodMultiplierLeg1RuleDefault extends FloatingRateResetFrequencyPeriodMultiplierLeg1Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg0.get())));
			output = MapperS.of(floatingRateResetFrequencyPeriodMultiplierRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
