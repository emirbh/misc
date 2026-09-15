package drr.regulation.esma.emir.refit.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.functions.GetVenueOfExecution;
import javax.inject.Inject;


@ImplementedBy(MICCollateralRule.MICCollateralRuleDefault.class)
public abstract class MICCollateralRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetVenueOfExecution getVenueOfExecution;

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

	public static class MICCollateralRuleDefault extends MICCollateralRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = getVenueOfExecution.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get());
			
			return output;
		}
	}
}
