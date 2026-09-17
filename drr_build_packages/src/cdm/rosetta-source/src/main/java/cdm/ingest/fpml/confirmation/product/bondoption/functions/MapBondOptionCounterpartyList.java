package cdm.ingest.fpml.confirmation.product.bondoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapBondOptionCounterpartyList.MapBondOptionCounterpartyListDefault.class)
public abstract class MapBondOptionCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlBondOption 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(BondOption fpmlBondOption) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlBondOption);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(BondOption fpmlBondOption);

	public static class MapBondOptionCounterpartyListDefault extends MapBondOptionCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(BondOption fpmlBondOption) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlBondOption);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, BondOption fpmlBondOption) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlBondOption).<PartyReference>map("getBuyerPartyReference", bondOption -> bondOption.getBuyerPartyReference()).get(), MapperS.of(fpmlBondOption).<PartyReference>map("getSellerPartyReference", bondOption -> bondOption.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
