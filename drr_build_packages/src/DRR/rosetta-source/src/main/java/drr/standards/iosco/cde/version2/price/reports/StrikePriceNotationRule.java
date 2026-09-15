package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.functions.NotationStringFromEnum;
import javax.inject.Inject;


@ImplementedBy(StrikePriceNotationRule.StrikePriceNotationRuleDefault.class)
public abstract class StrikePriceNotationRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationStringFromEnum notationStringFromEnum;
	@Inject protected StrikePriceNotationEnumRule strikePriceNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class StrikePriceNotationRuleDefault extends StrikePriceNotationRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = notationStringFromEnum.evaluate(strikePriceNotationEnumRule.evaluate(input));
			
			return output;
		}
	}
}
