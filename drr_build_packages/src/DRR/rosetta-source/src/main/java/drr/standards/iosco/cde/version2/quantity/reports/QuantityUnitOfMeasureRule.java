package drr.standards.iosco.cde.version2.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iosco.cde.version1.quantity.functions.QuantityUnitOfMeasure;
import javax.inject.Inject;


@ImplementedBy(QuantityUnitOfMeasureRule.QuantityUnitOfMeasureRuleDefault.class)
public abstract class QuantityUnitOfMeasureRule implements ReportFunction<PayoutLegWithAuxiliary, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityUnitOfMeasure quantityUnitOfMeasure;

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

	public static class QuantityUnitOfMeasureRuleDefault extends QuantityUnitOfMeasureRule {
		@Override
		protected String doEvaluate(PayoutLegWithAuxiliary input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, PayoutLegWithAuxiliary input) {
			output = quantityUnitOfMeasure.evaluate(input);
			
			return output;
		}
	}
}
