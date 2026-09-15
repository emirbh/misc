package drr.regulation.cftc.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iosco.uti.functions.UniqueSwapIdentifierForValuation;
import java.util.Collections;
import javax.inject.Inject;


@ImplementedBy(UniqueSwapIdentifierRule.UniqueSwapIdentifierRuleDefault.class)
public abstract class UniqueSwapIdentifierRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected UniqueSwapIdentifierForValuation uniqueSwapIdentifierForValuation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class UniqueSwapIdentifierRuleDefault extends UniqueSwapIdentifierRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			final SupervisoryBodyEnum supervisoryBodyEnum = SupervisoryBodyEnum.CFTC;
			output = uniqueSwapIdentifierForValuation.evaluate(input, (supervisoryBodyEnum == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum)));
			
			return output;
		}
	}
}
