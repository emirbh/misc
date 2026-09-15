package drr.base.trade.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(GetQuantityKeys.GetQuantityKeysDefault.class)
public abstract class GetQuantityKeys implements RosettaFunction {

	/**
	* @param priceQuantity 
	* @return keyValues 
	*/
	public List<String> evaluate(PriceQuantity priceQuantity) {
		List<String> keyValues = doEvaluate(priceQuantity);
		
		return keyValues;
	}

	protected abstract List<String> doEvaluate(PriceQuantity priceQuantity);

	public static class GetQuantityKeysDefault extends GetQuantityKeys {
		@Override
		protected List<String> doEvaluate(PriceQuantity priceQuantity) {
			List<String> keyValues = new ArrayList<>();
			return assignOutput(keyValues, priceQuantity);
		}
		
		protected List<String> assignOutput(List<String> keyValues, PriceQuantity priceQuantity) {
			return keyValues;
		}
	}
}
