package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractReferenceEntity;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import javax.inject.Inject;


@ImplementedBy(ReferenceEntityRule.ReferenceEntityRuleDefault.class)
public abstract class ReferenceEntityRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractReferenceEntity extractReferenceEntity;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;

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

	public static class ReferenceEntityRuleDefault extends ReferenceEntityRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> MapperS.of(extractReferenceEntity.evaluate(item.get())).<FieldWithMetaString>map("getIdentifier", entityIdentifier -> entityIdentifier.getIdentifier())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
