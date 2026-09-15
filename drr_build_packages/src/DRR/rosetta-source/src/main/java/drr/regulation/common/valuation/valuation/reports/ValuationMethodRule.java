package drr.regulation.common.valuation.valuation.reports;

import cdm.event.common.Valuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iso.ValuationType1Code;
import javax.inject.Inject;


@ImplementedBy(ValuationMethodRule.ValuationMethodRuleDefault.class)
public abstract class ValuationMethodRule implements ReportFunction<ValuationReportInstruction, ValuationType1Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.valuation.reports.ValuationMethodRule valuationMethodRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ValuationType1Code evaluate(ValuationReportInstruction input) {
		ValuationType1Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract ValuationType1Code doEvaluate(ValuationReportInstruction input);

	public static class ValuationMethodRuleDefault extends ValuationMethodRule {
		@Override
		protected ValuationType1Code doEvaluate(ValuationReportInstruction input) {
			ValuationType1Code output = null;
			return assignOutput(output, input);
		}
		
		protected ValuationType1Code assignOutput(ValuationType1Code output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(valuationMethodRule.evaluate(item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<Valuation>map("getValuation", valuationDetails -> valuationDetails.getValuation()).get()))).get();
			
			return output;
		}
	}
}
