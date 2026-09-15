package drr.regulation.common.emir.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.standards.iosco.cde.version3.payment.reports.DayCountConventionRule;
import drr.standards.iso.InterestComputationMethod4Code;
import javax.inject.Inject;


@ImplementedBy(FloatingRateDayCountConventionOfLeg2Rule.FloatingRateDayCountConventionOfLeg2RuleDefault.class)
public abstract class FloatingRateDayCountConventionOfLeg2Rule implements ReportFunction<TransactionReportInstruction, InterestComputationMethod4Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DayCountConventionRule dayCountConventionRule;
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

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

	public static class FloatingRateDayCountConventionOfLeg2RuleDefault extends FloatingRateDayCountConventionOfLeg2Rule {
		@Override
		protected InterestComputationMethod4Code doEvaluate(TransactionReportInstruction input) {
			InterestComputationMethod4Code output = null;
			return assignOutput(output, input);
		}
		
		protected InterestComputationMethod4Code assignOutput(InterestComputationMethod4Code output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())));
			output = thenArg1
				.mapSingleToItem(item -> MapperS.of(dayCountConventionRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
