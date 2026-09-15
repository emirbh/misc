package drr.standards.iosco.cde.version2.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ValuationTimestampRule.ValuationTimestampRuleDefault.class)
public abstract class ValuationTimestampRule implements ReportFunction<TransactionReportInstructionBase, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.datetime.reports.ValuationTimestampRule valuationTimestampRule;

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

	public static class ValuationTimestampRuleDefault extends ValuationTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstructionBase input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstructionBase input) {
			output = valuationTimestampRule.evaluate(input);
			
			return output;
		}
	}
}
