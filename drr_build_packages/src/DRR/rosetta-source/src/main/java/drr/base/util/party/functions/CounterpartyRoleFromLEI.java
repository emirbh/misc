package drr.base.util.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CounterpartyRoleFromLEI.CounterpartyRoleFromLEIDefault.class)
public abstract class CounterpartyRoleFromLEI implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected PartyLei partyLei;

	/**
	* @param counterparties 
	* @param _partyLei 
	* @return reportingParty 
	*/
	public CounterpartyRoleEnum evaluate(List<? extends Counterparty> counterparties, String _partyLei) {
		CounterpartyRoleEnum reportingParty = doEvaluate(counterparties, _partyLei);
		
		return reportingParty;
	}

	protected abstract CounterpartyRoleEnum doEvaluate(List<? extends Counterparty> counterparties, String _partyLei);

	protected abstract MapperS<? extends Counterparty> party1(List<? extends Counterparty> counterparties, String _partyLei);

	protected abstract MapperS<? extends Counterparty> party2(List<? extends Counterparty> counterparties, String _partyLei);

	public static class CounterpartyRoleFromLEIDefault extends CounterpartyRoleFromLEI {
		@Override
		protected CounterpartyRoleEnum doEvaluate(List<? extends Counterparty> counterparties, String _partyLei) {
			if (counterparties == null) {
				counterparties = Collections.emptyList();
			}
			CounterpartyRoleEnum reportingParty = null;
			return assignOutput(reportingParty, counterparties, _partyLei);
		}
		
		protected CounterpartyRoleEnum assignOutput(CounterpartyRoleEnum reportingParty, List<? extends Counterparty> counterparties, String _partyLei) {
			if (areEqual(MapperS.of(_partyLei), MapperS.of(partyLei.evaluate(party1(counterparties, _partyLei).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti())), CardinalityOperator.All).getOrDefault(false)) {
				reportingParty = CounterpartyRoleEnum.PARTY_1;
			} else if (areEqual(MapperS.of(_partyLei), MapperS.of(partyLei.evaluate(party2(counterparties, _partyLei).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti())), CardinalityOperator.All).getOrDefault(false)) {
				reportingParty = CounterpartyRoleEnum.PARTY_2;
			} else {
				reportingParty = null;
			}
			
			return reportingParty;
		}
		
		@Override
		protected MapperS<? extends Counterparty> party1(List<? extends Counterparty> counterparties, String _partyLei) {
			return MapperS.of(extractCounterpartyByRole.evaluate(counterparties, CounterpartyRoleEnum.PARTY_1));
		}
		
		@Override
		protected MapperS<? extends Counterparty> party2(List<? extends Counterparty> counterparties, String _partyLei) {
			return MapperS.of(extractCounterpartyByRole.evaluate(counterparties, CounterpartyRoleEnum.PARTY_2));
		}
	}
}
