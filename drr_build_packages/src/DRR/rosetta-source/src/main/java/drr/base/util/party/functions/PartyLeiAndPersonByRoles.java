package drr.base.util.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PartyLeiAndPersonByRoles.PartyLeiAndPersonByRolesDefault.class)
public abstract class PartyLeiAndPersonByRoles implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected NaturalPersonBuyerOrSeller naturalPersonBuyerOrSeller;
	@Inject protected PartyLei partyLei0;

	/**
	* @param party 
	* @param reportingParty 
	* @return partyPersonLei 
	*/
	public String evaluate(Party party, Party reportingParty) {
		String partyPersonLei = doEvaluate(party, reportingParty);
		
		return partyPersonLei;
	}

	protected abstract String doEvaluate(Party party, Party reportingParty);

	protected abstract MapperS<String> partyLei1(Party party, Party reportingParty);

	protected abstract MapperC<? extends FieldWithMetaString> partyPersonId(Party party, Party reportingParty);

	protected abstract MapperS<String> reportingPartyLei(Party party, Party reportingParty);

	public static class PartyLeiAndPersonByRolesDefault extends PartyLeiAndPersonByRoles {
		@Override
		protected String doEvaluate(Party party, Party reportingParty) {
			String partyPersonLei = null;
			return assignOutput(partyPersonLei, party, reportingParty);
		}
		
		protected String assignOutput(String partyPersonLei, Party party, Party reportingParty) {
			if (exists(partyPersonId(party, reportingParty)).getOrDefault(false)) {
				if (exists(reportingPartyLei(party, reportingParty)).getOrDefault(false)) {
					partyPersonLei = MapperMaths.<String, String, String>add(reportingPartyLei(party, reportingParty), partyPersonId(party, reportingParty).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue())).get();
				} else {
					partyPersonLei = MapperMaths.<String, String, String>add(partyLei1(party, reportingParty), partyPersonId(party, reportingParty).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue())).get();
				}
			} else {
				partyPersonLei = partyLei1(party, reportingParty).get();
			}
			
			return partyPersonLei;
		}
		
		@Override
		protected MapperS<String> partyLei1(Party party, Party reportingParty) {
			if (areEqual(MapperS.of(party).<PartyIdentifier>mapC("getPartyId", _party -> _party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
				return MapperS.of(partyLei0.evaluate(MapperS.of(party).<PartyIdentifier>mapC("getPartyId", _party -> _party.getPartyId()).getMulti()));
			}
			return MapperS.<String>ofNull();
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> partyPersonId(Party party, Party reportingParty) {
			return MapperS.of(naturalPersonBuyerOrSeller.evaluate(party)).<FieldWithMetaPersonIdentifier>mapC("getPersonId", naturalPerson -> naturalPerson.getPersonId()).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<FieldWithMetaString>map("getIdentifier", personIdentifier -> personIdentifier.getIdentifier());
		}
		
		@Override
		protected MapperS<String> reportingPartyLei(Party party, Party reportingParty) {
			if (areEqual(MapperS.of(reportingParty).<PartyIdentifier>mapC("getPartyId", _party -> _party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
				return MapperS.of(partyLei0.evaluate(MapperS.of(reportingParty).<PartyIdentifier>mapC("getPartyId", _party -> _party.getPartyId()).getMulti()));
			}
			return MapperS.<String>ofNull();
		}
	}
}
