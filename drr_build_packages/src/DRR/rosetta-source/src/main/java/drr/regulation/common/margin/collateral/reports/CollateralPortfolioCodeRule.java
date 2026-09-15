package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;


@ImplementedBy(CollateralPortfolioCodeRule.CollateralPortfolioCodeRuleDefault.class)
public abstract class CollateralPortfolioCodeRule implements ReportFunction<CollateralReportInstruction, String> {

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

	public static class CollateralPortfolioCodeRuleDefault extends CollateralPortfolioCodeRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			final MapperC<FieldWithMetaString> thenArg = MapperS.of(input)
				.mapSingleToList(item -> item.<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<Collateral>map("getCollateral", collateralDetails -> collateralDetails.getCollateral()).<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.last().get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
