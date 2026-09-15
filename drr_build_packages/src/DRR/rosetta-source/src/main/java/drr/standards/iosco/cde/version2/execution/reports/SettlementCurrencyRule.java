package drr.standards.iosco.cde.version2.execution.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import javax.inject.Inject;


@ImplementedBy(SettlementCurrencyRule.SettlementCurrencyRuleDefault.class)
public abstract class SettlementCurrencyRule implements ReportFunction<PayoutLegWithAuxiliary, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.execution.reports.SettlementCurrencyRule settlementCurrencyRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(PayoutLegWithAuxiliary input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(PayoutLegWithAuxiliary input);

	public static class SettlementCurrencyRuleDefault extends SettlementCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(PayoutLegWithAuxiliary input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, PayoutLegWithAuxiliary input) {
			output = settlementCurrencyRule.evaluate(input);
			
			return output;
		}
	}
}
