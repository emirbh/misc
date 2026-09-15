package drr.standards.iosco.cde.version2.price.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(OptionPremiumCurrencyRule.OptionPremiumCurrencyRuleDefault.class)
public abstract class OptionPremiumCurrencyRule implements ReportFunction<TransactionReportInstructionBase, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.price.reports.OptionPremiumCurrencyRule optionPremiumCurrencyRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransactionReportInstructionBase input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input);

	public static class OptionPremiumCurrencyRuleDefault extends OptionPremiumCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstructionBase input) {
			output = optionPremiumCurrencyRule.evaluate(input);
			
			return output;
		}
	}
}
