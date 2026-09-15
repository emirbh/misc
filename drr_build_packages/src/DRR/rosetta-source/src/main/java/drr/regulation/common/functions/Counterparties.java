package drr.regulation.common.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Trade;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(Counterparties.CounterpartiesDefault.class)
public abstract class Counterparties implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param trade 
	* @return counterparties 
	*/
	public List<? extends Party> evaluate(Trade trade) {
		List<Party.PartyBuilder> counterpartiesBuilder = doEvaluate(trade);
		
		final List<? extends Party> counterparties;
		if (counterpartiesBuilder == null) {
			counterparties = null;
		} else {
			counterparties = counterpartiesBuilder.stream().map(Party::build).collect(Collectors.toList());
			objectValidator.validate(Party.class, counterparties);
		}
		
		return counterparties;
	}

	protected abstract List<Party.PartyBuilder> doEvaluate(Trade trade);

	public static class CounterpartiesDefault extends Counterparties {
		@Override
		protected List<Party.PartyBuilder> doEvaluate(Trade trade) {
			List<Party.PartyBuilder> counterparties = new ArrayList<>();
			return assignOutput(counterparties, trade);
		}
		
		protected List<Party.PartyBuilder> assignOutput(List<Party.PartyBuilder> counterparties, Trade trade) {
			counterparties.addAll(toBuilder(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty.getValue()).getMulti()));
			
			return Optional.ofNullable(counterparties)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
