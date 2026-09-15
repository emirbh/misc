package drr.standards.iosco.cde.version3.execution.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iso.ClearedEnum;
import javax.inject.Inject;


@ImplementedBy(ClearedRule.ClearedRuleDefault.class)
public abstract class ClearedRule implements ReportFunction<TransactionReportInstructionBase, ClearedEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.execution.reports.ClearedRule clearedRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ClearedEnum evaluate(TransactionReportInstructionBase input) {
		ClearedEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ClearedEnum doEvaluate(TransactionReportInstructionBase input);

	public static class ClearedRuleDefault extends ClearedRule {
		@Override
		protected ClearedEnum doEvaluate(TransactionReportInstructionBase input) {
			ClearedEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ClearedEnum assignOutput(ClearedEnum output, TransactionReportInstructionBase input) {
			output = clearedRule.evaluate(input);
			
			return output;
		}
	}
}
