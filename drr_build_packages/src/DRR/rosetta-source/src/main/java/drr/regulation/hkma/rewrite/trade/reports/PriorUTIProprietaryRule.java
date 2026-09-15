package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.link.functions.GetPriorTransactionIdentifier;
import drr.regulation.common.trade.link.reports.PriorUSIRule;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import drr.standards.iso.functions.IsValidLeiFromGlobalUti;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriorUTIProprietaryRule.PriorUTIProprietaryRuleDefault.class)
public abstract class PriorUTIProprietaryRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetPriorTransactionIdentifier getPriorTransactionIdentifier;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;
	@Inject protected IsValidLeiFromGlobalUti isValidLeiFromGlobalUti;
	@Inject protected PriorUSIRule priorUSIRule;

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

	public static class PriorUTIProprietaryRuleDefault extends PriorUTIProprietaryRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			if (exists(MapperS.of(getPriorTransactionIdentifier.evaluate(input, RegimeNameEnum.HKMA))).getOrDefault(false)) {
				final MapperS<String> thenArg = MapperS.of(getPriorTransactionIdentifier.evaluate(input, RegimeNameEnum.HKMA));
				output = thenArg
					.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isValidLeiFromGlobalUti.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All)).get()).get();
			} else {
				output = priorUSIRule.evaluate(input);
			}
			
			return output;
		}
	}
}
