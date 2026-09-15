package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.asset.Asset;
import javax.inject.Inject;


@ImplementedBy(ObservableKeyValue.ObservableKeyValueDefault.class)
public abstract class ObservableKeyValue implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateAssetKey createAssetKey;

	/**
	* @param fpmlAsset 
	* @return keyValue 
	*/
	public String evaluate(Asset fpmlAsset) {
		String keyValue = doEvaluate(fpmlAsset);
		
		return keyValue;
	}

	protected abstract String doEvaluate(Asset fpmlAsset);

	public static class ObservableKeyValueDefault extends ObservableKeyValue {
		@Override
		protected String doEvaluate(Asset fpmlAsset) {
			String keyValue = null;
			return assignOutput(keyValue, fpmlAsset);
		}
		
		protected String assignOutput(String keyValue, Asset fpmlAsset) {
			keyValue = createAssetKey.evaluate("observable", fpmlAsset);
			
			return keyValue;
		}
	}
}
