package drr.regulation.cftc.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.payment.reports.FloatingRateResetFrequencyPeriodMultiplierRule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FloatingRateResetFrequencyPeriodMultiplierLeg2Rule.FloatingRateResetFrequencyPeriodMultiplierLeg2RuleDefault.class)
public abstract class FloatingRateResetFrequencyPeriodMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierRule floatingRateResetFrequencyPeriodMultiplierRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

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

	public static class FloatingRateResetFrequencyPeriodMultiplierLeg2RuleDefault extends FloatingRateResetFrequencyPeriodMultiplierLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())));
			output = MapperS.of(floatingRateResetFrequencyPeriodMultiplierRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
