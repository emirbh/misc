package drr.regulation.common.emir.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FixedInterestRatePayoutFromPayout;
import drr.standards.iosco.cde.version3.payment.reports.DayCountConventionRule;
import drr.standards.iso.InterestComputationMethod4Code;
import javax.inject.Inject;


@ImplementedBy(FixedRateOrCouponDayCountConventionLeg1Rule.FixedRateOrCouponDayCountConventionLeg1RuleDefault.class)
public abstract class FixedRateOrCouponDayCountConventionLeg1Rule implements ReportFunction<TransactionReportInstruction, InterestComputationMethod4Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DayCountConventionRule dayCountConventionRule;
	@Inject protected FixedInterestRatePayoutFromPayout fixedInterestRatePayoutFromPayout;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public InterestComputationMethod4Code evaluate(TransactionReportInstruction input) {
		InterestComputationMethod4Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract InterestComputationMethod4Code doEvaluate(TransactionReportInstruction input);

	public static class FixedRateOrCouponDayCountConventionLeg1RuleDefault extends FixedRateOrCouponDayCountConventionLeg1Rule {
		@Override
		protected InterestComputationMethod4Code doEvaluate(TransactionReportInstruction input) {
			InterestComputationMethod4Code output = null;
			return assignOutput(output, input);
		}
		
		protected InterestComputationMethod4Code assignOutput(InterestComputationMethod4Code output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(fixedInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg0.get())));
			output = MapperS.of(dayCountConventionRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
