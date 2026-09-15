package drr.standards.iosco.cde.version3.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version2.party.reports.Beneficiary2IdentifierTypeRule;
import javax.inject.Inject;


@ImplementedBy(Beneficiary2IdentifierTypeIndicatorRule.Beneficiary2IdentifierTypeIndicatorRuleDefault.class)
public abstract class Beneficiary2IdentifierTypeIndicatorRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Beneficiary2IdentifierTypeRule beneficiary2IdentifierTypeRule;

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

	public static class Beneficiary2IdentifierTypeIndicatorRuleDefault extends Beneficiary2IdentifierTypeIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = beneficiary2IdentifierTypeRule.evaluate(input);
			
			return output;
		}
	}
}
