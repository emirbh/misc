package cdm.ingest.fpml.confirmation.product.commodityswaption.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapSwaptionPhysicalSettlementToAncillaryParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwaptionAncillaryPartyList.MapCommoditySwaptionAncillaryPartyListDefault.class)
public abstract class MapCommoditySwaptionAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSwaptionPhysicalSettlementToAncillaryParty mapSwaptionPhysicalSettlementToAncillaryParty;

	/**
	* @param fpmlCommoditySwaption 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlCommoditySwaption, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommoditySwaptionAncillaryPartyListDefault extends MapCommoditySwaptionAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlCommoditySwaption, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
			final AncillaryParty ancillaryParty = mapSwaptionPhysicalSettlementToAncillaryParty.evaluate(MapperS.of(fpmlCommoditySwaption).<CommodityPhysicalExercise>map("getPhysicalExercise", commoditySwaption -> commoditySwaption.getPhysicalExercise()).<SwaptionPhysicalSettlement>map("getClearingInstructions", commodityPhysicalExercise -> commodityPhysicalExercise.getClearingInstructions()).get());
			if (ancillaryParty == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty)));
			}
			
			return Optional.ofNullable(ancillaryPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
