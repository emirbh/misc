package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(DTCC_PrimaryAssetClassRule.DTCC_PrimaryAssetClassRuleDefault.class)
public abstract class DTCC_PrimaryAssetClassRule implements ReportFunction<TransactionReportInstruction, AssetClassEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_PrimaryAssetClassRule dTCC_PrimaryAssetClassRule;

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

	public static class DTCC_PrimaryAssetClassRuleDefault extends DTCC_PrimaryAssetClassRule {
		@Override
		protected AssetClassEnum doEvaluate(TransactionReportInstruction input) {
			AssetClassEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AssetClassEnum assignOutput(AssetClassEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(dTCC_PrimaryAssetClassRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
