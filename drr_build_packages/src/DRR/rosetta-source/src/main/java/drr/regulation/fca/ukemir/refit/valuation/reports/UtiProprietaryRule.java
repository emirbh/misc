package drr.regulation.fca.ukemir.refit.valuation.reports;

import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;
import drr.standards.iosco.uti.functions.GetUniqueTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UtiProprietaryRule.UtiProprietaryRuleDefault.class)
public abstract class UtiProprietaryRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueTransactionIdentifier getUniqueTransactionIdentifier;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;

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

	public static class UtiProprietaryRuleDefault extends UtiProprietaryRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			final SupervisoryBodyEnum supervisoryBodyEnum = SupervisoryBodyEnum.FCA;
			final MapperS<String> thenArg = MapperS.of(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum)), MapperS.of(input).<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<TradeIdentifier>map("getUniqueTradeIdentifier", valuationTradeInformation -> valuationTradeInformation.getUniqueTradeIdentifier()).get(), null));
			output = thenArg
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
