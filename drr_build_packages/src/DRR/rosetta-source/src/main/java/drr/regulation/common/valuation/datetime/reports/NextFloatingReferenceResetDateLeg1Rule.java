package drr.regulation.common.valuation.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;


@ImplementedBy(NextFloatingReferenceResetDateLeg1Rule.NextFloatingReferenceResetDateLeg1RuleDefault.class)
public abstract class NextFloatingReferenceResetDateLeg1Rule implements ReportFunction<ValuationReportInstruction, Date> {

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

	public static class NextFloatingReferenceResetDateLeg1RuleDefault extends NextFloatingReferenceResetDateLeg1Rule {
		@Override
		protected Date doEvaluate(ValuationReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<Date>map("getNextFloatingReferenceResetDateLeg1", valuationTradeInformation -> valuationTradeInformation.getNextFloatingReferenceResetDateLeg1())).get();
			
			return output;
		}
	}
}
