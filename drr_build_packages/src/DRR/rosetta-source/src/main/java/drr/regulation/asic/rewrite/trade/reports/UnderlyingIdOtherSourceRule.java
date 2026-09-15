package drr.regulation.asic.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractProductIdentifierBySource;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlierProductIdentifierOtherRule;
import javax.inject.Inject;


@ImplementedBy(UnderlyingIdOtherSourceRule.UnderlyingIdOtherSourceRuleDefault.class)
public abstract class UnderlyingIdOtherSourceRule implements ReportFunction<TransactionReportInstruction, AssetIdTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractProductIdentifierBySource extractProductIdentifierBySource;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected UnderlierProductIdentifierOtherRule underlierProductIdentifierOtherRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AssetIdTypeEnum evaluate(TransactionReportInstruction input) {
		AssetIdTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AssetIdTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingIdOtherSourceRuleDefault extends UnderlyingIdOtherSourceRule {
		@Override
		protected AssetIdTypeEnum doEvaluate(TransactionReportInstruction input) {
			AssetIdTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AssetIdTypeEnum assignOutput(AssetIdTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperC<AssetIdentifier> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<AssetIdentifier>of(underlierProductIdentifierOtherRule.evaluate(item.get())));
			final MapperS<AssetIdentifier> thenArg2 = MapperS.of(extractProductIdentifierBySource.evaluate(thenArg1.getMulti()));
			output = thenArg2.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()).get();
			
			return output;
		}
	}
}
