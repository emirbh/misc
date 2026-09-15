package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ExecutionTimestampRule.ExecutionTimestampRuleDefault.class)
public abstract class ExecutionTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.datetime.reports.ExecutionTimestampRule executionTimestampRule;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(TransactionReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(TransactionReportInstruction input);

	public static class ExecutionTimestampRuleDefault extends ExecutionTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = MapperS.of(executionTimestampRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
