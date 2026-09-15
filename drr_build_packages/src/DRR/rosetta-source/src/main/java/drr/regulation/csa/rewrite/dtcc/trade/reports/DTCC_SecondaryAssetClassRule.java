package drr.regulation.csa.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(DTCC_SecondaryAssetClassRule.DTCC_SecondaryAssetClassRuleDefault.class)
public abstract class DTCC_SecondaryAssetClassRule implements ReportFunction<TransactionReportInstruction, AssetClassEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_SecondaryAssetClassRule dTCC_SecondaryAssetClassRule;

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
				.mapSingleToItem(item -> {
					final AssetClassEnum assetClassEnum = dTCC_SecondaryAssetClassRule.evaluate(item.get());
					return assetClassEnum == null ? MapperS.<FieldWithMetaAssetClassEnum>ofNull() : MapperS.of(FieldWithMetaAssetClassEnum.builder().setValue(assetClassEnum).build());
				}).get();
			if (fieldWithMetaAssetClassEnum == null) {
				output = null;
			} else {
				output = fieldWithMetaAssetClassEnum.getValue();
			}
			
			return output;
		}
	}
}
