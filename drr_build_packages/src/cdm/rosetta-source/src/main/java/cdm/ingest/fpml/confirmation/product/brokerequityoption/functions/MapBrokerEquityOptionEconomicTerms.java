package cdm.ingest.fpml.confirmation.product.brokerequityoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.eqd.BrokerEquityOption;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBrokerEquityOptionEconomicTerms.MapBrokerEquityOptionEconomicTermsDefault.class)
public abstract class MapBrokerEquityOptionEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBrokerEquityOptionPayout mapBrokerEquityOptionPayout;

	/**
	* @param fpmlBrokerEquityOption 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlBrokerEquityOption, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapBrokerEquityOptionEconomicTermsDefault extends MapBrokerEquityOptionEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlBrokerEquityOption, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapBrokerEquityOptionPayout.evaluate(fpmlBrokerEquityOption, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
