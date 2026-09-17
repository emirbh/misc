package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapExerciseProcedureToAncillaryParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.shared.ExerciseProcedure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxOptionAncillaryPartyList.MapFxOptionAncillaryPartyListDefault.class)
public abstract class MapFxOptionAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapExerciseProcedureToAncillaryParty mapExerciseProcedureToAncillaryParty;

	/**
	* @param fpmlFxOption 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlFxOption, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxOptionAncillaryPartyListDefault extends MapFxOptionAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlFxOption, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
			final AncillaryParty ancillaryParty = mapExerciseProcedureToAncillaryParty.evaluate(MapperS.of(fpmlFxOption).<ExerciseProcedure>map("getExerciseProcedure", fxOption -> fxOption.getExerciseProcedure()).get(), cdmCounterpartyList);
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
