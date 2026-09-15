package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(UnderlyingIdentificationRule.UnderlyingIdentificationRuleDefault.class)
public abstract class UnderlyingIdentificationRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected drr.regulation.common.trade.underlier.reports.UnderlyingIdentificationRule underlyingIdentificationRule;

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

	public static class UnderlyingIdentificationRuleDefault extends UnderlyingIdentificationRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final String string = underlyingIdentificationRule.evaluate(thenArg.get());
			final FieldWithMetaString fieldWithMetaString = (string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
