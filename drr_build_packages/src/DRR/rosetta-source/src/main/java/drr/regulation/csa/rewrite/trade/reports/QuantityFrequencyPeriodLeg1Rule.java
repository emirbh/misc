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
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityFrequencyPeriodLeg1Rule.QuantityFrequencyPeriodLeg1RuleDefault.class)
public abstract class QuantityFrequencyPeriodLeg1Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
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
	public FrequencyPeriodEnum evaluate(TransactionReportInstruction input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input);

	public static class QuantityFrequencyPeriodLeg1RuleDefault extends QuantityFrequencyPeriodLeg1Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<FrequencyPeriodEnum> ifThenElseResult;
			if (areEqual(MapperS.of(isSingleCommodityPayoutProduct.evaluate(productForEvent.evaluate(thenArg.get()))), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(quantityFrequency.evaluate(payoutLeg1.evaluate(thenArg.get()))).<FrequencyPeriodEnum>map("getPeriod", _quantityFrequency -> _quantityFrequency.getPeriod());
			} else {
				ifThenElseResult = MapperS.<FrequencyPeriodEnum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
