package drr.base.qualification.product.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(InterestRateReturnSwap.InterestRateReturnSwapDefault.class)
public abstract class InterestRateReturnSwap implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;

	/**
	* @param product 
	* @return interestRatePayout 
	*/
	public InterestRatePayout evaluate(NonTransferableProduct product) {
		InterestRatePayout.InterestRatePayoutBuilder interestRatePayoutBuilder = doEvaluate(product);
		
		final InterestRatePayout interestRatePayout;
		if (interestRatePayoutBuilder == null) {
			interestRatePayout = null;
		} else {
			interestRatePayout = interestRatePayoutBuilder.build();
			objectValidator.validate(InterestRatePayout.class, interestRatePayout);
		}
		
		return interestRatePayout;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product);

	public static class InterestRateReturnSwapDefault extends InterestRateReturnSwap {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRatePayout = InterestRatePayout.builder();
			return assignOutput(interestRatePayout, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRatePayout, NonTransferableProduct product) {
			interestRatePayout = toBuilder(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
			
			return Optional.ofNullable(interestRatePayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
