package drr.regulation.common.functions;

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


@ImplementedBy(InterestRateLeg1CapFloor.InterestRateLeg1CapFloorDefault.class)
public abstract class InterestRateLeg1CapFloor implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
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

	public static class InterestRateLeg1CapFloorDefault extends InterestRateLeg1CapFloor {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1, NonTransferableProduct product) {
			interestRateLeg1 = toBuilder(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
			
			return Optional.ofNullable(interestRateLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
