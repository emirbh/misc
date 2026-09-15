package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeMODI;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(PTRRIDRule.PTRRIDRuleDefault.class)
public abstract class PTRRIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected drr.regulation.common.trade.party.reports.PTRRIDRule pTRRIDRule;

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

	public static class PTRRIDRuleDefault extends PTRRIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeMODI.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeCORR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeREVI.evaluate(item.get())))).get());
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					final String string = pTRRIDRule.evaluate(item.get());
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
