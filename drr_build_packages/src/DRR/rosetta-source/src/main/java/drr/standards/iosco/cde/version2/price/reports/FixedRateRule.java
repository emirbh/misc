package drr.standards.iosco.cde.version2.price.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FixedRateRule.FixedRateRuleDefault.class)
public abstract class FixedRateRule implements ReportFunction<InterestRatePayout, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.price.reports.FixedRateRule fixedRateRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(InterestRatePayout input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(InterestRatePayout input);

	public static class FixedRateRuleDefault extends FixedRateRule {
		@Override
		protected BigDecimal doEvaluate(InterestRatePayout input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, InterestRatePayout input) {
			output = fixedRateRule.evaluate(input);
			
			return output;
		}
	}
}
