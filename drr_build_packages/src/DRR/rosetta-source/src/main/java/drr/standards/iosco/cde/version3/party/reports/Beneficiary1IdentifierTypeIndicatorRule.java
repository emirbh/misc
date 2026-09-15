package drr.standards.iosco.cde.version3.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version2.party.reports.Beneficiary1IdentifierTypeRule;
import javax.inject.Inject;


@ImplementedBy(Beneficiary1IdentifierTypeIndicatorRule.Beneficiary1IdentifierTypeIndicatorRuleDefault.class)
public abstract class Beneficiary1IdentifierTypeIndicatorRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Beneficiary1IdentifierTypeRule beneficiary1IdentifierTypeRule;

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

	public static class Beneficiary1IdentifierTypeIndicatorRuleDefault extends Beneficiary1IdentifierTypeIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = beneficiary1IdentifierTypeRule.evaluate(input);
			
			return output;
		}
	}
}
