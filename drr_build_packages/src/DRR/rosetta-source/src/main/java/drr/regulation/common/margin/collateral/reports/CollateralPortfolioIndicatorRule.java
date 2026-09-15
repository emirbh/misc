package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CollateralPortfolioIndicatorRule.CollateralPortfolioIndicatorRuleDefault.class)
public abstract class CollateralPortfolioIndicatorRule implements ReportFunction<CollateralReportInstruction, Boolean> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(CollateralReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(CollateralReportInstruction input);

	public static class CollateralPortfolioIndicatorRuleDefault extends CollateralPortfolioIndicatorRule {
		@Override
		protected Boolean doEvaluate(CollateralReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> exists(item.<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<Collateral>map("getCollateral", collateralDetails -> collateralDetails.getCollateral()).<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier())).asMapper()).get();
			
			return output;
		}
	}
}
