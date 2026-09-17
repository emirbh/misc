package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCounterparty.MapCounterpartyDefault.class)
public abstract class MapCounterparty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;

	/**
	* @param cdmRole 
	* @param fpmlPartyReference 
	* @return counterparty 
	*/
	public Counterparty evaluate(CounterpartyRoleEnum cdmRole, PartyReference fpmlPartyReference) {
		Counterparty.CounterpartyBuilder counterpartyBuilder = doEvaluate(cdmRole, fpmlPartyReference);
		
		final Counterparty counterparty;
		if (counterpartyBuilder == null) {
			counterparty = null;
		} else {
			counterparty = counterpartyBuilder.build();
			objectValidator.validate(Counterparty.class, counterparty);
		}
		
		return counterparty;
	}

	protected abstract Counterparty.CounterpartyBuilder doEvaluate(CounterpartyRoleEnum cdmRole, PartyReference fpmlPartyReference);

	public static class MapCounterpartyDefault extends MapCounterparty {
		@Override
		protected Counterparty.CounterpartyBuilder doEvaluate(CounterpartyRoleEnum cdmRole, PartyReference fpmlPartyReference) {
			Counterparty.CounterpartyBuilder counterparty = Counterparty.builder();
			return assignOutput(counterparty, cdmRole, fpmlPartyReference);
		}
		
		protected Counterparty.CounterpartyBuilder assignOutput(Counterparty.CounterpartyBuilder counterparty, CounterpartyRoleEnum cdmRole, PartyReference fpmlPartyReference) {
			counterparty = toBuilder(Counterparty.builder()
				.setRole(cdmRole)
				.setPartyReference(mapPartyReference.evaluate(MapperS.of(fpmlPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
				.build());
			
			return Optional.ofNullable(counterparty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
