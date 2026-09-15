package drr.regulation.common.valuation.execution.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.LastFloatingReference;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;
import java.math.BigDecimal;


@ImplementedBy(LastFloatingReferenceValueLeg2Rule.LastFloatingReferenceValueLeg2RuleDefault.class)
public abstract class LastFloatingReferenceValueLeg2Rule implements ReportFunction<ValuationReportInstruction, BigDecimal> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(ValuationReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(ValuationReportInstruction input);

	public static class LastFloatingReferenceValueLeg2RuleDefault extends LastFloatingReferenceValueLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(ValuationReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<LastFloatingReference>map("getLastFloatingReference", valuationTradeInformation -> valuationTradeInformation.getLastFloatingReference()).<BigDecimal>map("getLastFloatingReferenceValueLeg2", lastFloatingReference -> lastFloatingReference.getLastFloatingReferenceValueLeg2())).get();
			
			return output;
		}
	}
}
