package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.uti.functions.GetUniqueTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import drr.standards.iso.functions.IsValidLeiFromGlobalUti;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierRule.UniqueTransactionIdentifierRuleDefault.class)
public abstract class UniqueTransactionIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueTransactionIdentifier getUniqueTransactionIdentifier;
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

	public static class UniqueTransactionIdentifierRuleDefault extends UniqueTransactionIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final SupervisoryBodyEnum supervisoryBodyEnum = SupervisoryBodyEnum.HKMA;
			final MapperS<String> thenArg0 = MapperS.of(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum)), null, input));
			final MapperS<String> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get());
			output = thenArg1
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isValidLeiFromGlobalUti.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
