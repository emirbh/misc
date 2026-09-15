package drr.regulation.common.valuation.valuation.reports;

import cdm.event.common.Valuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iosco.cde.version1.valuation.functions.ValuationAmountFromValuation;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ValuationAmountRule.ValuationAmountRuleDefault.class)
public abstract class ValuationAmountRule implements ReportFunction<ValuationReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ValuationAmountFromValuation valuationAmountFromValuation;

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

	public static class ValuationAmountRuleDefault extends ValuationAmountRule {
		@Override
		protected BigDecimal doEvaluate(ValuationReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(valuationAmountFromValuation.evaluate(item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<Valuation>map("getValuation", valuationDetails -> valuationDetails.getValuation()).get()))).get();
			
			return output;
		}
	}
}
