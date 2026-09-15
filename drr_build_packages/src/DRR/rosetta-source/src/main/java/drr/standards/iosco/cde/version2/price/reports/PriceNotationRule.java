package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.price.PriceNotationEnum;
import javax.inject.Inject;


@ImplementedBy(PriceNotationRule.PriceNotationRuleDefault.class)
public abstract class PriceNotationRule implements ReportFunction<ReportableEventBase, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.price.reports.PriceNotationRule priceNotationRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(ReportableEventBase input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(ReportableEventBase input);

	public static class PriceNotationRuleDefault extends PriceNotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(ReportableEventBase input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, ReportableEventBase input) {
			output = priceNotationRule.evaluate(input);
			
			return output;
		}
	}
}
