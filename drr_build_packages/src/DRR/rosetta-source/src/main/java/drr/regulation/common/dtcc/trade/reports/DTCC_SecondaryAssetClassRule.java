package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_SecondaryAssetClassRule.DTCC_SecondaryAssetClassRuleDefault.class)
public abstract class DTCC_SecondaryAssetClassRule implements ReportFunction<TransactionReportInstruction, AssetClassEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AssetClassEnum evaluate(TransactionReportInstruction input) {
		AssetClassEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AssetClassEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_SecondaryAssetClassRuleDefault extends DTCC_SecondaryAssetClassRule {
		@Override
		protected AssetClassEnum doEvaluate(TransactionReportInstruction input) {
			AssetClassEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AssetClassEnum assignOutput(AssetClassEnum output, TransactionReportInstruction input) {
			final FieldWithMetaAssetClassEnum fieldWithMetaAssetClassEnum = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(distinctIgnoringPrecision(MapperS.of(productForEvent.evaluate(item.get())).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy()).<FieldWithMetaAssetClassEnum>mapC("getSecondaryAssetClass", productTaxonomy -> productTaxonomy.getSecondaryAssetClass())).get())).get();
			if (fieldWithMetaAssetClassEnum == null) {
				output = null;
			} else {
				output = fieldWithMetaAssetClassEnum.getValue();
			}
			
			return output;
		}
	}
}
