package drr.regulation.csa.rewrite.trade.functions;

import cdm.product.asset.FixedRateSpecification;
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
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateLeg1CrossCurrency.InterestRateLeg1CrossCurrencyDefault.class)
public abstract class InterestRateLeg1CrossCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg1Basis interestRateLeg1Basis;
	@Inject protected drr.regulation.common.functions.InterestRateLeg1CrossCurrency interestRateLeg1CrossCurrency;

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

	protected abstract MapperC<? extends InterestRatePayout> floatingRateLegs(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> fixedRateLegs(NonTransferableProduct product);

	protected abstract MapperS<? extends InterestRatePayout> csaInterestRateLeg1Basis(NonTransferableProduct product);

	protected abstract MapperS<? extends InterestRatePayout> drrInterestRateLeg1CrossCurrency(NonTransferableProduct product);

	public static class InterestRateLeg1CrossCurrencyDefault extends InterestRateLeg1CrossCurrency {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1, NonTransferableProduct product) {
			if (areEqual(MapperS.of(floatingRateLegs(product).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(fixedRateLegs(product).get());
			} else if (greaterThan(MapperS.of(floatingRateLegs(product).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(csaInterestRateLeg1Basis(product).get());
			} else {
				interestRateLeg1 = toBuilder(drrInterestRateLeg1CrossCurrency(product).get());
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
		protected MapperC<? extends InterestRatePayout> floatingRateLegs(NonTransferableProduct product) {
			return interestRatePayouts(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> fixedRateLegs(NonTransferableProduct product) {
			return interestRatePayouts(product)
				.filterItemNullSafe(leg -> exists(leg.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> csaInterestRateLeg1Basis(NonTransferableProduct product) {
			return MapperS.of(interestRateLeg1Basis.evaluate(product));
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> drrInterestRateLeg1CrossCurrency(NonTransferableProduct product) {
			return MapperS.of(interestRateLeg1CrossCurrency.evaluate(product));
		}
	}
}
