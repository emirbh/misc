package drr.regulation.common.trade.payment.functions;

import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRatePayoutFromPayout.InterestRatePayoutFromPayoutDefault.class)
public abstract class InterestRatePayoutFromPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

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

	public static class InterestRatePayoutFromPayoutDefault extends InterestRatePayoutFromPayout {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(PayoutLegWithAuxiliary payout) {
			InterestRatePayout.InterestRatePayoutBuilder interestRatePayout = InterestRatePayout.builder();
			return assignOutput(interestRatePayout, payout);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRatePayout, PayoutLegWithAuxiliary payout) {
			interestRatePayout = toBuilder(MapperS.of(payout)
				.mapSingleToItem(item -> {
					if (exists(item.<CreditDefaultPayout>map("getCreditDefaultPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCreditDefaultPayout())).getOrDefault(false)) {
						return item.<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<InterestRatePayout>map("getInterestRatePayout", payoutLeg -> payoutLeg.getInterestRatePayout());
					}
					if (exists(item.<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout())).andNullSafe(notExists(item.<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<InterestRatePayout>map("getInterestRatePayout", payoutLeg -> payoutLeg.getInterestRatePayout()))).getOrDefault(false)) {
						return item.<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout());
					}
					return MapperS.<InterestRatePayout>ofNull();
				}).get());
			
			return Optional.ofNullable(interestRatePayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
