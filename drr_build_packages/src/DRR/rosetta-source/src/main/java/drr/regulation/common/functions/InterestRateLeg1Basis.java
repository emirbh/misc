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

@ImplementedBy(InterestRateLeg1Basis.InterestRateLeg1BasisDefault.class)
public abstract class InterestRateLeg1Basis implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ResetFrequencyPeriodToDays resetFrequencyPeriodToDays;

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

	protected abstract MapperC<? extends InterestRatePayout> interestRatePayouts(NonTransferableProduct product);

	public static class InterestRateLeg1BasisDefault extends InterestRateLeg1Basis {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1, NonTransferableProduct product) {
			if (greaterThan(MapperS.of(distinctIgnoringPrecision(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(interestRatePayouts(product)
					.max(item -> item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).get());
			} else if (greaterThan(MapperS.of(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).resultCount()), MapperS.of(1), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(distinctIgnoringPrecision(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All)).orNullSafe(notExists(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()))).getOrDefault(false)) {
				if (areEqual(interestRatePayouts(product)
					.min(item -> MapperS.of(resetFrequencyPeriodToDays.evaluate(item.get()))), interestRatePayouts(product)
					.max(item -> MapperS.of(resetFrequencyPeriodToDays.evaluate(item.get()))), CardinalityOperator.All).getOrDefault(false)) {
					interestRateLeg1 = toBuilder(interestRatePayouts(product)
						.first().get());
				} else {
					interestRateLeg1 = toBuilder(interestRatePayouts(product)
						.min(item -> MapperS.of(resetFrequencyPeriodToDays.evaluate(item.get()))).get());
				}
			} else if (areEqual(MapperS.of(distinctIgnoringPrecision(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				final MapperC<? extends InterestRatePayout> thenArg = interestRatePayouts(product)
					.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).get());
				interestRateLeg1 = toBuilder(MapperS.of(thenArg.get()).get());
			} else {
				interestRateLeg1 = null;
			}
			
			return Optional.ofNullable(interestRateLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> interestRatePayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
	}
}
