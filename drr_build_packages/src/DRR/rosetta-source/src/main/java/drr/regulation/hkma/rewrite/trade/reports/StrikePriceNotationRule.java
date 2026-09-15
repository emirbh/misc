package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsVarianceSwap;
import drr.base.qualification.product.functions.IsVolatilitySwap;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iosco.cde.version3.price.reports.StrikePriceNotationEnumRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(StrikePriceNotationRule.StrikePriceNotationRuleDefault.class)
public abstract class StrikePriceNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected StrikePriceNotationEnumRule strikePriceNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstruction input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstruction input);

	public static class StrikePriceNotationRuleDefault extends StrikePriceNotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = MapperS.of(defaultPercentageToDecimal.evaluate(strikePriceNotationEnumRule.evaluate(thenArg.get()), areEqual(MapperS.of(strikePriceNotationEnumRule.evaluate(thenArg.get())), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVarianceSwap.evaluate(productForEvent.evaluate(thenArg.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVolatilitySwap.evaluate(productForEvent.evaluate(thenArg.get())))))).get())).get();
			
			return output;
		}
	}
}
