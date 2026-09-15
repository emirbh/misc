package drr.standards.iso.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ConvertNonISOToISOCurrency.ConvertNonISOToISOCurrencyDefault.class)
public abstract class ConvertNonISOToISOCurrency implements RosettaFunction {

	/**
	* @param nonISOCurrency 
	* @return isoCurrency 
	*/
	public ISOCurrencyCodeEnum evaluate(String nonISOCurrency) {
		ISOCurrencyCodeEnum isoCurrency = doEvaluate(nonISOCurrency);
		
		return isoCurrency;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(String nonISOCurrency);

	public static class ConvertNonISOToISOCurrencyDefault extends ConvertNonISOToISOCurrency {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(String nonISOCurrency) {
			ISOCurrencyCodeEnum isoCurrency = null;
			return assignOutput(isoCurrency, nonISOCurrency);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum isoCurrency, String nonISOCurrency) {
			if (areEqual(MapperS.of(nonISOCurrency), MapperS.of("CNH"), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(MapperS.of(nonISOCurrency), MapperS.of("CNH"), CardinalityOperator.All).getOrDefault(false)) {
					isoCurrency = ISOCurrencyCodeEnum.CNY;
				} else {
					isoCurrency = null;
				}
			} else {
				isoCurrency = MapperS.of(nonISOCurrency).checkedMap("to-enum", ISOCurrencyCodeEnum::fromDisplayName, IllegalArgumentException.class).get();
			}
			
			return isoCurrency;
		}
	}
}
