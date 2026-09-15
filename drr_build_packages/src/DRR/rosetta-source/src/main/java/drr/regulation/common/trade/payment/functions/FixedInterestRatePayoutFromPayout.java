package drr.regulation.common.trade.payment.functions;

import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FixedInterestRatePayoutFromPayout.FixedInterestRatePayoutFromPayoutDefault.class)
public abstract class FixedInterestRatePayoutFromPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected InterestRatePayoutFromPayout interestRatePayoutFromPayout;

	/**
	* @param payout 
	* @return interestRatePayout 
	*/
	public InterestRatePayout evaluate(PayoutLegWithAuxiliary payout) {
		InterestRatePayout.InterestRatePayoutBuilder interestRatePayoutBuilder = doEvaluate(payout);
		
		final InterestRatePayout interestRatePayout;
		if (interestRatePayoutBuilder == null) {
			interestRatePayout = null;
		} else {
			interestRatePayout = interestRatePayoutBuilder.build();
			objectValidator.validate(InterestRatePayout.class, interestRatePayout);
		}
		
		return interestRatePayout;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(PayoutLegWithAuxiliary payout);

	public static class FixedInterestRatePayoutFromPayoutDefault extends FixedInterestRatePayoutFromPayout {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(PayoutLegWithAuxiliary payout) {
			InterestRatePayout.InterestRatePayoutBuilder interestRatePayout = InterestRatePayout.builder();
			return assignOutput(interestRatePayout, payout);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRatePayout, PayoutLegWithAuxiliary payout) {
			final MapperS<InterestRatePayout> thenArg = MapperS.of(interestRatePayoutFromPayout.evaluate(payout));
			interestRatePayout = toBuilder(thenArg
				.filterSingleNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get()).get());
			
			return Optional.ofNullable(interestRatePayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
