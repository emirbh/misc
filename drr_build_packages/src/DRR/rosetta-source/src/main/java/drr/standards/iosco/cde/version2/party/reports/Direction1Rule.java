package drr.standards.iosco.cde.version2.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.party.functions.Direction1;
import drr.standards.iso.Direction1Enum;
import javax.inject.Inject;


@ImplementedBy(Direction1Rule.Direction1RuleDefault.class)
public abstract class Direction1Rule implements ReportFunction<TransactionReportInstructionBase, Direction1Enum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Direction1 direction1;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Direction1Enum evaluate(TransactionReportInstructionBase input) {
		Direction1Enum output = doEvaluate(input);
		
		return output;
	}

	protected abstract Direction1Enum doEvaluate(TransactionReportInstructionBase input);

	public static class Direction1RuleDefault extends Direction1Rule {
		@Override
		protected Direction1Enum doEvaluate(TransactionReportInstructionBase input) {
			Direction1Enum output = null;
			return assignOutput(output, input);
		}
		
		protected Direction1Enum assignOutput(Direction1Enum output, TransactionReportInstructionBase input) {
			output = direction1.evaluate(input);
			
			return output;
		}
	}
}
