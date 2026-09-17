package cdm.ingest.fpml.confirmation.product.capfloor.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapEarlyTerminationProvisionToAncillaryParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.EarlyTerminationProvision;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCapFloorAncillaryPartyList.MapCapFloorAncillaryPartyListDefault.class)
public abstract class MapCapFloorAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEarlyTerminationProvisionToAncillaryParty mapEarlyTerminationProvisionToAncillaryParty;

	/**
	* @param fpmlCapFloor 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlCapFloor, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCapFloorAncillaryPartyListDefault extends MapCapFloorAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlCapFloor, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList) {
			ancillaryPartyList.addAll(toBuilder(mapEarlyTerminationProvisionToAncillaryParty.evaluate(MapperS.of(fpmlCapFloor).<EarlyTerminationProvision>map("getEarlyTerminationProvision", capFloor -> capFloor.getEarlyTerminationProvision()).get(), cdmCounterpartyList)));
			
			return Optional.ofNullable(ancillaryPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
