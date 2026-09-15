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


@ImplementedBy(MapBuyerSellerModelToCounterpartyList.MapBuyerSellerModelToCounterpartyListDefault.class)
public abstract class MapBuyerSellerModelToCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterparty mapCounterparty;

	/**
	* @param fpmlBuyerPartyReference 
	* @param fpmlSellerPartyReference 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlBuyerPartyReference, fpmlSellerPartyReference);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference);

	public static class MapBuyerSellerModelToCounterpartyListDefault extends MapBuyerSellerModelToCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlBuyerPartyReference, fpmlSellerPartyReference);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference) {
			final Counterparty counterparty0 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_1, fpmlBuyerPartyReference);
			if (counterparty0 == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else {
				counterpartyList.addAll(toBuilder(Collections.singletonList(counterparty0)));
			}
			
			final Counterparty counterparty1 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_2, fpmlSellerPartyReference);
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
