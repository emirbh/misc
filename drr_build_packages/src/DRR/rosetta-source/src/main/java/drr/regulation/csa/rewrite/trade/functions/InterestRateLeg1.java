package drr.regulation.csa.rewrite.trade.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.qualification.product.functions.IsInterestRateBasis;
import drr.base.qualification.product.functions.IsInterestRateCrossCurrency;
import drr.base.qualification.product.functions.IsInterestRateReturnSwap;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(InterestRateLeg1.InterestRateLeg1Default.class)
public abstract class InterestRateLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.functions.InterestRateLeg1 interestRateLeg1;
	@Inject protected InterestRateLeg1Basis interestRateLeg1Basis;
	@Inject protected InterestRateLeg1CrossCurrency interestRateLeg1CrossCurrency;
	@Inject protected InterestRateLeg1ReturnSwap interestRateLeg1ReturnSwap;
	@Inject protected IsInterestRateBasis isInterestRateBasis;
	@Inject protected IsInterestRateCrossCurrency isInterestRateCrossCurrency;
	@Inject protected IsInterestRateReturnSwap isInterestRateReturnSwap;

	/**
	* @param product 
	* @return _interestRateLeg1 
	*/
	public InterestRatePayout evaluate(NonTransferableProduct product) {
		InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1Builder = doEvaluate(product);
		
		final InterestRatePayout _interestRateLeg1;
		if (interestRateLeg1Builder == null) {
			_interestRateLeg1 = null;
		} else {
			_interestRateLeg1 = interestRateLeg1Builder.build();
			objectValidator.validate(InterestRatePayout.class, _interestRateLeg1);
		}
		
		return _interestRateLeg1;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product);

	public static class InterestRateLeg1Default extends InterestRateLeg1 {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder _interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(_interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder _interestRateLeg1, NonTransferableProduct product) {
			final Boolean boolean0 = isInterestRateBasis.evaluate(product);
			if ((boolean0 == null ? false : boolean0)) {
				_interestRateLeg1 = toBuilder(interestRateLeg1Basis.evaluate(product));
			} else {
				final Boolean boolean1 = isInterestRateCrossCurrency.evaluate(product);
				if ((boolean1 == null ? false : boolean1)) {
					_interestRateLeg1 = toBuilder(interestRateLeg1CrossCurrency.evaluate(product));
				} else {
					final Boolean boolean2 = isInterestRateReturnSwap.evaluate(product);
					if ((boolean2 == null ? false : boolean2)) {
						_interestRateLeg1 = toBuilder(interestRateLeg1ReturnSwap.evaluate(product));
					} else {
						_interestRateLeg1 = toBuilder(interestRateLeg1.evaluate(product));
					}
				}
			}
			
			return Optional.ofNullable(_interestRateLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
