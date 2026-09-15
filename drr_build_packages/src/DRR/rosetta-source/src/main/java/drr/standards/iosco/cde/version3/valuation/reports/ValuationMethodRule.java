package drr.standards.iosco.cde.version3.valuation.reports;

import cdm.event.common.Valuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.ValuationType1Code;
import javax.inject.Inject;


@ImplementedBy(ValuationMethodRule.ValuationMethodRuleDefault.class)
public abstract class ValuationMethodRule implements ReportFunction<Valuation, ValuationType1Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.valuation.reports.ValuationMethodRule valuationMethodRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ValuationType1Code evaluate(Valuation input) {
		ValuationType1Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract ValuationType1Code doEvaluate(Valuation input);

	public static class ValuationMethodRuleDefault extends ValuationMethodRule {
		@Override
		protected ValuationType1Code doEvaluate(Valuation input) {
			ValuationType1Code output = null;
			return assignOutput(output, input);
		}
		
		protected ValuationType1Code assignOutput(ValuationType1Code output, Valuation input) {
			output = valuationMethodRule.evaluate(input);
			
			return output;
		}
	}
}
