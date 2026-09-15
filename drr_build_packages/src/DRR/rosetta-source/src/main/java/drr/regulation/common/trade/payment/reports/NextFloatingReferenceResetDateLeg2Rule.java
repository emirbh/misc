package drr.regulation.common.trade.payment.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NextFloatingReferenceResetDateLeg2Rule.NextFloatingReferenceResetDateLeg2RuleDefault.class)
public abstract class NextFloatingReferenceResetDateLeg2Rule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected IsFRA isFRA;
	@Inject protected NextFloatingReferenceResetDateRule nextFloatingReferenceResetDateRule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class NextFloatingReferenceResetDateLeg2RuleDefault extends NextFloatingReferenceResetDateLeg2Rule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isFRA.evaluate(productForEvent.evaluate(item.get()))), MapperS.of(false), CardinalityOperator.All).get());
			final MapperS<InterestRatePayout> thenArg1 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())));
			output = MapperS.of(nextFloatingReferenceResetDateRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
