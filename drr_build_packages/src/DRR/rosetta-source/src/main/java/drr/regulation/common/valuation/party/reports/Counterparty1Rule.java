package drr.regulation.common.valuation.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iosco.cde.version1.party.functions.Counterparty1FromReportingSide;
import javax.inject.Inject;


@ImplementedBy(Counterparty1Rule.Counterparty1RuleDefault.class)
public abstract class Counterparty1Rule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty1FromReportingSide counterparty1FromReportingSide;

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

	public static class Counterparty1RuleDefault extends Counterparty1Rule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(counterparty1FromReportingSide.evaluate(item.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).get()))).get();
			
			return output;
		}
	}
}
