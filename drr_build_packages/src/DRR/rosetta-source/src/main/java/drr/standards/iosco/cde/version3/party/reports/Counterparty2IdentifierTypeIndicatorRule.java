package drr.standards.iosco.cde.version3.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version2.party.reports.Counterparty2IdentifierTypeRule;
import javax.inject.Inject;


@ImplementedBy(Counterparty2IdentifierTypeIndicatorRule.Counterparty2IdentifierTypeIndicatorRuleDefault.class)
public abstract class Counterparty2IdentifierTypeIndicatorRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;

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

	public static class Counterparty2IdentifierTypeIndicatorRuleDefault extends Counterparty2IdentifierTypeIndicatorRule {
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
