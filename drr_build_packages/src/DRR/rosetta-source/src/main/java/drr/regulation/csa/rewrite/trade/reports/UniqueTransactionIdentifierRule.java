package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import drr.standards.iosco.uti.functions.GetUniqueTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericTextWithSpecialChars;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierRule.UniqueTransactionIdentifierRuleDefault.class)
public abstract class UniqueTransactionIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueTransactionIdentifier getUniqueTransactionIdentifier;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsMax52UpperCaseAlphanumericTextWithSpecialChars isMax52UpperCaseAlphanumericTextWithSpecialChars;
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

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

	public static class UniqueTransactionIdentifierRuleDefault extends UniqueTransactionIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<String> thenArg1 = MapperS.of(getUniqueTransactionIdentifier.evaluate(thenArg0.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), supervisoryBodyForCSA.evaluate(), null, thenArg0.get()));
			output = thenArg1
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericTextWithSpecialChars.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
