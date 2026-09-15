package drr.regulation.asic.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.price.functions.IsDefaultPrice;
import drr.standards.iosco.cde.version3.price.reports.PriceNotationRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceCurrencyRule.PriceCurrencyRuleDefault.class)
public abstract class PriceCurrencyRule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected IsDefaultPrice isDefaultPrice;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.PriceCurrencyRule priceCurrencyRule;
	@Inject protected PriceNotationRule priceNotationRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransactionReportInstruction input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input);

	public static class PriceCurrencyRuleDefault extends PriceCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isDefaultPrice.evaluate(item.get()))).orNullSafe(areEqual(MapperS.of(priceNotationRule.evaluate(item.get())), MapperS.of(PriceNotationEnum.PERCENTAGE), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.<ISOCurrencyCodeEnum>ofNull();
					}
					return MapperS.of(priceCurrencyRule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
