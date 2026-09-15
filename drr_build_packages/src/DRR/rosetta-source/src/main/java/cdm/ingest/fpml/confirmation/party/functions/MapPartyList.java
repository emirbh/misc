package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPartyList.MapPartyListDefault.class)
public abstract class MapPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlPartyList 
	* @param fpmlPartyTradeInformationList 
	* @return partyList 
	*/
	public List<? extends Party> evaluate(List<? extends fpml.consolidated.shared.Party> fpmlPartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
		List<Party.PartyBuilder> partyListBuilder = doEvaluate(fpmlPartyList, fpmlPartyTradeInformationList);
		
		final List<? extends Party> partyList;
		if (partyListBuilder == null) {
			partyList = null;
		} else {
			partyList = partyListBuilder.stream().map(Party::build).collect(Collectors.toList());
			objectValidator.validate(Party.class, partyList);
		}
		
		return partyList;
	}

	protected abstract List<Party.PartyBuilder> doEvaluate(List<? extends fpml.consolidated.shared.Party> fpmlPartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList);

	public static class MapPartyListDefault extends MapPartyList {
		@Override
		protected List<Party.PartyBuilder> doEvaluate(List<? extends fpml.consolidated.shared.Party> fpmlPartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			if (fpmlPartyTradeInformationList == null) {
				fpmlPartyTradeInformationList = Collections.emptyList();
			}
			List<Party.PartyBuilder> partyList = new ArrayList<>();
			return assignOutput(partyList, fpmlPartyList, fpmlPartyTradeInformationList);
		}
		
		protected List<Party.PartyBuilder> assignOutput(List<Party.PartyBuilder> partyList, List<? extends fpml.consolidated.shared.Party> fpmlPartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			partyList.addAll(toBuilder(MapperC.<fpml.consolidated.shared.Party>of(fpmlPartyList)
				.mapItem(item -> MapperS.of(mapParty.evaluate(item.get(), fpmlPartyTradeInformationList))).getMulti()));
			
			return Optional.ofNullable(partyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
