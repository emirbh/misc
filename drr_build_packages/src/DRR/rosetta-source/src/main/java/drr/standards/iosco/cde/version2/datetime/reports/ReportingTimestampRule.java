package drr.standards.iosco.cde.version2.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(ReportingTimestampRule.ReportingTimestampRuleDefault.class)
public abstract class ReportingTimestampRule implements ReportFunction<TransactionReportInstructionBase, Void> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampRule reportingTimestampRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Void evaluate(TransactionReportInstructionBase input) {
		Void output = doEvaluate(input);
		
		return output;
	}

	protected abstract Void doEvaluate(TransactionReportInstructionBase input);

	public static class ReportingTimestampRuleDefault extends ReportingTimestampRule {
		@Override
		protected Void doEvaluate(TransactionReportInstructionBase input) {
			Void output = null;
			return assignOutput(output, input);
		}
		
		protected Void assignOutput(Void output, TransactionReportInstructionBase input) {
			output = null;
			
			return output;
		}
	}
}
