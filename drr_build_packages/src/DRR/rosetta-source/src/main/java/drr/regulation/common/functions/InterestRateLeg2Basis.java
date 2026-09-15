package drr.regulation.common.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.SpreadSchedule;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateLeg2Basis.InterestRateLeg2BasisDefault.class)
public abstract class InterestRateLeg2Basis implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ResetFrequencyPeriodToDays resetFrequencyPeriodToDays;

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

	protected abstract MapperC<? extends InterestRatePayout> InterestRatePayouts(NonTransferableProduct product);

	public static class InterestRateLeg2BasisDefault extends InterestRateLeg2Basis {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg2, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2, NonTransferableProduct product) {
			if (greaterThan(MapperS.of(distinctIgnoringPrecision(InterestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg2 = toBuilder(InterestRatePayouts(product)
					.min(item -> item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).get());
			} else if (greaterThan(MapperS.of(InterestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).resultCount()), MapperS.of(1), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(distinctIgnoringPrecision(InterestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All)).orNullSafe(notExists(InterestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()))).getOrDefault(false)) {
				if (areEqual(InterestRatePayouts(product)
					.min(item -> MapperS.of(resetFrequencyPeriodToDays.evaluate(item.get()))), InterestRatePayouts(product)
					.max(item -> MapperS.of(resetFrequencyPeriodToDays.evaluate(item.get()))), CardinalityOperator.All).getOrDefault(false)) {
					interestRateLeg2 = toBuilder(InterestRatePayouts(product)
						.last().get());
				} else {
					interestRateLeg2 = toBuilder(InterestRatePayouts(product)
						.max(item -> MapperS.of(resetFrequencyPeriodToDays.evaluate(item.get()))).get());
				}
			} else if (areEqual(MapperS.of(distinctIgnoringPrecision(InterestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				final MapperC<? extends InterestRatePayout> thenArg = InterestRatePayouts(product)
					.filterItemNullSafe(item -> notExists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).get());
				interestRateLeg2 = toBuilder(MapperS.of(thenArg.get()).get());
			} else {
				interestRateLeg2 = null;
			}
			
			return Optional.ofNullable(interestRateLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> InterestRatePayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
	}
}
