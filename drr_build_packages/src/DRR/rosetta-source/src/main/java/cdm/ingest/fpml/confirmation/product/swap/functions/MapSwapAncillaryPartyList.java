package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapCancelableProvisionToAncillaryParty;
import cdm.ingest.fpml.confirmation.party.functions.MapEarlyTerminationProvisionToAncillaryParty;
import cdm.ingest.fpml.confirmation.party.functions.MapExtendibleProvisionToAncillaryParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CancelableProvision;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.ExtendibleProvision;
import fpml.consolidated.ird.Swap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapSwapAncillaryPartyList.MapSwapAncillaryPartyListDefault.class)
public abstract class MapSwapAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCancelableProvisionToAncillaryParty mapCancelableProvisionToAncillaryParty;
	@Inject protected MapEarlyTerminationProvisionToAncillaryParty mapEarlyTerminationProvisionToAncillaryParty;
	@Inject protected MapExtendibleProvisionToAncillaryParty mapExtendibleProvisionToAncillaryParty;

	/**
	* @param fpmlSwap 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlSwap, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSwapAncillaryPartyListDefault extends MapSwapAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlSwap, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList) {
			ancillaryPartyList.addAll(toBuilder(mapEarlyTerminationProvisionToAncillaryParty.evaluate(MapperS.of(fpmlSwap).<EarlyTerminationProvision>map("getEarlyTerminationProvision", swap -> swap.getEarlyTerminationProvision()).get(), cdmCounterpartyList)));
			
			final AncillaryParty ancillaryParty0 = mapCancelableProvisionToAncillaryParty.evaluate(MapperS.of(fpmlSwap).<CancelableProvision>map("getCancelableProvision", swap -> swap.getCancelableProvision()).get(), cdmCounterpartyList);
			if (ancillaryParty0 == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty0)));
			}
			
			final AncillaryParty ancillaryParty1 = mapExtendibleProvisionToAncillaryParty.evaluate(MapperS.of(fpmlSwap).<ExtendibleProvision>map("getExtendibleProvision", swap -> swap.getExtendibleProvision()).get(), cdmCounterpartyList);
			if (ancillaryParty1 == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty1)));
			}
			
			return Optional.ofNullable(ancillaryPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
