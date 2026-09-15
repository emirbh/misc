package drr.regulation.common.emir.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FixedInterestRatePayoutFromPayout;
import drr.standards.iosco.cde.version3.price.reports.FixedRateRule;
import drr.standards.iso.functions.FormatToBaseOneRate;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FixedRateOfLeg1OrCouponRule.FixedRateOfLeg1OrCouponRuleDefault.class)
public abstract class FixedRateOfLeg1OrCouponRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedInterestRatePayoutFromPayout fixedInterestRatePayoutFromPayout;
	@Inject protected FixedRateRule fixedRateRule;
	@Inject protected FormatToBaseOneRate formatToBaseOneRate;
	@Inject protected IsAllowableAction isAllowableAction;
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

	public static class FixedRateOfLeg1OrCouponRuleDefault extends FixedRateOfLeg1OrCouponRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(fixedInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg0.get())));
			final MapperS<BigDecimal> thenArg2 = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(fixedRateRule.evaluate(thenArg1.get())), MapperS.of(BigDecimal.valueOf(100)));
			output = MapperS.of(formatToBaseOneRate.evaluate(thenArg2.get())).get();
			
			return output;
		}
	}
}
