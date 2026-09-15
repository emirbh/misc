package drr.regulation.common.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.InterestRateReturnSwap;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.qualification.product.functions.IsFixedFloatZeroCouponSwapKnownAmount;
import drr.base.qualification.product.functions.IsInterestRateBasis;
import drr.base.qualification.product.functions.IsInterestRateCrossCurrency;
import drr.base.qualification.product.functions.IsInterestRateFixedFixed;
import drr.base.qualification.product.functions.IsInterestRateFixedFloatSingleCurrency;
import drr.base.qualification.product.functions.IsTotalReturnSwapDebtUnderlier;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(InterestRateLeg2.InterestRateLeg2Default.class)
public abstract class InterestRateLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg2Basis interestRateLeg2Basis;
	@Inject protected InterestRateLeg2CrossCurrency interestRateLeg2CrossCurrency;
	@Inject protected InterestRateLeg2FixedFixed interestRateLeg2FixedFixed;
	@Inject protected InterestRateLeg2FixedFloatSingleCurrency interestRateLeg2FixedFloatSingleCurrency;
	@Inject protected InterestRateReturnSwap interestRateReturnSwap;
	@Inject protected IsCreditTotalReturnSwap isCreditTotalReturnSwap;
	@Inject protected IsEquity isEquity;
	@Inject protected IsFixedFloatZeroCouponSwapKnownAmount isFixedFloatZeroCouponSwapKnownAmount;
	@Inject protected IsInterestRateBasis isInterestRateBasis;
	@Inject protected IsInterestRateCrossCurrency isInterestRateCrossCurrency;
	@Inject protected IsInterestRateFixedFixed isInterestRateFixedFixed;
	@Inject protected IsInterestRateFixedFloatSingleCurrency isInterestRateFixedFloatSingleCurrency;
	@Inject protected IsTotalReturnSwapDebtUnderlier isTotalReturnSwapDebtUnderlier;

	/**
	* @param product 
	* @return interestRateLeg2 
	*/
	public InterestRatePayout evaluate(NonTransferableProduct product) {
		InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2Builder = doEvaluate(product);
		
		final InterestRatePayout interestRateLeg2;
		if (interestRateLeg2Builder == null) {
			interestRateLeg2 = null;
		} else {
			interestRateLeg2 = interestRateLeg2Builder.build();
			objectValidator.validate(InterestRatePayout.class, interestRateLeg2);
		}
		
		return interestRateLeg2;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product);

	public static class InterestRateLeg2Default extends InterestRateLeg2 {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg2, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2, NonTransferableProduct product) {
			if (ComparisonResult.ofNullSafe(MapperS.of(isInterestRateFixedFloatSingleCurrency.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFixedFloatZeroCouponSwapKnownAmount.evaluate(product)))).getOrDefault(false)) {
				interestRateLeg2 = toBuilder(interestRateLeg2FixedFloatSingleCurrency.evaluate(product));
			} else {
				final Boolean boolean0 = isInterestRateCrossCurrency.evaluate(product);
				if ((boolean0 == null ? false : boolean0)) {
					interestRateLeg2 = toBuilder(interestRateLeg2CrossCurrency.evaluate(product));
				} else {
					final Boolean boolean1 = isInterestRateFixedFixed.evaluate(product);
					if ((boolean1 == null ? false : boolean1)) {
						interestRateLeg2 = toBuilder(interestRateLeg2FixedFixed.evaluate(product));
					} else {
						final Boolean boolean2 = isInterestRateBasis.evaluate(product);
						if ((boolean2 == null ? false : boolean2)) {
							interestRateLeg2 = toBuilder(interestRateLeg2Basis.evaluate(product));
						} else {
							final Boolean boolean3 = isTotalReturnSwapDebtUnderlier.evaluate(product);
							if ((boolean3 == null ? false : boolean3)) {
								interestRateLeg2 = toBuilder(interestRateReturnSwap.evaluate(product));
							} else if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCreditTotalReturnSwap.evaluate(product)))).getOrDefault(false)) {
								interestRateLeg2 = toBuilder(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
							} else {
								interestRateLeg2 = null;
							}
						}
					}
				}
			}
			
			return Optional.ofNullable(interestRateLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
