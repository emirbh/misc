package drr.standards.iosco.cde.version2.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(Counterparty2IdentifierTypeRule.Counterparty2IdentifierTypeRuleDefault.class)
public abstract class Counterparty2IdentifierTypeRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.party.reports.Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstructionBase input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstructionBase input);

	public static class Counterparty2IdentifierTypeRuleDefault extends Counterparty2IdentifierTypeRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = counterparty2IdentifierTypeRule.evaluate(input);
			
			return output;
		}
	}
}
