package drr.regulation.mas.rewrite.trade.reports;

import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iosco.cde.version3.price.reports.PriceRule;
import drr.standards.iosco.cde.version3.price.reports.PriceValueRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceUnitOfMeasureRule.PriceUnitOfMeasureRuleDefault.class)
public abstract class PriceUnitOfMeasureRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected PriceRule priceRule;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected PriceValueRule priceValueRule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class PriceUnitOfMeasureRuleDefault extends PriceUnitOfMeasureRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<String> ifThenElseResult;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(thenArg.get()))))).andNullSafe(exists(MapperS.of(priceValueRule.evaluate(thenArg.get())))).orNullSafe(areEqual(MapperS.of(priceRule.evaluate(thenArg.get())).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(priceRule.evaluate(thenArg.get())).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()), MapperS.of(PriceExpressionEnum.PERCENTAGE_OF_NOTIONAL), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(priceRule.evaluate(thenArg.get())).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()), MapperS.of(PriceExpressionEnum.ABSOLUTE_TERMS), CardinalityOperator.All)))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of("ACCY");
			} else {
				ifThenElseResult = MapperS.of(priceUnitOfMeasureRule.evaluate(thenArg.get()));
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
