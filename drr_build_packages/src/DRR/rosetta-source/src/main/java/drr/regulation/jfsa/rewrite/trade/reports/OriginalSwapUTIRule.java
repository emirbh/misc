package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OriginalSwapUTIRule.OriginalSwapUTIRuleDefault.class)
public abstract class OriginalSwapUTIRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;
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
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperC<FieldWithMetaString> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<FieldWithMetaString>of(originalSwapUTIRule.evaluate(item.get()).stream()
					.<FieldWithMetaString>map(string -> FieldWithMetaString.builder().setValue(string).build())
					.collect(Collectors.toList())
				));
			final MapperC<FieldWithMetaString> thenArg2 = thenArg1
				.filterItemNullSafe(item -> {
					final FieldWithMetaString _fieldWithMetaString = item.get();
					return areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate((_fieldWithMetaString == null ? null : _fieldWithMetaString.getValue()))), MapperS.of(true), CardinalityOperator.All).get();
				});
			final FieldWithMetaString fieldWithMetaString = thenArg2
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
