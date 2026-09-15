package drr.standards.iosco.cde.version3.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(UnderlierIDOtherSourceRule.UnderlierIDOtherSourceRuleDefault.class)
public abstract class UnderlierIDOtherSourceRule implements ReportFunction<TransactionReportInstructionBase, AssetIdTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected UnderlierProductIdentifierOtherRule underlierProductIdentifierOtherRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AssetIdTypeEnum evaluate(TransactionReportInstructionBase input) {
		AssetIdTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AssetIdTypeEnum doEvaluate(TransactionReportInstructionBase input);

	public static class UnderlierIDOtherSourceRuleDefault extends UnderlierIDOtherSourceRule {
		@Override
		protected AssetIdTypeEnum doEvaluate(TransactionReportInstructionBase input) {
			AssetIdTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AssetIdTypeEnum assignOutput(AssetIdTypeEnum output, TransactionReportInstructionBase input) {
			output = MapperC.<AssetIdentifier>of(underlierProductIdentifierOtherRule.evaluate(input)).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType())
				.first().get();
			
			return output;
		}
	}
}
