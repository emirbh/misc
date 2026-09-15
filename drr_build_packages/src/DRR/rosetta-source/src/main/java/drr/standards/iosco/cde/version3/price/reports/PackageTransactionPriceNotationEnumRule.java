package drr.standards.iosco.cde.version3.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.PriceNotationEnum;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionPriceNotationEnumRule.PackageTransactionPriceNotationEnumRuleDefault.class)
public abstract class PackageTransactionPriceNotationEnumRule implements ReportFunction<TransactionReportInstructionBase, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.price.reports.PackageTransactionPriceNotationEnumRule packageTransactionPriceNotationEnumRule;

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

	public static class PackageTransactionPriceNotationEnumRuleDefault extends PackageTransactionPriceNotationEnumRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstructionBase input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstructionBase input) {
			output = packageTransactionPriceNotationEnumRule.evaluate(input);
			
			return output;
		}
	}
}
