package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractCommodityClassification;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import javax.inject.Inject;


@ImplementedBy(BaseProductRule.BaseProductRuleDefault.class)
public abstract class BaseProductRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ExtractCommodityClassification extractCommodityClassification;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected ProductForEvent productForEvent;

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

	public static class BaseProductRuleDefault extends BaseProductRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(extractCommodityClassification.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())), TaxonomySourceEnum.EMIR, 1))).get();
			
			return output;
		}
	}
}
