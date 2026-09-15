package drr.regulation.mas.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iosco.cde.version3.payment.reports.PaymentFrequencyPeriodMultiplierRule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule.FloatingRatePaymentFrequencyPeriodMultiplierLeg1RuleDefault.class)
public abstract class FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected PaymentFrequencyPeriodMultiplierRule paymentFrequencyPeriodMultiplierRule;
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

	public static class FloatingRatePaymentFrequencyPeriodMultiplierLeg1RuleDefault extends FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg0.get())));
			output = MapperS.of(paymentFrequencyPeriodMultiplierRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
