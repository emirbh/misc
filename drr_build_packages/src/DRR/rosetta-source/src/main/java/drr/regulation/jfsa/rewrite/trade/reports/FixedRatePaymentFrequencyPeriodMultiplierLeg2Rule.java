package drr.regulation.jfsa.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FixedInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.payment.reports.PaymentFrequencyPeriodMultiplierRule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.FixedRatePaymentFrequencyPeriodMultiplierLeg2RuleDefault.class)
public abstract class FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedInterestRatePayoutFromPayout fixedInterestRatePayoutFromPayout;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected PaymentFrequencyPeriodMultiplierRule paymentFrequencyPeriodMultiplierRule;
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

	public static class FixedRatePaymentFrequencyPeriodMultiplierLeg2RuleDefault extends FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(fixedInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())));
			output = MapperS.of(paymentFrequencyPeriodMultiplierRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
