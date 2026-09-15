package drr.regulation.mas.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.functions.ExtractPartyResponsibleForReportingIdentifier;
import javax.inject.Inject;


@ImplementedBy(ReportingSpecifiedPersonRule.ReportingSpecifiedPersonRuleDefault.class)
public abstract class ReportingSpecifiedPersonRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyResponsibleForReportingIdentifier extractPartyResponsibleForReportingIdentifier;

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

	public static class ReportingSpecifiedPersonRuleDefault extends ReportingSpecifiedPersonRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(extractPartyResponsibleForReportingIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).get()))).get();
			
			return output;
		}
	}
}
