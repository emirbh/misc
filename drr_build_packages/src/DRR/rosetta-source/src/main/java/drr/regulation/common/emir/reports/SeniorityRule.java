package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.SeniorityEnum;
import javax.inject.Inject;


@ImplementedBy(SeniorityRule.SeniorityRuleDefault.class)
public abstract class SeniorityRule implements ReportFunction<TransactionReportInstruction, SeniorityEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
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
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = MapperS.of(seniorityRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
