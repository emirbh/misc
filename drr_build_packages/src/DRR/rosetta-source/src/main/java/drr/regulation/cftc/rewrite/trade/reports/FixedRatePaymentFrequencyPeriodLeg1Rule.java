package drr.regulation.cftc.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FixedInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version2.payment.reports.PaymentFrequencyPeriodRule;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(FixedRatePaymentFrequencyPeriodLeg1Rule.FixedRatePaymentFrequencyPeriodLeg1RuleDefault.class)
public abstract class FixedRatePaymentFrequencyPeriodLeg1Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedInterestRatePayoutFromPayout fixedInterestRatePayoutFromPayout;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PaymentFrequencyPeriodRule paymentFrequencyPeriodRule;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;

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

	public static class FixedRatePaymentFrequencyPeriodLeg1RuleDefault extends FixedRatePaymentFrequencyPeriodLeg1Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(fixedInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg0.get())));
			output = MapperS.of(paymentFrequencyPeriodRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
