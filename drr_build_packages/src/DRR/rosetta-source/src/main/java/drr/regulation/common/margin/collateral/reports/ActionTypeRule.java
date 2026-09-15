package drr.regulation.common.margin.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iso.MarginActionEnum;


@ImplementedBy(ActionTypeRule.ActionTypeRuleDefault.class)
public abstract class ActionTypeRule implements ReportFunction<CollateralReportInstruction, MarginActionEnum> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public MarginActionEnum evaluate(CollateralReportInstruction input) {
		MarginActionEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract MarginActionEnum doEvaluate(CollateralReportInstruction input);

	public static class ActionTypeRuleDefault extends ActionTypeRule {
		@Override
		protected MarginActionEnum doEvaluate(CollateralReportInstruction input) {
			MarginActionEnum output = null;
			return assignOutput(output, input);
		}
		
		protected MarginActionEnum assignOutput(MarginActionEnum output, CollateralReportInstruction input) {
			output = MapperS.of(input).<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<MarginActionEnum>map("getAction", collateralDetails -> collateralDetails.getAction()).get();
			
			return output;
		}
	}
}
