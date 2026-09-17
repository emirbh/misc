package cdm.ingest.fpml.confirmation.product.fxdigitaloption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxDigitalOptionCounterpartyList.MapFxDigitalOptionCounterpartyListDefault.class)
public abstract class MapFxDigitalOptionCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlFxDigitalOption 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(FxDigitalOption fpmlFxDigitalOption) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlFxDigitalOption);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(FxDigitalOption fpmlFxDigitalOption);

	public static class MapFxDigitalOptionCounterpartyListDefault extends MapFxDigitalOptionCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(FxDigitalOption fpmlFxDigitalOption) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlFxDigitalOption);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, FxDigitalOption fpmlFxDigitalOption) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getBuyerPartyReference", fxDigitalOption -> fxDigitalOption.getBuyerPartyReference()).get(), MapperS.of(fpmlFxDigitalOption).<PartyReference>map("getSellerPartyReference", fxDigitalOption -> fxDigitalOption.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
