package drr.base.trade.functions;

import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(GetQuantityReference.GetQuantityReferenceDefault.class)
public abstract class GetQuantityReference implements RosettaFunction {

	/**
	* @param resolvablePriceQuantity 
	* @return referenceValue 
	*/
	public String evaluate(ResolvablePriceQuantity resolvablePriceQuantity) {
		String referenceValue = doEvaluate(resolvablePriceQuantity);
		
		return referenceValue;
	}

	protected abstract String doEvaluate(ResolvablePriceQuantity resolvablePriceQuantity);

	public static class GetQuantityReferenceDefault extends GetQuantityReference {
		@Override
		protected String doEvaluate(ResolvablePriceQuantity resolvablePriceQuantity) {
			String referenceValue = null;
			return assignOutput(referenceValue, resolvablePriceQuantity);
		}
		
		protected String assignOutput(String referenceValue, ResolvablePriceQuantity resolvablePriceQuantity) {
			return referenceValue;
		}
	}
}
