package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.QuantityFrequency;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityFrequencyMultiplierLeg1Rule.QuantityFrequencyMultiplierLeg1RuleDefault.class)
public abstract class QuantityFrequencyMultiplierLeg1Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
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

	public static class QuantityFrequencyMultiplierLeg1RuleDefault extends QuantityFrequencyMultiplierLeg1Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<Integer> ifThenElseResult;
			if (areEqual(MapperS.of(isSingleCommodityPayoutProduct.evaluate(productForEvent.evaluate(thenArg.get()))), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> MapperS.of(quantityFrequency.evaluate(payoutLeg1Rule.evaluate(item.get()))).<Integer>map("getPeriodMultiplier", _quantityFrequency -> _quantityFrequency.getPeriodMultiplier()));
			} else {
				ifThenElseResult = MapperS.<Integer>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
