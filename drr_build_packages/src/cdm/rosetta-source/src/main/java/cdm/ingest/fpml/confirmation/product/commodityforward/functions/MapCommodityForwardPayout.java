package cdm.ingest.fpml.confirmation.product.commodityforward.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityForward;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityForwardPayout.MapCommodityForwardPayoutDefault.class)
public abstract class MapCommodityForwardPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityForward 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlCommodityForward, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommodityForwardPayoutDefault extends MapCommodityForwardPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlCommodityForward, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
