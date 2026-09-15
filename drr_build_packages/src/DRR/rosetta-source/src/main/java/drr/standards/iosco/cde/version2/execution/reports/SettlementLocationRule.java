package drr.standards.iosco.cde.version2.execution.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import javax.inject.Inject;


@ImplementedBy(SettlementLocationRule.SettlementLocationRuleDefault.class)
public abstract class SettlementLocationRule implements ReportFunction<PayoutLegWithAuxiliary, ISOCountryCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.execution.reports.SettlementLocationRule settlementLocationRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCountryCodeEnum evaluate(PayoutLegWithAuxiliary input) {
		ISOCountryCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCountryCodeEnum doEvaluate(PayoutLegWithAuxiliary input);

	public static class SettlementLocationRuleDefault extends SettlementLocationRule {
		@Override
		protected ISOCountryCodeEnum doEvaluate(PayoutLegWithAuxiliary input) {
			ISOCountryCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCountryCodeEnum assignOutput(ISOCountryCodeEnum output, PayoutLegWithAuxiliary input) {
			output = settlementLocationRule.evaluate(input);
			
			return output;
		}
	}
}
