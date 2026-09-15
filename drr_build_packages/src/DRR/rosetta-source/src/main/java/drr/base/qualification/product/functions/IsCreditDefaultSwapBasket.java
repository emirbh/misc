package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Basket;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCreditDefaultSwapBasket.IsCreditDefaultSwapBasketDefault.class)
public abstract class IsCreditDefaultSwapBasket implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_CreditDefaultSwap_Basket qualify_CreditDefaultSwap_Basket;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsCreditDefaultSwapBasketDefault extends IsCreditDefaultSwapBasket {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_CreditDefaultSwap_Basket.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
