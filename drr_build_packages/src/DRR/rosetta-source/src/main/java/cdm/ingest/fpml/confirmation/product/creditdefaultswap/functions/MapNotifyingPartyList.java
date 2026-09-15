package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.option.shared.NotifyingParty;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(MapNotifyingPartyList.MapNotifyingPartyListDefault.class)
public abstract class MapNotifyingPartyList implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;

	/**
	* @param fpmlNotifyingParty 
	* @param cdmCounterpartyList 
	* @return notifyingPartyList 
	*/
	public List<CounterpartyRoleEnum> evaluate(NotifyingParty fpmlNotifyingParty, List<? extends Counterparty> cdmCounterpartyList) {
		List<CounterpartyRoleEnum> notifyingPartyList = doEvaluate(fpmlNotifyingParty, cdmCounterpartyList);
		
		return notifyingPartyList;
	}

	protected abstract List<CounterpartyRoleEnum> doEvaluate(NotifyingParty fpmlNotifyingParty, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapNotifyingPartyListDefault extends MapNotifyingPartyList {
		@Override
		protected List<CounterpartyRoleEnum> doEvaluate(NotifyingParty fpmlNotifyingParty, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<CounterpartyRoleEnum> notifyingPartyList = new ArrayList<>();
			return assignOutput(notifyingPartyList, fpmlNotifyingParty, cdmCounterpartyList);
		}
		
		protected List<CounterpartyRoleEnum> assignOutput(List<CounterpartyRoleEnum> notifyingPartyList, NotifyingParty fpmlNotifyingParty, List<? extends Counterparty> cdmCounterpartyList) {
			final CounterpartyRoleEnum counterpartyRoleEnum0 = mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlNotifyingParty).<PartyReference>map("getBuyerPartyReference", notifyingParty -> notifyingParty.getBuyerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList);
			if (counterpartyRoleEnum0 == null) {
				notifyingPartyList.addAll(Collections.<CounterpartyRoleEnum>emptyList());
			} else {
				notifyingPartyList.addAll(Collections.singletonList(counterpartyRoleEnum0));
			}
			
			final CounterpartyRoleEnum counterpartyRoleEnum1 = mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlNotifyingParty).<PartyReference>map("getSellerPartyReference", notifyingParty -> notifyingParty.getSellerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList);
			if (counterpartyRoleEnum1 == null) {
				notifyingPartyList.addAll(Collections.<CounterpartyRoleEnum>emptyList());
			} else {
				notifyingPartyList.addAll(Collections.singletonList(counterpartyRoleEnum1));
			}
			
			return notifyingPartyList;
		}
	}
}
