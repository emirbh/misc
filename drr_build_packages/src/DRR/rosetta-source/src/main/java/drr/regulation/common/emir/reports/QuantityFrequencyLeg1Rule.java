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
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityFrequencyLeg1Rule.QuantityFrequencyLeg1RuleDefault.class)
public abstract class QuantityFrequencyLeg1Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
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
	public FrequencyPeriodEnum evaluate(TransactionReportInstruction input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input);

	public static class QuantityFrequencyLeg1RuleDefault extends QuantityFrequencyLeg1Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<FrequencyPeriodEnum> ifThenElseResult;
			if (areEqual(MapperS.of(isSingleCommodityPayoutProduct.evaluate(productForEvent.evaluate(thenArg.get()))), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> MapperS.of(quantityFrequency.evaluate(payoutLeg1Rule.evaluate(item.get()))).<FrequencyPeriodEnum>map("getPeriod", _quantityFrequency -> _quantityFrequency.getPeriod()));
			} else {
				ifThenElseResult = MapperS.<FrequencyPeriodEnum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
