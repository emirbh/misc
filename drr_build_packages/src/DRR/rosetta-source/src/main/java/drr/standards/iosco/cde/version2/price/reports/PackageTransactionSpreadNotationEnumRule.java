package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.PriceNotationEnum;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionSpreadNotationEnumRule.PackageTransactionSpreadNotationEnumRuleDefault.class)
public abstract class PackageTransactionSpreadNotationEnumRule implements ReportFunction<TransactionReportInstructionBase, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.price.reports.PackageTransactionSpreadNotationEnumRule packageTransactionSpreadNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstructionBase input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstructionBase input);

	public static class PackageTransactionSpreadNotationEnumRuleDefault extends PackageTransactionSpreadNotationEnumRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstructionBase input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstructionBase input) {
			output = packageTransactionSpreadNotationEnumRule.evaluate(input);
			
			return output;
		}
	}
}
