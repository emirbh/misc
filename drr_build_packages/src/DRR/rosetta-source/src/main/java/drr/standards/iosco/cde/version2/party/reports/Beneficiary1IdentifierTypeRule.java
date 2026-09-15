package drr.standards.iosco.cde.version2.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.party.reports.Beneficiary1IdentifierTypeIndicatorRule;
import javax.inject.Inject;


@ImplementedBy(Beneficiary1IdentifierTypeRule.Beneficiary1IdentifierTypeRuleDefault.class)
public abstract class Beneficiary1IdentifierTypeRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Beneficiary1IdentifierTypeIndicatorRule beneficiary1IdentifierTypeIndicatorRule;

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

	public static class Beneficiary1IdentifierTypeRuleDefault extends Beneficiary1IdentifierTypeRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = beneficiary1IdentifierTypeIndicatorRule.evaluate(input);
			
			return output;
		}
	}
}
