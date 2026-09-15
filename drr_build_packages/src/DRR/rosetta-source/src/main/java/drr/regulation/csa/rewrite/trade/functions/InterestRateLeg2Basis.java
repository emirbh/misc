package drr.regulation.csa.rewrite.trade.functions;

import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.regulation.common.functions.PeriodCalculation;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateLeg2Basis.InterestRateLeg2BasisDefault.class)
public abstract class InterestRateLeg2Basis implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected PeriodCalculation periodCalculation;

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

	protected abstract MapperC<? extends InterestRatePayout> interestRatePayouts(NonTransferableProduct product);

	public static class InterestRateLeg2BasisDefault extends InterestRateLeg2Basis {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg2, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2, NonTransferableProduct product) {
			if (greaterThan(MapperS.of(distinctIgnoringPrecision(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg2 = toBuilder(interestRatePayouts(product)
					.max(item -> item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex == null ? null : referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex()).<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString)).get());
			} else if (greaterThan(MapperS.of(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).resultCount()), MapperS.of(1), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(distinctIgnoringPrecision(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex())).resultCount()), MapperS.of(1), CardinalityOperator.All)).getOrDefault(false)) {
				interestRateLeg2 = toBuilder(interestRatePayouts(product)
					.max(item -> MapperS.of(periodCalculation.evaluate(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get(), item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get()))).get());
			} else {
				interestRateLeg2 = null;
			}
			
			return Optional.ofNullable(interestRateLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> interestRatePayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
	}
}
