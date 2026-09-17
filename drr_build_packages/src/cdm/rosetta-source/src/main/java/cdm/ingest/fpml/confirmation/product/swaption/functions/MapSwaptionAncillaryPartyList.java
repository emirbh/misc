package cdm.ingest.fpml.confirmation.product.swaption.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapCalculationAgentIndependentToAncillaryParty;
import cdm.ingest.fpml.confirmation.party.functions.MapEarlyTerminationProvisionToAncillaryParty;
import cdm.ingest.fpml.confirmation.party.functions.MapExerciseProcedureToAncillaryParty;
import cdm.ingest.fpml.confirmation.party.functions.MapSwaptionPhysicalSettlementToAncillaryParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapSwaptionAncillaryPartyList.MapSwaptionAncillaryPartyListDefault.class)
public abstract class MapSwaptionAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationAgentIndependentToAncillaryParty mapCalculationAgentIndependentToAncillaryParty;
	@Inject protected MapEarlyTerminationProvisionToAncillaryParty mapEarlyTerminationProvisionToAncillaryParty;
	@Inject protected MapExerciseProcedureToAncillaryParty mapExerciseProcedureToAncillaryParty;
	@Inject protected MapSwaptionPhysicalSettlementToAncillaryParty mapSwaptionPhysicalSettlementToAncillaryParty;

	/**
	* @param fpmlSwaption 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlSwaption, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSwaptionAncillaryPartyListDefault extends MapSwaptionAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlSwaption, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
			final AncillaryParty ancillaryParty0 = mapSwaptionPhysicalSettlementToAncillaryParty.evaluate(MapperS.of(fpmlSwaption).<SwaptionPhysicalSettlement>map("getPhysicalSettlement", swaption -> swaption.getPhysicalSettlement()).get());
			if (ancillaryParty0 == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty0)));
			}
			
			final AncillaryParty ancillaryParty1 = mapExerciseProcedureToAncillaryParty.evaluate(MapperS.of(fpmlSwaption).<ExerciseProcedure>map("getExerciseProcedure", swaption -> swaption.getExerciseProcedure()).get(), cdmCounterpartyList);
			if (ancillaryParty1 == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty1)));
			}
			
			ancillaryPartyList.addAll(toBuilder(mapEarlyTerminationProvisionToAncillaryParty.evaluate(MapperS.of(fpmlSwaption).<EarlyTerminationProvision>map("getEarlyTerminationProvision", swaption -> swaption.getEarlyTerminationProvision()).get(), cdmCounterpartyList)));
			
			final AncillaryParty ancillaryParty2 = mapCalculationAgentIndependentToAncillaryParty.evaluate(MapperS.of(fpmlSwaption).<CalculationAgent>map("getCalculationAgent", swaption -> swaption.getCalculationAgent()).get());
			if (ancillaryParty2 == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty2)));
			}
			
			return Optional.ofNullable(ancillaryPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
