package drr.regulation.common.dtcc.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.OptionStyleRule;
import drr.standards.iso.OptionStyleEnum;
import javax.inject.Inject;


@ImplementedBy(DTCC_OptionStyleRule.DTCC_OptionStyleRuleDefault.class)
public abstract class DTCC_OptionStyleRule implements ReportFunction<TransactionReportInstruction, OptionStyleEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected OptionStyleRule optionStyleRule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public OptionStyleEnum evaluate(TransactionReportInstruction input) {
		OptionStyleEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract OptionStyleEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_OptionStyleRuleDefault extends DTCC_OptionStyleRule {
		@Override
		protected OptionStyleEnum doEvaluate(TransactionReportInstruction input) {
			OptionStyleEnum output = null;
			return assignOutput(output, input);
		}
		
		protected OptionStyleEnum assignOutput(OptionStyleEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(optionStyleRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
