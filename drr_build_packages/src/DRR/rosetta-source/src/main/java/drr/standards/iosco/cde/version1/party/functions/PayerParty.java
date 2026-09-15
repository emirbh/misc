package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PayerParty.PayerPartyDefault.class)
public abstract class PayerParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected PayerReceiverFromPayout payerReceiverFromPayout;

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

	public static class PayerPartyDefault extends PayerParty {
		@Override
		protected Party.PartyBuilder doEvaluate(PayoutLegWithAuxiliary payout, List<? extends Counterparty> counterparties) {
			if (counterparties == null) {
				counterparties = Collections.emptyList();
			}
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, payout, counterparties);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, PayoutLegWithAuxiliary payout, List<? extends Counterparty> counterparties) {
			final ReferenceWithMetaParty referenceWithMetaParty = MapperS.of(extractCounterpartyByRole.evaluate(counterparties, MapperS.of(payerReceiverFromPayout.evaluate(payout)).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			if (referenceWithMetaParty == null) {
				party = null;
			} else {
				party = toBuilder(referenceWithMetaParty.getValue());
			}
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
