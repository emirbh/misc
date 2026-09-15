package drr.regulation.common.emir.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationCurrency_01_Validation.ValuationCurrency_01_ValidationDefault.class)
public abstract class ValuationCurrency_01_Validation implements RosettaFunction {

	/**
	* @param valuationAmount 
	* @param valuationCurrency 
	* @return result 
	*/
	public Boolean evaluate(BigDecimal valuationAmount, ISOCurrencyCodeEnum valuationCurrency) {
		Boolean result = doEvaluate(valuationAmount, valuationCurrency);
		
		return result;
	}

	protected abstract Boolean doEvaluate(BigDecimal valuationAmount, ISOCurrencyCodeEnum valuationCurrency);

	public static class ValuationCurrency_01_ValidationDefault extends ValuationCurrency_01_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal valuationAmount, ISOCurrencyCodeEnum valuationCurrency) {
			Boolean result = null;
			return assignOutput(result, valuationAmount, valuationCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal valuationAmount, ISOCurrencyCodeEnum valuationCurrency) {
			if (exists(MapperS.of(valuationAmount)).getOrDefault(false)) {
				result = exists(MapperS.of(valuationCurrency)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
