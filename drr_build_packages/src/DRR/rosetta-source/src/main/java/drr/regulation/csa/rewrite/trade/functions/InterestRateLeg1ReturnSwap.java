package drr.regulation.csa.rewrite.trade.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateLeg1ReturnSwap.InterestRateLeg1ReturnSwapDefault.class)
public abstract class InterestRateLeg1ReturnSwap implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
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

	protected abstract MapperC<? extends InterestRatePayout> interestRateLegs(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> fixedRateLegs(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> floatingRateLegs(NonTransferableProduct product);

	protected abstract MapperC<? extends FieldWithMetaFloatingRateIndexEnum> floatingRateIndexes(NonTransferableProduct product);

	protected abstract MapperC<? extends FieldWithMetaFloatingRateIndexEnum> flotingRateIndexSecurity(NonTransferableProduct product);

	protected abstract MapperC<? extends FieldWithMetaFloatingRateIndexEnum> floatingRateIndexContractualProduct(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> IRPayoutContractualProduct(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> IRPayoutSecurity(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> fixedRateLegContractualProduct(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> floatingRateLegContractualProduct(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> fixedRateLegSecurity(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> floatingRateLegSecurity(NonTransferableProduct product);

	protected abstract MapperC<String> comparison(NonTransferableProduct product);

	protected abstract MapperS<String> sortedReturnSwapIdentifier(NonTransferableProduct product);

	public static class InterestRateLeg1ReturnSwapDefault extends InterestRateLeg1ReturnSwap {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1, NonTransferableProduct product) {
			if (greaterThan(MapperS.of(fixedRateLegs(product).resultCount()), MapperS.of(0), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(fixedRateLegs(product).get());
			} else if (greaterThan(MapperS.of(floatingRateLegs(product).resultCount()), MapperS.of(0), CardinalityOperator.All).getOrDefault(false)) {
				if (exists(IRPayoutContractualProduct(product)).getOrDefault(false)) {
					if (greaterThan(MapperS.of(fixedRateLegContractualProduct(product).resultCount()), MapperS.of(0), CardinalityOperator.All).getOrDefault(false)) {
						interestRateLeg1 = toBuilder(fixedRateLegContractualProduct(product).get());
					} else if (exists(floatingRateLegContractualProduct(product)).getOrDefault(false)) {
						final FieldWithMetaFloatingRateIndexEnum fieldWithMetaFloatingRateIndexEnum0 = floatingRateIndexContractualProduct(product).get();
						if (areEqual((fieldWithMetaFloatingRateIndexEnum0 == null ? MapperS.<FloatingRateIndexEnum>ofNull() : MapperS.of(fieldWithMetaFloatingRateIndexEnum0.getValue())).map("to-string", FloatingRateIndexEnum::toDisplayString), sortedReturnSwapIdentifier(product), CardinalityOperator.All).getOrDefault(false)) {
							interestRateLeg1 = toBuilder(floatingRateLegContractualProduct(product).get());
						} else {
							interestRateLeg1 = toBuilder(floatingRateLegs(product).get());
						}
					} else if (exists(IRPayoutSecurity(product)).getOrDefault(false)) {
						if (greaterThan(MapperS.of(fixedRateLegSecurity(product).resultCount()), MapperS.of(0), CardinalityOperator.All).getOrDefault(false)) {
							interestRateLeg1 = toBuilder(fixedRateLegSecurity(product).get());
						} else if (exists(floatingRateLegSecurity(product)).getOrDefault(false)) {
							final FieldWithMetaFloatingRateIndexEnum fieldWithMetaFloatingRateIndexEnum1 = flotingRateIndexSecurity(product).get();
							if (areEqual((fieldWithMetaFloatingRateIndexEnum1 == null ? MapperS.<FloatingRateIndexEnum>ofNull() : MapperS.of(fieldWithMetaFloatingRateIndexEnum1.getValue())).map("to-string", FloatingRateIndexEnum::toDisplayString), sortedReturnSwapIdentifier(product), CardinalityOperator.All).getOrDefault(false)) {
								interestRateLeg1 = toBuilder(floatingRateLegSecurity(product).get());
							} else {
								interestRateLeg1 = toBuilder(floatingRateLegs(product).get());
							}
						} else {
							interestRateLeg1 = null;
						}
					} else {
						interestRateLeg1 = null;
					}
				} else {
					interestRateLeg1 = null;
				}
			} else {
				interestRateLeg1 = null;
			}
			
			return Optional.ofNullable(interestRateLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> interestRateLegs(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> fixedRateLegs(NonTransferableProduct product) {
			return interestRateLegs(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> floatingRateLegs(NonTransferableProduct product) {
			return interestRateLegs(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaFloatingRateIndexEnum> floatingRateIndexes(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaFloatingRateIndexEnum> flotingRateIndexSecurity(NonTransferableProduct product) {
			return IRPayoutSecurity(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaFloatingRateIndexEnum> floatingRateIndexContractualProduct(NonTransferableProduct product) {
			return IRPayoutContractualProduct(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> IRPayoutContractualProduct(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> IRPayoutSecurity(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> fixedRateLegContractualProduct(NonTransferableProduct product) {
			return IRPayoutContractualProduct(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> floatingRateLegContractualProduct(NonTransferableProduct product) {
			return IRPayoutContractualProduct(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> fixedRateLegSecurity(NonTransferableProduct product) {
			return IRPayoutSecurity(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> floatingRateLegSecurity(NonTransferableProduct product) {
			return IRPayoutSecurity(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
		}
		
		@Override
		protected MapperC<String> comparison(NonTransferableProduct product) {
			final FieldWithMetaFloatingRateIndexEnum fieldWithMetaFloatingRateIndexEnum0 = floatingRateIndexes(product).get();
			final FieldWithMetaFloatingRateIndexEnum fieldWithMetaFloatingRateIndexEnum1 = flotingRateIndexSecurity(product).get();
			final FieldWithMetaFloatingRateIndexEnum fieldWithMetaFloatingRateIndexEnum2 = floatingRateIndexContractualProduct(product).get();
			return MapperC.<String>of((fieldWithMetaFloatingRateIndexEnum0 == null ? MapperS.<FloatingRateIndexEnum>ofNull() : MapperS.of(fieldWithMetaFloatingRateIndexEnum0.getValue())).map("to-string", FloatingRateIndexEnum::toDisplayString), (fieldWithMetaFloatingRateIndexEnum1 == null ? MapperS.<FloatingRateIndexEnum>ofNull() : MapperS.of(fieldWithMetaFloatingRateIndexEnum1.getValue())).map("to-string", FloatingRateIndexEnum::toDisplayString), (fieldWithMetaFloatingRateIndexEnum2 == null ? MapperS.<FloatingRateIndexEnum>ofNull() : MapperS.of(fieldWithMetaFloatingRateIndexEnum2.getValue())).map("to-string", FloatingRateIndexEnum::toDisplayString));
		}
		
		@Override
		protected MapperS<String> sortedReturnSwapIdentifier(NonTransferableProduct product) {
			return comparison(product)
				.min();
		}
	}
}
