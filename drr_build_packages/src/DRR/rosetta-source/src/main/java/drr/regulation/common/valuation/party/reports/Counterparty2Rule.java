package drr.regulation.common.valuation.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iosco.cde.version1.party.functions.Counterparty2FromReportingSide;
import javax.inject.Inject;


@ImplementedBy(Counterparty2Rule.Counterparty2RuleDefault.class)
public abstract class Counterparty2Rule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty2FromReportingSide counterparty2FromReportingSide;

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

	public static class Counterparty2RuleDefault extends Counterparty2Rule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(counterparty2FromReportingSide.evaluate(item.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).get()))).get();
			
			return output;
		}
	}
}
