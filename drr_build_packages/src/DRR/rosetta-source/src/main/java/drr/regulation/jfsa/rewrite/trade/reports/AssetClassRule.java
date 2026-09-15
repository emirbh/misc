package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import javax.inject.Inject;


@ImplementedBy(AssetClassRule.AssetClassRuleDefault.class)
public abstract class AssetClassRule implements ReportFunction<TransactionReportInstruction, CommonAssetClass> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.contract.reports.AssetClassRule assetClassRule;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CommonAssetClass evaluate(TransactionReportInstruction input) {
		CommonAssetClass output = doEvaluate(input);
		
		return output;
	}

	protected abstract CommonAssetClass doEvaluate(TransactionReportInstruction input);

	public static class AssetClassRuleDefault extends AssetClassRule {
		@Override
		protected CommonAssetClass doEvaluate(TransactionReportInstruction input) {
			CommonAssetClass output = null;
			return assignOutput(output, input);
		}
		
		protected CommonAssetClass assignOutput(CommonAssetClass output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(assetClassRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
