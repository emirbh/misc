package drr.regulation.common.valuation.execution.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.LastFloatingReference;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;


@ImplementedBy(LastFloatingReferenceResetDateLeg2Rule.LastFloatingReferenceResetDateLeg2RuleDefault.class)
public abstract class LastFloatingReferenceResetDateLeg2Rule implements ReportFunction<ValuationReportInstruction, Date> {

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

	public static class LastFloatingReferenceResetDateLeg2RuleDefault extends LastFloatingReferenceResetDateLeg2Rule {
		@Override
		protected Date doEvaluate(ValuationReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<LastFloatingReference>map("getLastFloatingReference", valuationTradeInformation -> valuationTradeInformation.getLastFloatingReference()).<Date>map("getLastFloatingReferenceResetDateLeg2", lastFloatingReference -> lastFloatingReference.getLastFloatingReferenceResetDateLeg2())).get();
			
			return output;
		}
	}
}
