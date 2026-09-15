package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.cde.version3.price.reports.SpreadNotationEnumRule;
import javax.inject.Inject;


@ImplementedBy(SpreadNotationLeg2Rule.SpreadNotationLeg2RuleDefault.class)
public abstract class SpreadNotationLeg2Rule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected SpreadNotationEnumRule spreadNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstruction input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstruction input);

	public static class SpreadNotationLeg2RuleDefault extends SpreadNotationLeg2Rule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			output = defaultPercentageToDecimal.evaluate(spreadNotationEnumRule.evaluate(payoutLeg2Rule.evaluate(input)), false);
			
			return output;
		}
	}
}
