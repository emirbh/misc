package drr.standards.iosco.cde.version3.execution.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iso.ConfirmationEnum;
import javax.inject.Inject;


@ImplementedBy(ConfirmedRule.ConfirmedRuleDefault.class)
public abstract class ConfirmedRule implements ReportFunction<TransactionReportInstructionBase, ConfirmationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.execution.reports.ConfirmedRule confirmedRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ConfirmationEnum evaluate(TransactionReportInstructionBase input) {
		ConfirmationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ConfirmationEnum doEvaluate(TransactionReportInstructionBase input);

	public static class ConfirmedRuleDefault extends ConfirmedRule {
		@Override
		protected ConfirmationEnum doEvaluate(TransactionReportInstructionBase input) {
			ConfirmationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ConfirmationEnum assignOutput(ConfirmationEnum output, TransactionReportInstructionBase input) {
			output = confirmedRule.evaluate(input);
			
			return output;
		}
	}
}
