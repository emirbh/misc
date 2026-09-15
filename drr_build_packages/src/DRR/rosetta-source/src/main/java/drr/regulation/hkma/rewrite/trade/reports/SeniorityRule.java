package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iso.SeniorityEnum;
import javax.inject.Inject;


@ImplementedBy(SeniorityRule.SeniorityRuleDefault.class)
public abstract class SeniorityRule implements ReportFunction<TransactionReportInstruction, SeniorityEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected drr.regulation.common.trade.index.reports.SeniorityRule seniorityRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SeniorityEnum evaluate(TransactionReportInstruction input) {
		SeniorityEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract SeniorityEnum doEvaluate(TransactionReportInstruction input);

	public static class SeniorityRuleDefault extends SeniorityRule {
		@Override
		protected SeniorityEnum doEvaluate(TransactionReportInstruction input) {
			SeniorityEnum output = null;
			return assignOutput(output, input);
		}
		
		protected SeniorityEnum assignOutput(SeniorityEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(seniorityRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
