package drr.standards.iosco.cde.version3.datetime.reports;

import cdm.base.datetime.functions.Now;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ReportingTimestampRule.ReportingTimestampRuleDefault.class)
public abstract class ReportingTimestampRule implements ReportFunction<TransactionReportInstructionBase, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Now now;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(TransactionReportInstructionBase input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(TransactionReportInstructionBase input);

	public static class ReportingTimestampRuleDefault extends ReportingTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstructionBase input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstructionBase input) {
			output = now.evaluate();
			
			return output;
		}
	}
}
