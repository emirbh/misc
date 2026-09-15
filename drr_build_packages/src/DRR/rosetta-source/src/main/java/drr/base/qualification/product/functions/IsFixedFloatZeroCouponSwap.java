package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsFixedFloatZeroCouponSwap.IsFixedFloatZeroCouponSwapDefault.class)
public abstract class IsFixedFloatZeroCouponSwap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon;
	@Inject protected Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsFixedFloatZeroCouponSwapDefault extends IsFixedFloatZeroCouponSwap {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
