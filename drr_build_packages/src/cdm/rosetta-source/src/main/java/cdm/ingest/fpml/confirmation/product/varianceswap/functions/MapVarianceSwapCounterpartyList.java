package cdm.ingest.fpml.confirmation.product.varianceswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.VarianceSwap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVarianceSwapCounterpartyList.MapVarianceSwapCounterpartyListDefault.class)
public abstract class MapVarianceSwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlVarianceSwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(VarianceSwap fpmlVarianceSwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlVarianceSwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(VarianceSwap fpmlVarianceSwap);

	public static class MapVarianceSwapCounterpartyListDefault extends MapVarianceSwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(VarianceSwap fpmlVarianceSwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlVarianceSwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, VarianceSwap fpmlVarianceSwap) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg())
				.first().<PartyReference>map("getPayerPartyReference", varianceLeg -> varianceLeg.getPayerPartyReference()).get(), MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg())
				.first().<PartyReference>map("getReceiverPartyReference", varianceLeg -> varianceLeg.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
