package cdm.ingest.fpml.confirmation.product.commodityforward.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityForward;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityForwardEconomicTerms.MapCommodityForwardEconomicTermsDefault.class)
public abstract class MapCommodityForwardEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityForwardPayout mapCommodityForwardPayout;

	/**
	* @param fpmlCommodityForward 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlCommodityForward, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommodityForwardEconomicTermsDefault extends MapCommodityForwardEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlCommodityForward, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, CommodityForward fpmlCommodityForward, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapCommodityForwardPayout.evaluate(fpmlCommodityForward, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
