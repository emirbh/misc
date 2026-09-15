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

@ImplementedBy(InterestRateLeg2CrossCurrency.InterestRateLeg2CrossCurrencyDefault.class)
public abstract class InterestRateLeg2CrossCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg2Basis interestRateLeg2Basis;
	@Inject protected drr.regulation.common.functions.InterestRateLeg2CrossCurrency interestRateLeg2CrossCurrency;

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

	protected abstract MapperC<? extends InterestRatePayout> floatingRateLegs(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> fixedRateLegs(NonTransferableProduct product);

	protected abstract MapperS<? extends InterestRatePayout> csaInterestRateLeg2Basis(NonTransferableProduct product);

	protected abstract MapperS<? extends InterestRatePayout> drrInterestRateLeg2CrossCurrency(NonTransferableProduct product);

	public static class InterestRateLeg2CrossCurrencyDefault extends InterestRateLeg2CrossCurrency {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg2, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2, NonTransferableProduct product) {
			if (areEqual(MapperS.of(floatingRateLegs(product).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg2 = toBuilder(floatingRateLegs(product).get());
			} else if (greaterThan(MapperS.of(floatingRateLegs(product).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				interestRateLeg2 = toBuilder(csaInterestRateLeg2Basis(product).get());
			} else {
				interestRateLeg2 = toBuilder(drrInterestRateLeg2CrossCurrency(product).get());
			}
			
			return Optional.ofNullable(interestRateLeg2)
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
		protected MapperS<? extends InterestRatePayout> csaInterestRateLeg2Basis(NonTransferableProduct product) {
			return MapperS.of(interestRateLeg2Basis.evaluate(product));
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> drrInterestRateLeg2CrossCurrency(NonTransferableProduct product) {
			return MapperS.of(interestRateLeg2CrossCurrency.evaluate(product));
		}
	}
}
