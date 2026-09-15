package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.functions.CurrencyFromPrice;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionPriceCurrencyRule.PackageTransactionPriceCurrencyRuleDefault.class)
public abstract class PackageTransactionPriceCurrencyRule implements ReportFunction<TransactionReportInstructionBase, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyFromPrice currencyFromPrice;
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;

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

	public static class PackageTransactionPriceCurrencyRuleDefault extends PackageTransactionPriceCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstructionBase input) {
			output = currencyFromPrice.evaluate(packageTransactionPriceRule.evaluate(input));
			
			return output;
		}
	}
}
