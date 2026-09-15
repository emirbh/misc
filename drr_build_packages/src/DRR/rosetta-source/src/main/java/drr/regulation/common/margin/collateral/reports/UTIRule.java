package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;


@ImplementedBy(UTIRule.UTIRuleDefault.class)
public abstract class UTIRule implements ReportFunction<CollateralReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class UTIRuleDefault extends UTIRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			final FieldWithMetaString fieldWithMetaString = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(item.<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<TradeIdentifier>map("getUniqueTradeIdentifier", collateralDetails -> collateralDetails.getUniqueTradeIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).get())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
