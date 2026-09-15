package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.PayoutLeg1;
import drr.standards.iosco.cde.version3.payment.reports.DayCountConventionRule;
import drr.standards.iso.InterestComputationMethod4Code;
import javax.inject.Inject;


@ImplementedBy(FloatingRateDayCountConventionLeg1Rule.FloatingRateDayCountConventionLeg1RuleDefault.class)
public abstract class FloatingRateDayCountConventionLeg1Rule implements ReportFunction<TransactionReportInstruction, InterestComputationMethod4Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DayCountConventionRule dayCountConventionRule;
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected PayoutLeg1 payoutLeg1;

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

	public static class FloatingRateDayCountConventionLeg1RuleDefault extends FloatingRateDayCountConventionLeg1Rule {
		@Override
		protected InterestComputationMethod4Code doEvaluate(TransactionReportInstruction input) {
			InterestComputationMethod4Code output = null;
			return assignOutput(output, input);
		}
		
		protected InterestComputationMethod4Code assignOutput(InterestComputationMethod4Code output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg1.evaluate(thenArg0.get())));
			output = MapperS.of(dayCountConventionRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
