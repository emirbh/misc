package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Leg;
import javax.inject.Inject;


@ImplementedBy(CreateObservableKey.CreateObservableKeyDefault.class)
public abstract class CreateObservableKey implements RosettaFunction {
	
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

	public static class CreateObservableKeyDefault extends CreateObservableKey {
		@Override
		protected String doEvaluate(String id, Leg fpmlLeg) {
			String keyValueWithIndex = null;
			return assignOutput(keyValueWithIndex, id, fpmlLeg);
		}
		
		protected String assignOutput(String keyValueWithIndex, String id, Leg fpmlLeg) {
			keyValueWithIndex = createKey.evaluate("observable", id, fpmlLeg);
			
			return keyValueWithIndex;
		}
	}
}
