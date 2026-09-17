package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.asset.Asset;


@ImplementedBy(CreateAssetKey.CreateAssetKeyDefault.class)
public abstract class CreateAssetKey implements RosettaFunction {

	/**
	* @param keyPrefix 
	* @param fpmlAsset 
	* @return keyValue 
	*/
	public String evaluate(String keyPrefix, Asset fpmlAsset) {
		String keyValue = doEvaluate(keyPrefix, fpmlAsset);
		
		return keyValue;
	}

	protected abstract String doEvaluate(String keyPrefix, Asset fpmlAsset);

	public static class CreateAssetKeyDefault extends CreateAssetKey {
		@Override
		protected String doEvaluate(String keyPrefix, Asset fpmlAsset) {
			String keyValue = null;
			return assignOutput(keyValue, keyPrefix, fpmlAsset);
		}
		
		protected String assignOutput(String keyValue, String keyPrefix, Asset fpmlAsset) {
			return keyValue;
		}
	}
}
