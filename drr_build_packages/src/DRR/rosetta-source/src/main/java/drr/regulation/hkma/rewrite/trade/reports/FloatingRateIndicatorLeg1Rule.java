package drr.regulation.hkma.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.underlier.reports.FloatingRateIndicatorRule;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iso.IndexEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FloatingRateIndicatorLeg1Rule.FloatingRateIndicatorLeg1RuleDefault.class)
public abstract class FloatingRateIndicatorLeg1Rule implements ReportFunction<TransactionReportInstruction, IndexEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateIndicatorRule floatingRateIndicatorRule;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected IsFRA isFRA;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public IndexEnum evaluate(TransactionReportInstruction input) {
		IndexEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract IndexEnum doEvaluate(TransactionReportInstruction input);

	public static class FloatingRateIndicatorLeg1RuleDefault extends FloatingRateIndicatorLeg1Rule {
		@Override
		protected IndexEnum doEvaluate(TransactionReportInstruction input) {
			IndexEnum output = null;
			return assignOutput(output, input);
		}
		
		protected IndexEnum assignOutput(IndexEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isFRA.evaluate(productForEvent.evaluate(item.get()))), MapperS.of(false), CardinalityOperator.All).get());
			final MapperS<InterestRatePayout> thenArg2 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg1.get())));
			output = MapperS.of(floatingRateIndicatorRule.evaluate(thenArg2.get())).get();
			
			return output;
		}
	}
}
