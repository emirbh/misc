package drr.regulation.common.emir.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationCurrency_02_Validation.ValuationCurrency_02_ValidationDefault.class)
public abstract class ValuationCurrency_02_Validation implements RosettaFunction {

	/**
	* @param valuationCurrency 
	* @return result 
	*/
	public Boolean evaluate(ISOCurrencyCodeEnum valuationCurrency) {
		Boolean result = doEvaluate(valuationCurrency);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ISOCurrencyCodeEnum valuationCurrency);

	public static class ValuationCurrency_02_ValidationDefault extends ValuationCurrency_02_Validation {
		@Override
		protected Boolean doEvaluate(ISOCurrencyCodeEnum valuationCurrency) {
			Boolean result = null;
			return assignOutput(result, valuationCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, ISOCurrencyCodeEnum valuationCurrency) {
			if (exists(MapperS.of(valuationCurrency)).getOrDefault(false)) {
				result = notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(valuationCurrency), CardinalityOperator.All).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
