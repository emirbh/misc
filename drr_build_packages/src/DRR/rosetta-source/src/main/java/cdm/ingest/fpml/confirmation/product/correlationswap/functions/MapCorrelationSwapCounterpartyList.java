package cdm.ingest.fpml.confirmation.product.correlationswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationSwapCounterpartyList.MapCorrelationSwapCounterpartyListDefault.class)
public abstract class MapCorrelationSwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlCorrelationSwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(CorrelationSwap fpmlCorrelationSwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlCorrelationSwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(CorrelationSwap fpmlCorrelationSwap);

	public static class MapCorrelationSwapCounterpartyListDefault extends MapCorrelationSwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(CorrelationSwap fpmlCorrelationSwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlCorrelationSwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, CorrelationSwap fpmlCorrelationSwap) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<PartyReference>map("getPayerPartyReference", correlationLeg -> correlationLeg.getPayerPartyReference()).get(), MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<PartyReference>map("getReceiverPartyReference", correlationLeg -> correlationLeg.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
