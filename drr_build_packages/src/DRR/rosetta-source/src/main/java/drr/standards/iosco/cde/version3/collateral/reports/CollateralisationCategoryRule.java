package drr.standards.iosco.cde.version3.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralReportInstructionBase;
import drr.standards.iso.CollateralisationType3Code;
import javax.inject.Inject;


@ImplementedBy(CollateralisationCategoryRule.CollateralisationCategoryRuleDefault.class)
public abstract class CollateralisationCategoryRule implements ReportFunction<CollateralReportInstructionBase, CollateralisationType3Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.collateral.reports.CollateralisationCategoryRule collateralisationCategoryRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CollateralisationType3Code evaluate(CollateralReportInstructionBase input) {
		CollateralisationType3Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract CollateralisationType3Code doEvaluate(CollateralReportInstructionBase input);

	public static class CollateralisationCategoryRuleDefault extends CollateralisationCategoryRule {
		@Override
		protected CollateralisationType3Code doEvaluate(CollateralReportInstructionBase input) {
			CollateralisationType3Code output = null;
			return assignOutput(output, input);
		}
		
		protected CollateralisationType3Code assignOutput(CollateralisationType3Code output, CollateralReportInstructionBase input) {
			output = collateralisationCategoryRule.evaluate(input);
			
			return output;
		}
	}
}
