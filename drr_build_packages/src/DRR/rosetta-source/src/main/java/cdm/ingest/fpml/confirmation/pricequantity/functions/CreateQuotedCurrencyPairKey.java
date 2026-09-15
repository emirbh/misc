package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.QuotedCurrencyPair;
import javax.inject.Inject;


@ImplementedBy(CreateQuotedCurrencyPairKey.CreateQuotedCurrencyPairKeyDefault.class)
public abstract class CreateQuotedCurrencyPairKey implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateKeyForQuotedCurrencyPair createKeyForQuotedCurrencyPair;

	/**
	* @param fpmlQuotedCurrencyPair 
	* @return keyValueWithIndex 
	*/
	public String evaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair) {
		String keyValueWithIndex = doEvaluate(fpmlQuotedCurrencyPair);
		
		return keyValueWithIndex;
	}

	protected abstract String doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair);

	public static class CreateQuotedCurrencyPairKeyDefault extends CreateQuotedCurrencyPairKey {
		@Override
		protected String doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			String keyValueWithIndex = null;
			return assignOutput(keyValueWithIndex, fpmlQuotedCurrencyPair);
		}
		
		protected String assignOutput(String keyValueWithIndex, QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			keyValueWithIndex = createKeyForQuotedCurrencyPair.evaluate("quotedCurrencyPair", fpmlQuotedCurrencyPair);
			
			return keyValueWithIndex;
		}
	}
}
