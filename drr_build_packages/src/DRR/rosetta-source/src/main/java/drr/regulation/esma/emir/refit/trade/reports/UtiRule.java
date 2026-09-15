package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UtiRule.UtiRuleDefault.class)
public abstract class UtiRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EsmaUtiRule esmaUtiRule;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;

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

	public static class UtiRuleDefault extends UtiRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<String> thenArg = MapperS.of(esmaUtiRule.evaluate(input));
			output = thenArg
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
