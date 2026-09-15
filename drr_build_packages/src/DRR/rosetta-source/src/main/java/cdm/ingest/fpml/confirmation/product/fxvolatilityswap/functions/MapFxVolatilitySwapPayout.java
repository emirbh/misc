package cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions.MapFxVarianceSwapPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.fx.FxVolatilitySwap;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxVolatilitySwapPayout.MapFxVolatilitySwapPayoutDefault.class)
public abstract class MapFxVolatilitySwapPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxVarianceSwapPayout mapFxVarianceSwapPayout;
	@Inject protected MapFxVolatilitySwapReturnTerms mapFxVolatilitySwapReturnTerms;

	/**
	* @param fpmlFxVolatilitySwap 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFxVolatilitySwap, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxVolatilitySwapPayoutDefault extends MapFxVolatilitySwapPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFxVolatilitySwap, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(mapFxVarianceSwapPayout.evaluate(fpmlFxVolatilitySwap, mapFxVolatilitySwapReturnTerms.evaluate(fpmlFxVolatilitySwap), cdmCounterpartyList));
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
