package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.shared.BusinessUnit;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.PartyId;
import fpml.consolidated.shared.PartyName;
import fpml.consolidated.shared.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapParty.MapPartyDefault.class)
public abstract class MapParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessUnit mapBusinessUnit;
	@Inject protected MapContactInformation mapContactInformation;
	@Inject protected MapNaturalPerson mapNaturalPerson;
	@Inject protected MapNaturalPersonRoleList mapNaturalPersonRoleList;
	@Inject protected MapPartyIdentifier mapPartyIdentifier;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlParty 
	* @param fpmlPartyTradeInformationList 
	* @return party 
	*/
	public Party evaluate(fpml.consolidated.shared.Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
		Party.PartyBuilder partyBuilder = doEvaluate(fpmlParty, fpmlPartyTradeInformationList);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(fpml.consolidated.shared.Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList);

	public static class MapPartyDefault extends MapParty {
		@Override
		protected Party.PartyBuilder doEvaluate(fpml.consolidated.shared.Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			if (fpmlPartyTradeInformationList == null) {
				fpmlPartyTradeInformationList = Collections.emptyList();
			}
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, fpmlParty, fpmlPartyTradeInformationList);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, fpml.consolidated.shared.Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			final Party.PartyBuilder withMetaArgument = Party.builder()
				.setPartyId(MapperS.of(fpmlParty).<PartyId>mapC("getPartyId", _party -> _party.getPartyId())
					.mapItem(item -> MapperS.of(mapPartyIdentifier.evaluate(item.<String>map("getValue", partyId -> partyId.getValue()).get(), item.<String>map("getPartyIdScheme", partyId -> partyId.getPartyIdScheme()).get()))).getMulti())
				.setName(mapStringWithScheme.evaluate(MapperS.of(fpmlParty).<PartyName>map("getPartyName", _party -> _party.getPartyName()).<String>map("getValue", partyName -> partyName.getValue()).get(), MapperS.of(fpmlParty).<PartyName>map("getPartyName", _party -> _party.getPartyName()).<String>map("getPartyNameScheme", partyName -> partyName.getPartyNameScheme()).get()))
				.setBusinessUnit(MapperS.of(fpmlParty).<BusinessUnit>mapC("getBusinessUnit", _party -> _party.getBusinessUnit())
					.mapItem(item -> MapperS.of(mapBusinessUnit.evaluate(item.get()))).getMulti())
				.setPerson(MapperS.of(fpmlParty).<Person>mapC("getPerson", _party -> _party.getPerson())
					.mapItem(item -> MapperS.of(mapNaturalPerson.evaluate(item.get()))).getMulti())
				.setPersonRole(new ArrayList(mapNaturalPersonRoleList.evaluate(fpmlParty, fpmlPartyTradeInformationList)))
				.setAccount(null)
				.setContactInformation(mapContactInformation.evaluate(MapperS.of(fpmlParty).<CountryCode>map("getCountry", _party -> _party.getCountry()).get(), MapperS.of(fpmlParty).<ContactInformation>map("getContactInfo", _party -> _party.getContactInfo()).get()))
				.build() == null ? null : Party.builder()
				.setPartyId(MapperS.of(fpmlParty).<PartyId>mapC("getPartyId", _party -> _party.getPartyId())
					.mapItem(item -> MapperS.of(mapPartyIdentifier.evaluate(item.<String>map("getValue", partyId -> partyId.getValue()).get(), item.<String>map("getPartyIdScheme", partyId -> partyId.getPartyIdScheme()).get()))).getMulti())
				.setName(mapStringWithScheme.evaluate(MapperS.of(fpmlParty).<PartyName>map("getPartyName", _party -> _party.getPartyName()).<String>map("getValue", partyName -> partyName.getValue()).get(), MapperS.of(fpmlParty).<PartyName>map("getPartyName", _party -> _party.getPartyName()).<String>map("getPartyNameScheme", partyName -> partyName.getPartyNameScheme()).get()))
				.setBusinessUnit(MapperS.of(fpmlParty).<BusinessUnit>mapC("getBusinessUnit", _party -> _party.getBusinessUnit())
					.mapItem(item -> MapperS.of(mapBusinessUnit.evaluate(item.get()))).getMulti())
				.setPerson(MapperS.of(fpmlParty).<Person>mapC("getPerson", _party -> _party.getPerson())
					.mapItem(item -> MapperS.of(mapNaturalPerson.evaluate(item.get()))).getMulti())
				.setPersonRole(new ArrayList(mapNaturalPersonRoleList.evaluate(fpmlParty, fpmlPartyTradeInformationList)))
				.setAccount(null)
				.setContactInformation(mapContactInformation.evaluate(MapperS.of(fpmlParty).<CountryCode>map("getCountry", _party -> _party.getCountry()).get(), MapperS.of(fpmlParty).<ContactInformation>map("getContactInfo", _party -> _party.getContactInfo()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlParty).<String>map("getId", _party -> _party.getId()).get());
			party = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
