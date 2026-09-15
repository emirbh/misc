package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.link.reports.ClearingSwapUSIIDRule;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(ClearingSwapUSIsRule.ClearingSwapUSIsRuleDefault.class)
public abstract class ClearingSwapUSIsRule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ClearingSwapUSIIDRule clearingSwapUSIIDRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<String> evaluate(TransactionReportInstruction input) {
		List<String> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction input);

	public static class ClearingSwapUSIsRuleDefault extends ClearingSwapUSIsRule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(item -> MapperC.<FieldWithMetaString>of(clearingSwapUSIIDRule.evaluate(item.get()).stream()
					.<FieldWithMetaString>map(string -> FieldWithMetaString.builder().setValue(string).build())
					.collect(Collectors.toList())
				)).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti();
			
			return output;
		}
	}
}
