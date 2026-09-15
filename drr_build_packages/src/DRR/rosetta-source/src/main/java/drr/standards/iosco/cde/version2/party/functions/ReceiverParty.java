package drr.standards.iosco.cde.version2.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ReceiverParty.ReceiverPartyDefault.class)
public abstract class ReceiverParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.party.functions.ReceiverParty receiverParty;

	/**
	* @param payout 
	* @param counterparties 
	* @return party 
	*/
	public Party evaluate(PayoutLegWithAuxiliary payout, List<? extends Counterparty> counterparties) {
		Party.PartyBuilder partyBuilder = doEvaluate(payout, counterparties);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(PayoutLegWithAuxiliary payout, List<? extends Counterparty> counterparties);

	public static class ReceiverPartyDefault extends ReceiverParty {
		@Override
		protected Party.PartyBuilder doEvaluate(PayoutLegWithAuxiliary payout, List<? extends Counterparty> counterparties) {
			if (counterparties == null) {
				counterparties = Collections.emptyList();
			}
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, payout, counterparties);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, PayoutLegWithAuxiliary payout, List<? extends Counterparty> counterparties) {
			party = toBuilder(receiverParty.evaluate(payout, counterparties));
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
