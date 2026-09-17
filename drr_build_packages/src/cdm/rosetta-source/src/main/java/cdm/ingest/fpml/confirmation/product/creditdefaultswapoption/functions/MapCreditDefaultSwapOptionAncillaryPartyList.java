package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapExerciseProcedureToAncillaryParty;
import cdm.ingest.fpml.confirmation.party.functions.MapSwaptionPhysicalSettlementToAncillaryParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapOptionAncillaryPartyList.MapCreditDefaultSwapOptionAncillaryPartyListDefault.class)
public abstract class MapCreditDefaultSwapOptionAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapExerciseProcedureToAncillaryParty mapExerciseProcedureToAncillaryParty;
	@Inject protected MapSwaptionPhysicalSettlementToAncillaryParty mapSwaptionPhysicalSettlementToAncillaryParty;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditDefaultSwapOptionAncillaryPartyListDefault extends MapCreditDefaultSwapOptionAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			final AncillaryParty ancillaryParty0 = mapSwaptionPhysicalSettlementToAncillaryParty.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<SwaptionPhysicalSettlement>map("getClearingInstructions", creditDefaultSwapOption -> creditDefaultSwapOption.getClearingInstructions()).get());
			if (ancillaryParty0 == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty0)));
			}
			
			final AncillaryParty ancillaryParty1 = mapExerciseProcedureToAncillaryParty.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<ExerciseProcedure>map("getExerciseProcedure", creditDefaultSwapOption -> creditDefaultSwapOption.getExerciseProcedure()).get(), cdmCounterpartyList);
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
