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


@ImplementedBy(InterestRateLeg2.InterestRateLeg2Default.class)
public abstract class InterestRateLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.functions.InterestRateLeg2 interestRateLeg2;
	@Inject protected InterestRateLeg2Basis interestRateLeg2Basis;
	@Inject protected InterestRateLeg2CrossCurrency interestRateLeg2CrossCurrency;
	@Inject protected InterestRateLeg2ReturnSwap interestRateLeg2ReturnSwap;
	@Inject protected IsInterestRateBasis isInterestRateBasis;
	@Inject protected IsInterestRateCrossCurrency isInterestRateCrossCurrency;
	@Inject protected IsInterestRateReturnSwap isInterestRateReturnSwap;

	/**
	* @param product 
	* @return _interestRateLeg2 
	*/
	public InterestRatePayout evaluate(NonTransferableProduct product) {
		InterestRatePayout.InterestRatePayoutBuilder interestRateLeg2Builder = doEvaluate(product);
		
		final InterestRatePayout _interestRateLeg2;
		if (interestRateLeg2Builder == null) {
			_interestRateLeg2 = null;
		} else {
			_interestRateLeg2 = interestRateLeg2Builder.build();
			objectValidator.validate(InterestRatePayout.class, _interestRateLeg2);
		}
		
		return _interestRateLeg2;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product);

	public static class InterestRateLeg2Default extends InterestRateLeg2 {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder _interestRateLeg2 = InterestRatePayout.builder();
			return assignOutput(_interestRateLeg2, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder _interestRateLeg2, NonTransferableProduct product) {
			final Boolean boolean0 = isInterestRateBasis.evaluate(product);
			if ((boolean0 == null ? false : boolean0)) {
				_interestRateLeg2 = toBuilder(interestRateLeg2Basis.evaluate(product));
			} else {
				final Boolean boolean1 = isInterestRateCrossCurrency.evaluate(product);
				if ((boolean1 == null ? false : boolean1)) {
					_interestRateLeg2 = toBuilder(interestRateLeg2CrossCurrency.evaluate(product));
				} else {
					final Boolean boolean2 = isInterestRateReturnSwap.evaluate(product);
					if ((boolean2 == null ? false : boolean2)) {
						_interestRateLeg2 = toBuilder(interestRateLeg2ReturnSwap.evaluate(product));
					} else {
						_interestRateLeg2 = toBuilder(interestRateLeg2.evaluate(product));
					}
				}
			}
			
			return Optional.ofNullable(_interestRateLeg2)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
