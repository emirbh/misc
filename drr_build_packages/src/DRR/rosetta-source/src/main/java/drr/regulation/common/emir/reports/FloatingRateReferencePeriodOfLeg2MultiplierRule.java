package drr.regulation.common.emir.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.underlier.reports.FloatingRateReferencePeriodMultiplierRule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FloatingRateReferencePeriodOfLeg2MultiplierRule.FloatingRateReferencePeriodOfLeg2MultiplierRuleDefault.class)
public abstract class FloatingRateReferencePeriodOfLeg2MultiplierRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateReferencePeriodMultiplierRule floatingRateReferencePeriodMultiplierRule;
	@Inject protected IsAllowableAction isAllowableAction;
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

	public static class FloatingRateReferencePeriodOfLeg2MultiplierRuleDefault extends FloatingRateReferencePeriodOfLeg2MultiplierRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())));
			output = MapperS.of(floatingRateReferencePeriodMultiplierRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
