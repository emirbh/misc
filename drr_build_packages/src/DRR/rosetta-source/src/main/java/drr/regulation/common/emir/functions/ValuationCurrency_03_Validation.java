package drr.regulation.common.emir.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationCurrency_03_Validation.ValuationCurrency_03_ValidationDefault.class)
public abstract class ValuationCurrency_03_Validation implements RosettaFunction {

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

	public static class ValuationCurrency_03_ValidationDefault extends ValuationCurrency_03_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal valuationAmount, ISOCurrencyCodeEnum valuationCurrency) {
			Boolean result = null;
			return assignOutput(result, valuationAmount, valuationCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal valuationAmount, ISOCurrencyCodeEnum valuationCurrency) {
			if (notExists(MapperS.of(valuationAmount)).getOrDefault(false)) {
				result = notExists(MapperS.of(valuationCurrency)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
