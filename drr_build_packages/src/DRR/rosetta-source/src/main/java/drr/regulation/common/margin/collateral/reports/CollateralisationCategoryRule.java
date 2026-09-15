package drr.regulation.common.margin.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iso.CollateralisationType3Code;


@ImplementedBy(CollateralisationCategoryRule.CollateralisationCategoryRuleDefault.class)
public abstract class CollateralisationCategoryRule implements ReportFunction<CollateralReportInstruction, CollateralisationType3Code> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CollateralisationType3Code evaluate(CollateralReportInstruction input) {
		CollateralisationType3Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract CollateralisationType3Code doEvaluate(CollateralReportInstruction input);

	public static class CollateralisationCategoryRuleDefault extends CollateralisationCategoryRule {
		@Override
		protected CollateralisationType3Code doEvaluate(CollateralReportInstruction input) {
			CollateralisationType3Code output = null;
			return assignOutput(output, input);
		}
		
		protected CollateralisationType3Code assignOutput(CollateralisationType3Code output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<CollateralisationType3Code>map("getCollateralisationCategory", collateralDetails -> collateralDetails.getCollateralisationCategory())).get();
			
			return output;
		}
	}
}
