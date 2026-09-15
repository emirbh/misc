package drr.regulation.csa.rewrite.valuation.reports;

import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import drr.standards.iosco.uti.functions.GetUniqueTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericTextWithSpecialChars;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierRule.UniqueTransactionIdentifierRuleDefault.class)
public abstract class UniqueTransactionIdentifierRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueTransactionIdentifier getUniqueTransactionIdentifier;
	@Inject protected IsMax52UpperCaseAlphanumericTextWithSpecialChars isMax52UpperCaseAlphanumericTextWithSpecialChars;
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class UniqueTransactionIdentifierRuleDefault extends UniqueTransactionIdentifierRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			final MapperS<String> thenArg = MapperS.of(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).get(), supervisoryBodyForCSA.evaluate(), MapperS.of(input).<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<TradeIdentifier>map("getUniqueTradeIdentifier", valuationTradeInformation -> valuationTradeInformation.getUniqueTradeIdentifier()).get(), null));
			output = thenArg
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericTextWithSpecialChars.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
