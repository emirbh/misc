package drr.standards.iosco.cde.version1.quantity.reports;

import cdm.base.math.Measure;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.quantity.functions.CurrencyFromNotional;
import drr.standards.iosco.cde.version1.quantity.functions.Notional;
import javax.inject.Inject;


@ImplementedBy(NotionalCurrencyRule.NotionalCurrencyRuleDefault.class)
public abstract class NotionalCurrencyRule implements ReportFunction<PayoutLegWithAuxiliary, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyFromNotional currencyFromNotional;
	@Inject protected Notional notional;

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

	public static class NotionalCurrencyRuleDefault extends NotionalCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(PayoutLegWithAuxiliary input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, PayoutLegWithAuxiliary input) {
			final MapperS<Measure> thenArg = MapperS.of(notional.evaluate(input));
			output = MapperS.of(currencyFromNotional.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
