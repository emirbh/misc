package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Leg;
import javax.inject.Inject;


@ImplementedBy(CreatePriceKey.CreatePriceKeyDefault.class)
public abstract class CreatePriceKey implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateKey createKey;

	/**
	* @param id 
	* @param fpmlLeg 
	* @return keyValueWithIndex 
	*/
	public String evaluate(String id, Leg fpmlLeg) {
		String keyValueWithIndex = doEvaluate(id, fpmlLeg);
		
		return keyValueWithIndex;
	}

	protected abstract String doEvaluate(String id, Leg fpmlLeg);

	public static class CreatePriceKeyDefault extends CreatePriceKey {
		@Override
		protected String doEvaluate(String id, Leg fpmlLeg) {
			String keyValueWithIndex = null;
			return assignOutput(keyValueWithIndex, id, fpmlLeg);
		}
		
		protected String assignOutput(String keyValueWithIndex, String id, Leg fpmlLeg) {
			keyValueWithIndex = createKey.evaluate("price", id, fpmlLeg);
			
			return keyValueWithIndex;
		}
	}
}
