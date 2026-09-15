package drr.regulation.hkma.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.functions.ExtractReportSubmittingPartyIdentifier;
import javax.inject.Inject;


@ImplementedBy(SubmitterIdentifierRule.SubmitterIdentifierRuleDefault.class)
public abstract class SubmitterIdentifierRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractReportSubmittingPartyIdentifier extractReportSubmittingPartyIdentifier;

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

	public static class SubmitterIdentifierRuleDefault extends SubmitterIdentifierRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(extractReportSubmittingPartyIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).get()))).get();
			
			return output;
		}
	}
}
