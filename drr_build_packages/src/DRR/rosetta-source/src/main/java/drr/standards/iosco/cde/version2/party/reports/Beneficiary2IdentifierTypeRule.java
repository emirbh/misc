package drr.standards.iosco.cde.version2.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.party.reports.Beneficiary2IdentifierTypeIndicatorRule;
import javax.inject.Inject;


@ImplementedBy(Beneficiary2IdentifierTypeRule.Beneficiary2IdentifierTypeRuleDefault.class)
public abstract class Beneficiary2IdentifierTypeRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Beneficiary2IdentifierTypeIndicatorRule beneficiary2IdentifierTypeIndicatorRule;

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

	public static class Beneficiary2IdentifierTypeRuleDefault extends Beneficiary2IdentifierTypeRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = beneficiary2IdentifierTypeIndicatorRule.evaluate(input);
			
			return output;
		}
	}
}
