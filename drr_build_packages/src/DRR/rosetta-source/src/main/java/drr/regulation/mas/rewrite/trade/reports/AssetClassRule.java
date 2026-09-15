package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import javax.inject.Inject;


@ImplementedBy(AssetClassRule.AssetClassRuleDefault.class)
public abstract class AssetClassRule implements ReportFunction<TransactionReportInstruction, CommonAssetClass> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.contract.reports.AssetClassRule assetClassRule;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;

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
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForMAS.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeEROR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePRTO.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = MapperS.of(assetClassRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
