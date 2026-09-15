package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_BondConnect;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueProductIdentifierProprietaryRule.UniqueProductIdentifierProprietaryRuleDefault.class)
public abstract class UniqueProductIdentifierProprietaryRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_BondConnect extract_BondConnect;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;

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

	public static class UniqueProductIdentifierProprietaryRuleDefault extends UniqueProductIdentifierProprietaryRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final String string = uniqueProductIdentifierRule.evaluate(thenArg.get());
			final MapperS<String> ifThenElseResult;
			if ((string == null ? notExists(MapperS.<FieldWithMetaString>ofNull()) : notExists(MapperS.of(FieldWithMetaString.builder().setValue(string).build()))).andNullSafe(exists(MapperS.of(extract_BondConnect.evaluate(thenArg.get())))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of("ForeignExchange:Spot");
			} else {
				ifThenElseResult = MapperS.<String>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
