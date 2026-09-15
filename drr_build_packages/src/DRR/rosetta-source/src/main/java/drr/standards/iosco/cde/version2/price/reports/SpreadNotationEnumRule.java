package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.NotationFromPrice;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SpreadNotationEnumRule.SpreadNotationEnumRuleDefault.class)
public abstract class SpreadNotationEnumRule implements ReportFunction<PayoutLegWithAuxiliary, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationFromPrice notationFromPrice;
	@Inject protected SpreadRule spreadRule;
	@Inject protected SpreadValueRule spreadValueRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(PayoutLegWithAuxiliary input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(PayoutLegWithAuxiliary input);

	public static class SpreadNotationEnumRuleDefault extends SpreadNotationEnumRule {
		@Override
		protected PriceNotationEnum doEvaluate(PayoutLegWithAuxiliary input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, PayoutLegWithAuxiliary input) {
			if (exists(MapperS.of(spreadValueRule.evaluate(input))).getOrDefault(false)) {
				output = notationFromPrice.evaluate(spreadRule.evaluate(input));
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
