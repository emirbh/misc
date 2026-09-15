package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(OriginalSwapUTIRule.OriginalSwapUTIRuleDefault.class)
public abstract class OriginalSwapUTIRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected drr.regulation.common.trade.link.reports.OriginalSwapUTIRule originalSwapUTIRule;

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

	public static class OriginalSwapUTIRuleDefault extends OriginalSwapUTIRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			final MapperC<FieldWithMetaString> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<FieldWithMetaString>of(originalSwapUTIRule.evaluate(item.get()).stream()
					.<FieldWithMetaString>map(string -> FieldWithMetaString.builder().setValue(string).build())
					.collect(Collectors.toList())
				));
			final FieldWithMetaString fieldWithMetaString = thenArg1
				.last().get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
