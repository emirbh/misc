package drr.base.qualification.product.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsFixedFloatZeroCouponSwapKnownAmount.IsFixedFloatZeroCouponSwapKnownAmountDefault.class)
public abstract class IsFixedFloatZeroCouponSwapKnownAmount implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsFixedFloatZeroCouponSwap isFixedFloatZeroCouponSwap;
	@Inject protected IsZeroCouponSwapKnownAmount isZeroCouponSwapKnownAmount;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsFixedFloatZeroCouponSwapKnownAmountDefault extends IsFixedFloatZeroCouponSwapKnownAmount {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			final MapperC<InterestRatePayout> thenArg = MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
				.filterItemNullSafe(item -> isZeroCouponSwapKnownAmount.evaluate(item.get()));
			result = areEqual(MapperS.of(isFixedFloatZeroCouponSwap.evaluate(product)), MapperS.of(true), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(areEqual(MapperS.of(thenArg.resultCount()), MapperS.of(1), CardinalityOperator.All).asMapper())).get();
			
			return result;
		}
	}
}
