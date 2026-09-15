package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractReferenceEntity;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReferenceEntityRule.ReferenceEntityRuleDefault.class)
public abstract class ReferenceEntityRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractReferenceEntity extractReferenceEntity;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected UnderlyingIdentificationTypeRule underlyingIdentificationTypeRule;

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
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					if (notExists(MapperS.of(underlyingIdentificationTypeRule.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(extractReferenceEntity.evaluate(item.get())).<FieldWithMetaString>map("getIdentifier", entityIdentifier -> entityIdentifier.getIdentifier());
					}
					return MapperS.<FieldWithMetaString>ofNull();
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
