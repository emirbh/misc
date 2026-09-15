package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ExecutionTimestampRule.ExecutionTimestampRuleDefault.class)
public abstract class ExecutionTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.datetime.reports.ExecutionTimestampRule executionTimestampRule;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;

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
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForHKMA.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = MapperS.of(executionTimestampRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
