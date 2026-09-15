package drr.regulation.common.valuation.execution.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.LastFloatingReference;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;


@ImplementedBy(LastFloatingReferenceResetDateLeg1Rule.LastFloatingReferenceResetDateLeg1RuleDefault.class)
public abstract class LastFloatingReferenceResetDateLeg1Rule implements ReportFunction<ValuationReportInstruction, Date> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(ValuationReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(ValuationReportInstruction input);

	public static class LastFloatingReferenceResetDateLeg1RuleDefault extends LastFloatingReferenceResetDateLeg1Rule {
		@Override
		protected Date doEvaluate(ValuationReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<LastFloatingReference>map("getLastFloatingReference", valuationTradeInformation -> valuationTradeInformation.getLastFloatingReference()).<Date>map("getLastFloatingReferenceResetDateLeg1", lastFloatingReference -> lastFloatingReference.getLastFloatingReferenceResetDateLeg1())).get();
			
			return output;
		}
	}
}
