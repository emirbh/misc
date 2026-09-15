package cdm.ingest.fpml.confirmation.product.capfloor.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCapFloorCounterpartyList.MapCapFloorCounterpartyListDefault.class)
public abstract class MapCapFloorCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlCapFloor 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(CapFloor fpmlCapFloor) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlCapFloor);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(CapFloor fpmlCapFloor);

	public static class MapCapFloorCounterpartyListDefault extends MapCapFloorCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(CapFloor fpmlCapFloor) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlCapFloor);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, CapFloor fpmlCapFloor) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlCapFloor).<InterestRateStream>map("getCapFloorStream", capFloor -> capFloor.getCapFloorStream()).<PartyReference>map("getPayerPartyReference", interestRateStream -> interestRateStream.getPayerPartyReference()).get(), MapperS.of(fpmlCapFloor).<InterestRateStream>map("getCapFloorStream", capFloor -> capFloor.getCapFloorStream()).<PartyReference>map("getReceiverPartyReference", interestRateStream -> interestRateStream.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
