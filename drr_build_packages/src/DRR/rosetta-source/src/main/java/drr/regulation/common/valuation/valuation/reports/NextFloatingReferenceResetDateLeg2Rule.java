package drr.regulation.common.valuation.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;


@ImplementedBy(NextFloatingReferenceResetDateLeg2Rule.NextFloatingReferenceResetDateLeg2RuleDefault.class)
public abstract class NextFloatingReferenceResetDateLeg2Rule implements ReportFunction<ValuationReportInstruction, Date> {

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

	public static class NextFloatingReferenceResetDateLeg2RuleDefault extends NextFloatingReferenceResetDateLeg2Rule {
		@Override
		protected Date doEvaluate(ValuationReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<Date>map("getNextFloatingReferenceResetDateLeg2", valuationTradeInformation -> valuationTradeInformation.getNextFloatingReferenceResetDateLeg2())).get();
			
			return output;
		}
	}
}
