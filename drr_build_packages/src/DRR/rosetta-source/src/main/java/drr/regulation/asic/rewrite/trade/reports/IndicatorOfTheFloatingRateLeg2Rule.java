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
import drr.regulation.common.trade.underlier.reports.FloatingRateIndicatorRule;
import drr.standards.iso.IndexEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IndicatorOfTheFloatingRateLeg2Rule.IndicatorOfTheFloatingRateLeg2RuleDefault.class)
public abstract class IndicatorOfTheFloatingRateLeg2Rule implements ReportFunction<TransactionReportInstruction, IndexEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateIndicatorRule floatingRateIndicatorRule;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

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

	public static class IndicatorOfTheFloatingRateLeg2RuleDefault extends IndicatorOfTheFloatingRateLeg2Rule {
		@Override
		protected IndexEnum doEvaluate(TransactionReportInstruction input) {
			IndexEnum output = null;
			return assignOutput(output, input);
		}
		
		protected IndexEnum assignOutput(IndexEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.EQUI), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All)).get());
			final MapperS<InterestRatePayout> thenArg2 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg1.get())));
			output = thenArg2
				.mapSingleToItem(item -> MapperS.of(floatingRateIndicatorRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
