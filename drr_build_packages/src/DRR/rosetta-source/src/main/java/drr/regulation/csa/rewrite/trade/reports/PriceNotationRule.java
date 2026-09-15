package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(PriceNotationRule.PriceNotationRuleDefault.class)
public abstract class PriceNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.PriceNotationRule priceNotationRule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;

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

	public static class PriceNotationRuleDefault extends PriceNotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())))))).get());
			output = MapperS.of(defaultPercentageToDecimal.evaluate(priceNotationRule.evaluate(thenArg1.get()), false)).get();
			
			return output;
		}
	}
}
