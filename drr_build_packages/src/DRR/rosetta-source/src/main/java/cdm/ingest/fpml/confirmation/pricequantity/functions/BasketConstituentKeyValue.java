package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.BasketConstituent;
import javax.inject.Inject;


@ImplementedBy(BasketConstituentKeyValue.BasketConstituentKeyValueDefault.class)
public abstract class BasketConstituentKeyValue implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateAssetKey createAssetKey;

	/**
	* @param fpmlBasketConstituent 
	* @return keyValue 
	*/
	public String evaluate(BasketConstituent fpmlBasketConstituent) {
		String keyValue = doEvaluate(fpmlBasketConstituent);
		
		return keyValue;
	}

	protected abstract String doEvaluate(BasketConstituent fpmlBasketConstituent);

	public static class BasketConstituentKeyValueDefault extends BasketConstituentKeyValue {
		@Override
		protected String doEvaluate(BasketConstituent fpmlBasketConstituent) {
			String keyValue = null;
			return assignOutput(keyValue, fpmlBasketConstituent);
		}
		
		protected String assignOutput(String keyValue, BasketConstituent fpmlBasketConstituent) {
			keyValue = createAssetKey.evaluate("basketConstituent", MapperS.of(fpmlBasketConstituent).<Asset>map("getUnderlyingAsset", basketConstituent -> basketConstituent.getUnderlyingAsset()).get());
			
			return keyValue;
		}
	}
}
