package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(UniqueProductIdentifierRule.UniqueProductIdentifierRuleDefault.class)
public abstract class UniqueProductIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected drr.standards.iosco.upi.reports.UniqueProductIdentifierRule uniqueProductIdentifierRule;

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

	public static class UniqueProductIdentifierRuleDefault extends UniqueProductIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					final String string = uniqueProductIdentifierRule.evaluate(item.get());
					return string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build());
				}).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
