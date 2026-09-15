package drr.standards.iosco.cde.version1.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.NotationFromPrice;
import drr.standards.iosco.cde.version1.price.functions.Price;
import javax.inject.Inject;


@ImplementedBy(PriceNotationRule.PriceNotationRuleDefault.class)
public abstract class PriceNotationRule implements ReportFunction<ReportableEventBase, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationFromPrice notationFromPrice;
	@Inject protected Price price;

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
			output = notationFromPrice.evaluate(price.evaluate(input));
			
			return output;
		}
	}
}
