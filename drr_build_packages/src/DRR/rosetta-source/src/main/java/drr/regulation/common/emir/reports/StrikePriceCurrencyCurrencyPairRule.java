package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.price.reports.StrikePriceCurrencyRule;
import javax.inject.Inject;


@ImplementedBy(StrikePriceCurrencyCurrencyPairRule.StrikePriceCurrencyCurrencyPairRuleDefault.class)
public abstract class StrikePriceCurrencyCurrencyPairRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected StrikePriceCurrencyRule strikePriceCurrencyRule;

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

	public static class StrikePriceCurrencyCurrencyPairRuleDefault extends StrikePriceCurrencyCurrencyPairRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = MapperS.of(strikePriceCurrencyRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
