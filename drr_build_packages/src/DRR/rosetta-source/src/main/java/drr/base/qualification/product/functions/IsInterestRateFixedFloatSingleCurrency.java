package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_SubProduct_FixedFloat;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsInterestRateFixedFloatSingleCurrency.IsInterestRateFixedFloatSingleCurrencyDefault.class)
public abstract class IsInterestRateFixedFloatSingleCurrency implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_SubProduct_FixedFloat qualify_SubProduct_FixedFloat;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsInterestRateFixedFloatSingleCurrencyDefault extends IsInterestRateFixedFloatSingleCurrency {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_SubProduct_FixedFloat.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(false), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
