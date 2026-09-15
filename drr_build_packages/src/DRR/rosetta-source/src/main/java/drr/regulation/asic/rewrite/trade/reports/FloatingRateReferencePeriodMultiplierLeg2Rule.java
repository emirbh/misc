package drr.regulation.asic.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.AssetClassRule;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.common.trade.underlier.reports.FloatingRateReferencePeriodMultiplierRule;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FloatingRateReferencePeriodMultiplierLeg2Rule.FloatingRateReferencePeriodMultiplierLeg2RuleDefault.class)
public abstract class FloatingRateReferencePeriodMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateReferencePeriodMultiplierRule floatingRateReferencePeriodMultiplierRule;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
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

	public static class FloatingRateReferencePeriodMultiplierLeg2RuleDefault extends FloatingRateReferencePeriodMultiplierLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.EQUI), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All)).get());
			final MapperS<InterestRatePayout> thenArg2 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg1.get())));
			output = MapperS.of(floatingRateReferencePeriodMultiplierRule.evaluate(thenArg2.get())).get();
			
			return output;
		}
	}
}
