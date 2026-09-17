package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.QuotedCurrencyPair;


@ImplementedBy(CreateKeyForQuotedCurrencyPair.CreateKeyForQuotedCurrencyPairDefault.class)
public abstract class CreateKeyForQuotedCurrencyPair implements RosettaFunction {

	/**
	* @param keyPrefix 
	* @param fpmlQuotedCurrencyPair 
	* @return keyValueWithIndex 
	*/
	public String evaluate(String keyPrefix, QuotedCurrencyPair fpmlQuotedCurrencyPair) {
		String keyValueWithIndex = doEvaluate(keyPrefix, fpmlQuotedCurrencyPair);
		
		return keyValueWithIndex;
	}

	protected abstract String doEvaluate(String keyPrefix, QuotedCurrencyPair fpmlQuotedCurrencyPair);

	public static class CreateKeyForQuotedCurrencyPairDefault extends CreateKeyForQuotedCurrencyPair {
		@Override
		protected String doEvaluate(String keyPrefix, QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			String keyValueWithIndex = null;
			return assignOutput(keyValueWithIndex, keyPrefix, fpmlQuotedCurrencyPair);
		}
		
		protected String assignOutput(String keyValueWithIndex, String keyPrefix, QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			return keyValueWithIndex;
		}
	}
}
