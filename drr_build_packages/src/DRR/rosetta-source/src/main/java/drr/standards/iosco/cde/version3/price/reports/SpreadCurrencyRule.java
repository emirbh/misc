package drr.standards.iosco.cde.version3.price.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.price.functions.CurrencyFromPrice;
import javax.inject.Inject;


@ImplementedBy(SpreadCurrencyRule.SpreadCurrencyRuleDefault.class)
public abstract class SpreadCurrencyRule implements ReportFunction<PayoutLegWithAuxiliary, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyFromPrice currencyFromPrice;
	@Inject protected SpreadRule spreadRule;

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

	public static class SpreadCurrencyRuleDefault extends SpreadCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(PayoutLegWithAuxiliary input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, PayoutLegWithAuxiliary input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(currencyFromPrice.evaluate(spreadRule.evaluate(item.get())))).get();
			
			return output;
		}
	}
}
