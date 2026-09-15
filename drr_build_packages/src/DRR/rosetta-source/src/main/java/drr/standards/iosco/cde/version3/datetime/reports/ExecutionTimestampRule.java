package drr.standards.iosco.cde.version3.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableEventBase;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ExecutionTimestampRule.ExecutionTimestampRuleDefault.class)
public abstract class ExecutionTimestampRule implements ReportFunction<ReportableEventBase, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.datetime.reports.ExecutionTimestampRule executionTimestampRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(ReportableEventBase input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(ReportableEventBase input);

	public static class ExecutionTimestampRuleDefault extends ExecutionTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(ReportableEventBase input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, ReportableEventBase input) {
			output = executionTimestampRule.evaluate(input);
			
			return output;
		}
	}
}
