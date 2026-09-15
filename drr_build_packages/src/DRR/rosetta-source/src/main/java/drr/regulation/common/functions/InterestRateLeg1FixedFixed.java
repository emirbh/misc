package drr.regulation.common.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateLeg1FixedFixed.InterestRateLeg1FixedFixedDefault.class)
public abstract class InterestRateLeg1FixedFixed implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriodToDays calculationPeriodToDays;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;

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

	protected abstract MapperS<Boolean> isSameRate(NonTransferableProduct product);

	protected abstract MapperS<Boolean> isSamePeriod(NonTransferableProduct product);

	public static class InterestRateLeg1FixedFixedDefault extends InterestRateLeg1FixedFixed {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1, NonTransferableProduct product) {
			if (areEqual(isSameRate(product), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(interestRatePayouts(product)
					.max(item -> item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification()).<RateSchedule>map("getRateSchedule", fixedRateSpecification -> fixedRateSpecification.getRateSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", rateSchedule -> rateSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).get());
			} else if (areEqual(isSamePeriod(product), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(interestRatePayouts(product)
					.min(item -> MapperS.of(calculationPeriodToDays.evaluate(item.get()))).get());
			} else {
				interestRateLeg1 = toBuilder(interestRatePayouts(product)
					.first().get());
			}
			
			return Optional.ofNullable(interestRateLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> interestRatePayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
		
		@Override
		protected MapperS<Boolean> isSameRate(NonTransferableProduct product) {
			return areEqual(MapperS.of(distinctIgnoringPrecision(interestRatePayouts(product).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification()).<RateSchedule>map("getRateSchedule", fixedRateSpecification -> fixedRateSpecification.getRateSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", rateSchedule -> rateSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).resultCount()), MapperS.of(1), CardinalityOperator.All).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> isSamePeriod(NonTransferableProduct product) {
			final MapperC<Integer> thenArg = interestRatePayouts(product)
				.mapItem(item -> MapperS.of(calculationPeriodToDays.evaluate(item.get())));
			return notExists(interestRatePayouts(product).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates())).orNullSafe(ComparisonResult.ofNullSafe(areEqual(MapperS.of(distinctIgnoringPrecision(thenArg).resultCount()), MapperS.of(1), CardinalityOperator.All).asMapper())).asMapper();
		}
	}
}
