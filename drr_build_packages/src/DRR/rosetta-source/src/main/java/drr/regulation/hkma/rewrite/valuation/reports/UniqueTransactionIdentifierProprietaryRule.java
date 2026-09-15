package drr.regulation.hkma.rewrite.valuation.reports;

import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.hkma.rewrite.valuation.functions.Extract_HKMATradeIdentifier;
import drr.regulation.hkma.rewrite.valuation.functions.Extract_UTIPropietary;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierProprietaryRule.UniqueTransactionIdentifierProprietaryRuleDefault.class)
public abstract class UniqueTransactionIdentifierProprietaryRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_HKMATradeIdentifier extract_HKMATradeIdentifier;
	@Inject protected Extract_UTIPropietary extract_UTIPropietary;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;

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

	public static class UniqueTransactionIdentifierProprietaryRuleDefault extends UniqueTransactionIdentifierProprietaryRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			final MapperS<TradeIdentifier> thenArg;
			if (notExists(MapperS.of(uniqueTransactionIdentifierRule.evaluate(input))).getOrDefault(false)) {
				thenArg = MapperS.of(extract_UTIPropietary.evaluate(input));
			} else {
				thenArg = MapperS.<TradeIdentifier>ofNull();
			}
			output = MapperS.of(extract_HKMATradeIdentifier.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
