package cdm.ingest.fpml.confirmation.product.brokerequityoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.BrokerEquityOption;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapBrokerEquityOptionCounterpartyList.MapBrokerEquityOptionCounterpartyListDefault.class)
public abstract class MapBrokerEquityOptionCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlBrokerEquityOption 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(BrokerEquityOption fpmlBrokerEquityOption) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlBrokerEquityOption);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(BrokerEquityOption fpmlBrokerEquityOption);

	public static class MapBrokerEquityOptionCounterpartyListDefault extends MapBrokerEquityOptionCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(BrokerEquityOption fpmlBrokerEquityOption) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlBrokerEquityOption);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, BrokerEquityOption fpmlBrokerEquityOption) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getBuyerPartyReference", brokerEquityOption -> brokerEquityOption.getBuyerPartyReference()).get(), MapperS.of(fpmlBrokerEquityOption).<PartyReference>map("getSellerPartyReference", brokerEquityOption -> brokerEquityOption.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
