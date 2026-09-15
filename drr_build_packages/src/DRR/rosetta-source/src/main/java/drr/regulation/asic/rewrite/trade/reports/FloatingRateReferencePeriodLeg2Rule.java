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
import drr.regulation.common.trade.underlier.reports.FloatingRateReferencePeriodRule;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FloatingRateReferencePeriodLeg2Rule.FloatingRateReferencePeriodLeg2RuleDefault.class)
public abstract class FloatingRateReferencePeriodLeg2Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected FloatingRateReferencePeriodRule floatingRateReferencePeriodRule;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FrequencyPeriodEnum evaluate(TransactionReportInstruction input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input);

	public static class FloatingRateReferencePeriodLeg2RuleDefault extends FloatingRateReferencePeriodLeg2Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.EQUI), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(item.get())), MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All)).get());
			final MapperS<InterestRatePayout> thenArg2 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg2Rule.evaluate(thenArg1.get())));
			output = MapperS.of(floatingRateReferencePeriodRule.evaluate(thenArg2.get())).get();
			
			return output;
		}
	}
}
