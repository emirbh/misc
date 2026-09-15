package drr.regulation.common.valuation.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.functions.ExtractPartyResponsibleForReportingIdentifier;
import javax.inject.Inject;


@ImplementedBy(EntityResponsibleForReportingRule.EntityResponsibleForReportingRuleDefault.class)
public abstract class EntityResponsibleForReportingRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyResponsibleForReportingIdentifier extractPartyResponsibleForReportingIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class EntityResponsibleForReportingRuleDefault extends EntityResponsibleForReportingRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(extractPartyResponsibleForReportingIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).get()))).get();
			
			return output;
		}
	}
}
