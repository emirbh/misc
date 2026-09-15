package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapCounterpartyList.MapVolatilitySwapCounterpartyListDefault.class)
public abstract class MapVolatilitySwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlVolatilitySwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(VolatilitySwap fpmlVolatilitySwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlVolatilitySwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(VolatilitySwap fpmlVolatilitySwap);

	public static class MapVolatilitySwapCounterpartyListDefault extends MapVolatilitySwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(VolatilitySwap fpmlVolatilitySwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlVolatilitySwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, VolatilitySwap fpmlVolatilitySwap) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlVolatilitySwap).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwap -> volatilitySwap.getVolatilityLeg())
				.first().<PartyReference>map("getPayerPartyReference", volatilityLeg -> volatilityLeg.getPayerPartyReference()).get(), MapperS.of(fpmlVolatilitySwap).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwap -> volatilitySwap.getVolatilityLeg())
				.first().<PartyReference>map("getReceiverPartyReference", volatilityLeg -> volatilityLeg.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
