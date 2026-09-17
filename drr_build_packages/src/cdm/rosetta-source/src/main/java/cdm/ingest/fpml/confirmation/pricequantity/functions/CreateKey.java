package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Leg;


@ImplementedBy(CreateKey.CreateKeyDefault.class)
public abstract class CreateKey implements RosettaFunction {

	/**
	* @param keyPrefix 
	* @param id 
	* @param fpmlLeg 
	* @return keyValueWithIndex 
	*/
	public String evaluate(String keyPrefix, String id, Leg fpmlLeg) {
		String keyValueWithIndex = doEvaluate(keyPrefix, id, fpmlLeg);
		
		return keyValueWithIndex;
	}

	protected abstract String doEvaluate(String keyPrefix, String id, Leg fpmlLeg);

	public static class CreateKeyDefault extends CreateKey {
		@Override
		protected String doEvaluate(String keyPrefix, String id, Leg fpmlLeg) {
			String keyValueWithIndex = null;
			return assignOutput(keyValueWithIndex, keyPrefix, id, fpmlLeg);
		}
		
		protected String assignOutput(String keyValueWithIndex, String keyPrefix, String id, Leg fpmlLeg) {
			return keyValueWithIndex;
		}
	}
}
