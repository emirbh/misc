package cdm.ingest.fpml.confirmation.product.equityforward.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.eqd.EquityForward;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityForwardPayout.MapEquityForwardPayoutDefault.class)
public abstract class MapEquityForwardPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlEquityForward 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlEquityForward, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquityForwardPayoutDefault extends MapEquityForwardPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlEquityForward, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
