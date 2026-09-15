package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.link.functions.GetPriorTransactionIdentifier;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import drr.standards.iso.functions.IsValidLeiFromGlobalUti;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriorUTIRule.PriorUTIRuleDefault.class)
public abstract class PriorUTIRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetPriorTransactionIdentifier getPriorTransactionIdentifier;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;
	@Inject protected IsValidLeiFromGlobalUti isValidLeiFromGlobalUti;

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

	public static class PriorUTIRuleDefault extends PriorUTIRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final MapperS<String> thenArg1 = MapperS.of(getPriorTransactionIdentifier.evaluate(thenArg0.get(), RegimeNameEnum.HKMA));
			final MapperS<String> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get());
			output = thenArg2
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isValidLeiFromGlobalUti.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
