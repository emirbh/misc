package drr.enrichment.upi.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ConvertCurrency.ConvertCurrencyDefault.class)
public abstract class ConvertCurrency implements RosettaFunction {

	/**
	* @param currency 
	* @return result 
	*/
	public String evaluate(String currency) {
		String result = doEvaluate(currency);
		
		return result;
	}

	protected abstract String doEvaluate(String currency);

	public static class ConvertCurrencyDefault extends ConvertCurrency {
		@Override
		protected String doEvaluate(String currency) {
			String result = null;
			return assignOutput(result, currency);
		}
		
		protected String assignOutput(String result, String currency) {
			if (areEqual(MapperS.of(currency), MapperS.of("CNH"), CardinalityOperator.All).getOrDefault(false)) {
				result = "CNY";
			} else if (areEqual(MapperS.of(currency), MapperS.of("COO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "COP";
			} else if (areEqual(MapperS.of(currency), MapperS.of("GBPpence"), CardinalityOperator.All).getOrDefault(false)) {
				result = "GBP";
			} else if (areEqual(MapperS.of(currency), MapperS.of("ARO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "ARS";
			} else if (areEqual(MapperS.of(currency), MapperS.of("AZO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "AZN";
			} else if (areEqual(MapperS.of(currency), MapperS.of("BRO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "BRL";
			} else if (areEqual(MapperS.of(currency), MapperS.of("CNO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "CNY";
			} else if (areEqual(MapperS.of(currency), MapperS.of("IDO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "IDR";
			} else if (areEqual(MapperS.of(currency), MapperS.of("INO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "INR";
			} else if (areEqual(MapperS.of(currency), MapperS.of("KRO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "KRW";
			} else if (areEqual(MapperS.of(currency), MapperS.of("MAO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "MAD";
			} else if (areEqual(MapperS.of(currency), MapperS.of("MYO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "MYR";
			} else if (areEqual(MapperS.of(currency), MapperS.of("RUO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "RUB";
			} else if (areEqual(MapperS.of(currency), MapperS.of("THO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "THB";
			} else if (areEqual(MapperS.of(currency), MapperS.of("TWO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "TWD";
			} else if (areEqual(MapperS.of(currency), MapperS.of("VNO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "VND";
			} else if (areEqual(MapperS.of(currency), MapperS.of("XRH"), CardinalityOperator.All).getOrDefault(false)) {
				result = "XXX";
			} else if (areEqual(MapperS.of(currency), MapperS.of("AUO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "AUD";
			} else if (areEqual(MapperS.of(currency), MapperS.of("LKO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "LKR";
			} else if (areEqual(MapperS.of(currency), MapperS.of("UAO"), CardinalityOperator.All).getOrDefault(false)) {
				result = "UAH";
			} else {
				result = currency;
			}
			
			return result;
		}
	}
}
