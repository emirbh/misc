package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCapFloor;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.qualification.product.functions.IsFixedFloatZeroCouponSwapKnownAmount;
import drr.base.qualification.product.functions.IsInterestRateBasis;
import drr.base.qualification.product.functions.IsInterestRateCrossCurrency;
import drr.base.qualification.product.functions.IsInterestRateFixedFixed;
import drr.base.qualification.product.functions.IsInterestRateFixedFloatSingleCurrency;
import drr.base.qualification.product.functions.IsInterestRateReturnSwap;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateLeg1.InterestRateLeg1Default.class)
public abstract class InterestRateLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg1Basis interestRateLeg1Basis;
	@Inject protected InterestRateLeg1CapFloor interestRateLeg1CapFloor;
	@Inject protected InterestRateLeg1CrossCurrency interestRateLeg1CrossCurrency;
	@Inject protected InterestRateLeg1FixedFixed interestRateLeg1FixedFixed;
	@Inject protected InterestRateLeg1FixedFloatSingleCurrency interestRateLeg1FixedFloatSingleCurrency;
	@Inject protected InterestRateLeg1ZeroCouponSwapKnownAmount interestRateLeg1ZeroCouponSwapKnownAmount;
	@Inject protected IsCapFloor isCapFloor;
	@Inject protected IsCredit isCredit;
	@Inject protected IsFixedFloatZeroCouponSwapKnownAmount isFixedFloatZeroCouponSwapKnownAmount;
	@Inject protected IsInterestRateBasis isInterestRateBasis;
	@Inject protected IsInterestRateCrossCurrency isInterestRateCrossCurrency;
	@Inject protected IsInterestRateFixedFixed isInterestRateFixedFixed;
	@Inject protected IsInterestRateFixedFloatSingleCurrency isInterestRateFixedFloatSingleCurrency;
	@Inject protected IsInterestRateReturnSwap isInterestRateReturnSwap;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;

	/**
	* @param product 
	* @return interestRateLeg1 
	*/
	public InterestRatePayout evaluate(NonTransferableProduct product) {
		InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1Builder = doEvaluate(product);
		
		final InterestRatePayout interestRateLeg1;
		if (interestRateLeg1Builder == null) {
			interestRateLeg1 = null;
		} else {
			interestRateLeg1 = interestRateLeg1Builder.build();
			objectValidator.validate(InterestRatePayout.class, interestRateLeg1);
		}
		
		return interestRateLeg1;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product);

	public static class InterestRateLeg1Default extends InterestRateLeg1 {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1, NonTransferableProduct product) {
			final Boolean boolean0 = isFixedFloatZeroCouponSwapKnownAmount.evaluate(product);
			if ((boolean0 == null ? false : boolean0)) {
				interestRateLeg1 = toBuilder(interestRateLeg1ZeroCouponSwapKnownAmount.evaluate(product));
			} else {
				final Boolean boolean1 = isInterestRateFixedFloatSingleCurrency.evaluate(product);
				if ((boolean1 == null ? false : boolean1)) {
					interestRateLeg1 = toBuilder(interestRateLeg1FixedFloatSingleCurrency.evaluate(product));
				} else {
					final Boolean boolean2 = isInterestRateCrossCurrency.evaluate(product);
					if ((boolean2 == null ? false : boolean2)) {
						interestRateLeg1 = toBuilder(interestRateLeg1CrossCurrency.evaluate(product));
					} else {
						final Boolean boolean3 = isInterestRateFixedFixed.evaluate(product);
						if ((boolean3 == null ? false : boolean3)) {
							interestRateLeg1 = toBuilder(interestRateLeg1FixedFixed.evaluate(product));
						} else {
							final Boolean boolean4 = isInterestRateBasis.evaluate(product);
							if ((boolean4 == null ? false : boolean4)) {
								interestRateLeg1 = toBuilder(interestRateLeg1Basis.evaluate(product));
							} else {
								final Boolean boolean5 = isCapFloor.evaluate(product);
								if ((boolean5 == null ? false : boolean5)) {
									interestRateLeg1 = toBuilder(interestRateLeg1CapFloor.evaluate(product));
								} else {
									final Boolean boolean6 = isCredit.evaluate(product);
									if ((boolean6 == null ? false : boolean6)) {
										interestRateLeg1 = toBuilder(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
									} else {
										final Boolean boolean7 = isInterestRateReturnSwap.evaluate(product);
										if ((boolean7 == null ? false : boolean7)) {
											if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct())).getOrDefault(false)) {
												interestRateLeg1 = toBuilder(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
											} else if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity())).getOrDefault(false)) {
												interestRateLeg1 = toBuilder(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
											} else {
												interestRateLeg1 = null;
											}
										} else {
											interestRateLeg1 = null;
										}
									}
								}
							}
						}
					}
				}
			}
			
			return Optional.ofNullable(interestRateLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
