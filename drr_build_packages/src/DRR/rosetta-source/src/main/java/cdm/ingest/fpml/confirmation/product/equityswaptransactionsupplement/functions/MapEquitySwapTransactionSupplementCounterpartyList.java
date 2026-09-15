package cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEquitySwapTransactionSupplementCounterpartyList.MapEquitySwapTransactionSupplementCounterpartyListDefault.class)
public abstract class MapEquitySwapTransactionSupplementCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlEquitySwapTransactionSupplement 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlEquitySwapTransactionSupplement);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement);

	public static class MapEquitySwapTransactionSupplementCounterpartyListDefault extends MapEquitySwapTransactionSupplementCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlEquitySwapTransactionSupplement);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlEquitySwapTransactionSupplement).<DirectionalLeg>mapC("getReturnSwapLeg", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getReturnSwapLeg())
				.first().<PartyReference>map("getPayerPartyReference", directionalLeg -> directionalLeg.getPayerPartyReference()).get(), MapperS.of(fpmlEquitySwapTransactionSupplement).<DirectionalLeg>mapC("getReturnSwapLeg", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getReturnSwapLeg())
				.first().<PartyReference>map("getReceiverPartyReference", directionalLeg -> directionalLeg.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
