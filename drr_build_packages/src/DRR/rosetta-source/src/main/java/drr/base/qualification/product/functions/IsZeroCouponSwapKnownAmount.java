package drr.base.qualification.product.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsZeroCouponSwapKnownAmount.IsZeroCouponSwapKnownAmountDefault.class)
public abstract class IsZeroCouponSwapKnownAmount implements RosettaFunction {

	/**
	* @param payout 
	* @return result 
	*/
	public Boolean evaluate(InterestRatePayout payout) {
		Boolean result = doEvaluate(payout);
		
		return result;
	}

	protected abstract Boolean doEvaluate(InterestRatePayout payout);

	public static class IsZeroCouponSwapKnownAmountDefault extends IsZeroCouponSwapKnownAmount {
		@Override
		protected Boolean doEvaluate(InterestRatePayout payout) {
			Boolean result = null;
			return assignOutput(result, payout);
		}
		
		protected Boolean assignOutput(Boolean result, InterestRatePayout payout) {
			result = exists(MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity())).andNullSafe(notExists(MapperS.of(payout).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()))).get();
			
			return result;
		}
	}
}
