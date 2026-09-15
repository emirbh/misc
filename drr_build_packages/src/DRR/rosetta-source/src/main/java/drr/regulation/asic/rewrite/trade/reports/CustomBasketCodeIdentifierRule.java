package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.basket.reports.CustomBasketCodeRule;
import javax.inject.Inject;


@ImplementedBy(CustomBasketCodeIdentifierRule.CustomBasketCodeIdentifierRuleDefault.class)
public abstract class CustomBasketCodeIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CustomBasketCodeRule customBasketCodeRule;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class CustomBasketCodeIdentifierRuleDefault extends CustomBasketCodeIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = MapperS.of(customBasketCodeRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
