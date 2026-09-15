package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(PriceUnitOfMeasureRule.PriceUnitOfMeasureRuleDefault.class)
public abstract class PriceUnitOfMeasureRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;

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
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())))))).get());
			output = thenArg1
				.mapSingleToItem(item -> MapperS.of(MapperS.of(priceUnitOfMeasureRule.evaluate(item.get())).getOrDefault("OTHR"))).get();
			
			return output;
		}
	}
}
