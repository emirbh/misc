package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapReturnSwapCounterpartyList.MapReturnSwapCounterpartyListDefault.class)
public abstract class MapReturnSwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlReturnSwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(ReturnSwap fpmlReturnSwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlReturnSwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(ReturnSwap fpmlReturnSwap);

	public static class MapReturnSwapCounterpartyListDefault extends MapReturnSwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(ReturnSwap fpmlReturnSwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlReturnSwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, ReturnSwap fpmlReturnSwap) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg())
				.first().<PartyReference>map("getPayerPartyReference", directionalLeg -> directionalLeg.getPayerPartyReference()).get(), MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg())
				.first().<PartyReference>map("getReceiverPartyReference", directionalLeg -> directionalLeg.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
