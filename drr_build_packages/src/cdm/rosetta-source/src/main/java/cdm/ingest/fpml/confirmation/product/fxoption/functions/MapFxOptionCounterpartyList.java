package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxOptionCounterpartyList.MapFxOptionCounterpartyListDefault.class)
public abstract class MapFxOptionCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlFxOption 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(FxOption fpmlFxOption) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlFxOption);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(FxOption fpmlFxOption);

	public static class MapFxOptionCounterpartyListDefault extends MapFxOptionCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(FxOption fpmlFxOption) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlFxOption);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, FxOption fpmlFxOption) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlFxOption).<PartyReference>map("getBuyerPartyReference", fxOption -> fxOption.getBuyerPartyReference()).get(), MapperS.of(fpmlFxOption).<PartyReference>map("getSellerPartyReference", fxOption -> fxOption.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
