package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapRelatedPartyToPartyRole.MapRelatedPartyToPartyRoleDefault.class)
public abstract class MapRelatedPartyToPartyRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;

	/**
	* @param fpmlPartyTradeInformationList 
	* @return partyRole 
	*/
	public List<? extends PartyRole> evaluate(PartyTradeInformation fpmlPartyTradeInformationList) {
		List<PartyRole.PartyRoleBuilder> partyRoleBuilder = doEvaluate(fpmlPartyTradeInformationList);
		
		final List<? extends PartyRole> partyRole;
		if (partyRoleBuilder == null) {
			partyRole = null;
		} else {
			partyRole = partyRoleBuilder.stream().map(PartyRole::build).collect(Collectors.toList());
			objectValidator.validate(PartyRole.class, partyRole);
		}
		
		return partyRole;
	}

	protected abstract List<PartyRole.PartyRoleBuilder> doEvaluate(PartyTradeInformation fpmlPartyTradeInformationList);

	protected abstract MapperC<? extends RelatedParty> relatedParties(PartyTradeInformation fpmlPartyTradeInformationList);

	public static class MapRelatedPartyToPartyRoleDefault extends MapRelatedPartyToPartyRole {
		@Override
		protected List<PartyRole.PartyRoleBuilder> doEvaluate(PartyTradeInformation fpmlPartyTradeInformationList) {
			List<PartyRole.PartyRoleBuilder> partyRole = new ArrayList<>();
			return assignOutput(partyRole, fpmlPartyTradeInformationList);
		}
		
		protected List<PartyRole.PartyRoleBuilder> assignOutput(List<PartyRole.PartyRoleBuilder> partyRole, PartyTradeInformation fpmlPartyTradeInformationList) {
			partyRole.addAll(toBuilder(relatedParties(fpmlPartyTradeInformationList)
				.mapItem(item -> MapperS.of(PartyRole.builder()
					.setPartyReference(mapPartyReference.evaluate(item.<PartyReference>map("getPartyReference", relatedParty -> relatedParty.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
					.setRole(item.<fpml.consolidated.shared.PartyRole>map("getRole", relatedParty -> relatedParty.getRole()).<String>map("getValue", _partyRole -> _partyRole.getValue()).checkedMap("to-enum", PartyRoleEnum::fromDisplayName, IllegalArgumentException.class).get())
					.setOwnershipPartyReference(mapPartyReference.evaluate(MapperS.of(fpmlPartyTradeInformationList).<PartyReference>map("getPartyReference", partyTradeInformation -> partyTradeInformation.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
					.build())).getMulti()));
			
			return Optional.ofNullable(partyRole)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends RelatedParty> relatedParties(PartyTradeInformation fpmlPartyTradeInformationList) {
			return MapperS.of(fpmlPartyTradeInformationList).<RelatedParty>mapC("getRelatedParty", partyTradeInformation -> partyTradeInformation.getRelatedParty());
		}
	}
}
