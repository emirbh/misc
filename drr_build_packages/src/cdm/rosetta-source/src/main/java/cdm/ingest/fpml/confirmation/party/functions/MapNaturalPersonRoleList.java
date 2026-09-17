package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.NaturalPersonRole;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.RelatedPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNaturalPersonRoleList.MapNaturalPersonRoleListDefault.class)
public abstract class MapNaturalPersonRoleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetPartyPersonForRelatedPerson getPartyPersonForRelatedPerson;
	@Inject protected MapRelatedPersonToNaturalPersonRole mapRelatedPersonToNaturalPersonRole;

	/**
	* @param fpmlParty 
	* @param fpmlPartyTradeInformationList 
	* @return naturalPersonRoleList 
	*/
	public List<? extends NaturalPersonRole> evaluate(Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
		List<NaturalPersonRole.NaturalPersonRoleBuilder> naturalPersonRoleListBuilder = doEvaluate(fpmlParty, fpmlPartyTradeInformationList);
		
		final List<? extends NaturalPersonRole> naturalPersonRoleList;
		if (naturalPersonRoleListBuilder == null) {
			naturalPersonRoleList = null;
		} else {
			naturalPersonRoleList = naturalPersonRoleListBuilder.stream().map(NaturalPersonRole::build).collect(Collectors.toList());
			objectValidator.validate(NaturalPersonRole.class, naturalPersonRoleList);
		}
		
		return naturalPersonRoleList;
	}

	protected abstract List<NaturalPersonRole.NaturalPersonRoleBuilder> doEvaluate(Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList);

	protected abstract MapperC<? extends RelatedPerson> relatedPerson(Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList);

	public static class MapNaturalPersonRoleListDefault extends MapNaturalPersonRoleList {
		@Override
		protected List<NaturalPersonRole.NaturalPersonRoleBuilder> doEvaluate(Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			if (fpmlPartyTradeInformationList == null) {
				fpmlPartyTradeInformationList = Collections.emptyList();
			}
			List<NaturalPersonRole.NaturalPersonRoleBuilder> naturalPersonRoleList = new ArrayList<>();
			return assignOutput(naturalPersonRoleList, fpmlParty, fpmlPartyTradeInformationList);
		}
		
		protected List<NaturalPersonRole.NaturalPersonRoleBuilder> assignOutput(List<NaturalPersonRole.NaturalPersonRoleBuilder> naturalPersonRoleList, Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			naturalPersonRoleList.addAll(toBuilder(relatedPerson(fpmlParty, fpmlPartyTradeInformationList)
				.mapItem(item -> {
					if (exists(MapperS.of(getPartyPersonForRelatedPerson.evaluate(fpmlParty, item.get()))).getOrDefault(false)) {
						return MapperS.of(mapRelatedPersonToNaturalPersonRole.evaluate(item.get()));
					}
					return MapperS.<NaturalPersonRole>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(naturalPersonRoleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends RelatedPerson> relatedPerson(Party fpmlParty, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			return MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList).<RelatedPerson>mapC("getRelatedPerson", partyTradeInformation -> partyTradeInformation.getRelatedPerson());
		}
	}
}
