package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPartyChangePayerReceiverModelToCounterparty.MapPartyChangePayerReceiverModelToCounterpartyDefault.class)
public abstract class MapPartyChangePayerReceiverModelToCounterparty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterparty mapCounterparty;

	/**
	* @param fpmlTransferee 
	* @param fpmlTransferor 
	* @param counterpartyList 
	* @return counterparty 
	*/
	public Counterparty evaluate(PartyReference fpmlTransferee, PartyReference fpmlTransferor, List<? extends Counterparty> counterpartyList) {
		Counterparty.CounterpartyBuilder counterpartyBuilder = doEvaluate(fpmlTransferee, fpmlTransferor, counterpartyList);
		
		final Counterparty counterparty;
		if (counterpartyBuilder == null) {
			counterparty = null;
		} else {
			counterparty = counterpartyBuilder.build();
			objectValidator.validate(Counterparty.class, counterparty);
		}
		
		return counterparty;
	}

	protected abstract Counterparty.CounterpartyBuilder doEvaluate(PartyReference fpmlTransferee, PartyReference fpmlTransferor, List<? extends Counterparty> counterpartyList);

	protected abstract MapperS<CounterpartyRoleEnum> transferorRole(PartyReference fpmlTransferee, PartyReference fpmlTransferor, List<? extends Counterparty> counterpartyList);

	public static class MapPartyChangePayerReceiverModelToCounterpartyDefault extends MapPartyChangePayerReceiverModelToCounterparty {
		@Override
		protected Counterparty.CounterpartyBuilder doEvaluate(PartyReference fpmlTransferee, PartyReference fpmlTransferor, List<? extends Counterparty> counterpartyList) {
			if (counterpartyList == null) {
				counterpartyList = Collections.emptyList();
			}
			Counterparty.CounterpartyBuilder counterparty = Counterparty.builder();
			return assignOutput(counterparty, fpmlTransferee, fpmlTransferor, counterpartyList);
		}
		
		protected Counterparty.CounterpartyBuilder assignOutput(Counterparty.CounterpartyBuilder counterparty, PartyReference fpmlTransferee, PartyReference fpmlTransferor, List<? extends Counterparty> counterpartyList) {
			counterparty = toBuilder(mapCounterparty.evaluate(transferorRole(fpmlTransferee, fpmlTransferor, counterpartyList).get(), fpmlTransferee));
			
			return Optional.ofNullable(counterparty)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<CounterpartyRoleEnum> transferorRole(PartyReference fpmlTransferee, PartyReference fpmlTransferor, List<? extends Counterparty> counterpartyList) {
			final MapperC<Counterparty> thenArg0 = MapperC.<Counterparty>of(counterpartyList);
			final MapperC<Counterparty> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).map("getReference", a->a.getExternalReference()), MapperS.of(fpmlTransferor).<String>map("getHref", partyReference -> partyReference.getHref()), CardinalityOperator.All).get());
			return MapperS.of(thenArg1.<CounterpartyRoleEnum>map("getRole", counterparty -> counterparty.getRole()).get());
		}
	}
}
