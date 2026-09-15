package drr.standards.iosco.cde.version2.payment.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.InterestComputationMethod4Code;
import javax.inject.Inject;


@ImplementedBy(DayCountConventionRule.DayCountConventionRuleDefault.class)
public abstract class DayCountConventionRule implements ReportFunction<InterestRatePayout, InterestComputationMethod4Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.payment.reports.DayCountConventionRule dayCountConventionRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public InterestComputationMethod4Code evaluate(InterestRatePayout input) {
		InterestComputationMethod4Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract InterestComputationMethod4Code doEvaluate(InterestRatePayout input);

	public static class DayCountConventionRuleDefault extends DayCountConventionRule {
		@Override
		protected InterestComputationMethod4Code doEvaluate(InterestRatePayout input) {
			InterestComputationMethod4Code output = null;
			return assignOutput(output, input);
		}
		
		protected InterestComputationMethod4Code assignOutput(InterestComputationMethod4Code output, InterestRatePayout input) {
			output = dayCountConventionRule.evaluate(input);
			
			return output;
		}
	}
}
