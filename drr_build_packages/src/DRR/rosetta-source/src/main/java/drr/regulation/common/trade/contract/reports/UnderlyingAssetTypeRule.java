package drr.regulation.common.trade.contract.reports;

import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsUnderlyingAssetTypeFixedFixed;
import drr.regulation.common.functions.IsUnderlyingAssetTypeIndex;
import javax.inject.Inject;


@ImplementedBy(UnderlyingAssetTypeRule.UnderlyingAssetTypeRuleDefault.class)
public abstract class UnderlyingAssetTypeRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsUnderlyingAssetTypeFixedFixed isUnderlyingAssetTypeFixedFixed;
	@Inject protected IsUnderlyingAssetTypeIndex isUnderlyingAssetTypeIndex;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;

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

	public static class UnderlyingAssetTypeRuleDefault extends UnderlyingAssetTypeRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final Boolean boolean0 = isUnderlyingAssetTypeFixedFixed.evaluate(item.get());
					if ((boolean0 == null ? false : boolean0)) {
						return MapperS.of("Fixed_Fixed");
					}
					final Boolean boolean1 = qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())));
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of("Index_Tranche");
					}
					final Boolean boolean2 = isUnderlyingAssetTypeIndex.evaluate(item.get());
					if ((boolean2 == null ? false : boolean2)) {
						return MapperS.of("Index");
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
