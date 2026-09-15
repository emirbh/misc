package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.payment.reports.FloatingRateResetFrequencyPeriodMultiplierRule;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.PayoutLeg2;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FloatingRateResetFrequencyMultiplierOfLeg2Rule.FloatingRateResetFrequencyMultiplierOfLeg2RuleDefault.class)
public abstract class FloatingRateResetFrequencyMultiplierOfLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierRule floatingRateResetFrequencyPeriodMultiplierRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected PayoutLeg2 payoutLeg2;

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

	public static class FloatingRateResetFrequencyMultiplierOfLeg2RuleDefault extends FloatingRateResetFrequencyMultiplierOfLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2.evaluate(item.get()))));
			output = MapperS.of(floatingRateResetFrequencyPeriodMultiplierRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
