package drr.regulation.jfsa.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FixedInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.payment.reports.PaymentFrequencyPeriodRule;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(FixedRatePaymentFrequencyPeriodLeg2Rule.FixedRatePaymentFrequencyPeriodLeg2RuleDefault.class)
public abstract class FixedRatePaymentFrequencyPeriodLeg2Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedInterestRatePayoutFromPayout fixedInterestRatePayoutFromPayout;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected PaymentFrequencyPeriodRule paymentFrequencyPeriodRule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

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

	public static class FixedRatePaymentFrequencyPeriodLeg2RuleDefault extends FixedRatePaymentFrequencyPeriodLeg2Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(fixedInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())));
			output = MapperS.of(paymentFrequencyPeriodRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
