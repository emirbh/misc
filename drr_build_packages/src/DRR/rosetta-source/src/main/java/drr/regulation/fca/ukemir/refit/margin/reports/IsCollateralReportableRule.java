package drr.regulation.fca.ukemir.refit.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;


@ImplementedBy(IsCollateralReportableRule.IsCollateralReportableRuleDefault.class)
public abstract class IsCollateralReportableRule implements ReportFunction<CollateralReportInstruction, Boolean> {

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

	public static class IsCollateralReportableRuleDefault extends IsCollateralReportableRule {
		@Override
		protected Boolean doEvaluate(CollateralReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(true)).get();
			
			return output;
		}
	}
}
