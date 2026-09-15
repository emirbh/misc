package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.QuantityFrequency;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.PayoutLeg1;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityFrequencyPeriodMultiplierLeg1Rule.QuantityFrequencyPeriodMultiplierLeg1RuleDefault.class)
public abstract class QuantityFrequencyPeriodMultiplierLeg1Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected PayoutLeg1 payoutLeg1;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected QuantityFrequency quantityFrequency;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Integer evaluate(TransactionReportInstruction input) {
		Integer output = doEvaluate(input);
		
		return output;
	}

	protected abstract Integer doEvaluate(TransactionReportInstruction input);

	public static class QuantityFrequencyPeriodMultiplierLeg1RuleDefault extends QuantityFrequencyPeriodMultiplierLeg1Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<Integer> ifThenElseResult;
			if (areEqual(MapperS.of(isSingleCommodityPayoutProduct.evaluate(productForEvent.evaluate(thenArg.get()))), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(quantityFrequency.evaluate(payoutLeg1.evaluate(thenArg.get()))).<Integer>map("getPeriodMultiplier", _quantityFrequency -> _quantityFrequency.getPeriodMultiplier());
			} else {
				ifThenElseResult = MapperS.<Integer>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
