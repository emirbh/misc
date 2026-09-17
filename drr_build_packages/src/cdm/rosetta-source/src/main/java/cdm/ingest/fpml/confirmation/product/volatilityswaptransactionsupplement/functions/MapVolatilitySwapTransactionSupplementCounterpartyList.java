package cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapTransactionSupplementCounterpartyList.MapVolatilitySwapTransactionSupplementCounterpartyListDefault.class)
public abstract class MapVolatilitySwapTransactionSupplementCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlVolatilitySwapTransactionSupplement 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlVolatilitySwapTransactionSupplement);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement);

	public static class MapVolatilitySwapTransactionSupplementCounterpartyListDefault extends MapVolatilitySwapTransactionSupplementCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlVolatilitySwapTransactionSupplement);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlVolatilitySwapTransactionSupplement).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getVolatilityLeg())
				.first().<PartyReference>map("getPayerPartyReference", volatilityLeg -> volatilityLeg.getPayerPartyReference()).get(), MapperS.of(fpmlVolatilitySwapTransactionSupplement).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getVolatilityLeg())
				.first().<PartyReference>map("getReceiverPartyReference", volatilityLeg -> volatilityLeg.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
