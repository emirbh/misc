package drr.standards.iosco.cde.version1.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.NotationStringFromEnum;
import javax.inject.Inject;


@ImplementedBy(SpreadNotationRule.SpreadNotationRuleDefault.class)
public abstract class SpreadNotationRule implements ReportFunction<PayoutLegWithAuxiliary, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationStringFromEnum notationStringFromEnum;
	@Inject protected SpreadNotationEnumRule spreadNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(PayoutLegWithAuxiliary input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(PayoutLegWithAuxiliary input);

	public static class SpreadNotationRuleDefault extends SpreadNotationRule {
		@Override
		protected String doEvaluate(PayoutLegWithAuxiliary input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, PayoutLegWithAuxiliary input) {
			final MapperS<PriceNotationEnum> thenArg = MapperS.of(spreadNotationEnumRule.evaluate(input));
			output = MapperS.of(notationStringFromEnum.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
