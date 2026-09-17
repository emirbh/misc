package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPayerReceiverModelToCounterpartyList.MapPayerReceiverModelToCounterpartyListDefault.class)
public abstract class MapPayerReceiverModelToCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterparty mapCounterparty;

	/**
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlPayerPartyReference, fpmlReceiverPartyReference);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference);

	public static class MapPayerReceiverModelToCounterpartyListDefault extends MapPayerReceiverModelToCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlPayerPartyReference, fpmlReceiverPartyReference);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			final Counterparty counterparty0 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_1, fpmlPayerPartyReference);
			if (counterparty0 == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else {
				counterpartyList.addAll(toBuilder(Collections.singletonList(counterparty0)));
			}
			
			final Counterparty counterparty1 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_2, fpmlReceiverPartyReference);
			if (counterparty1 == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else {
				counterpartyList.addAll(toBuilder(Collections.singletonList(counterparty1)));
			}
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
