package drr.base.qualification.product.functions;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEquitySwap.IsEquitySwapDefault.class)
public abstract class IsEquitySwap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsEquitySwapProduct isEquitySwapProduct;

	/**
	* @param tradableProduct 
	* @return result 
	*/
	public Boolean evaluate(TradableProduct tradableProduct) {
		Boolean result = doEvaluate(tradableProduct);
		
		return result;
	}

	protected abstract Boolean doEvaluate(TradableProduct tradableProduct);

	public static class IsEquitySwapDefault extends IsEquitySwap {
		@Override
		protected Boolean doEvaluate(TradableProduct tradableProduct) {
			Boolean result = null;
			return assignOutput(result, tradableProduct);
		}
		
		protected Boolean assignOutput(Boolean result, TradableProduct tradableProduct) {
			result = areEqual(MapperS.of(isEquitySwapProduct.evaluate(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get())), MapperS.of(true), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
