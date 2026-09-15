package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapContractualParty.MapContractualPartyDefault.class)
public abstract class MapContractualParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param cdmCounterpartyList 
	* @return contractualPartyList 
	*/
	public List<? extends ReferenceWithMetaParty> evaluate(List<? extends Counterparty> cdmCounterpartyList) {
		List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> contractualPartyListBuilder = doEvaluate(cdmCounterpartyList);
		
		final List<? extends ReferenceWithMetaParty> contractualPartyList;
		if (contractualPartyListBuilder == null) {
			contractualPartyList = null;
		} else {
			contractualPartyList = contractualPartyListBuilder.stream().map(ReferenceWithMetaParty::build).collect(Collectors.toList());
			objectValidator.validate(ReferenceWithMetaParty.class, contractualPartyList);
		}
		
		return contractualPartyList;
	}

	protected abstract List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> doEvaluate(List<? extends Counterparty> cdmCounterpartyList);

	public static class MapContractualPartyDefault extends MapContractualParty {
		@Override
		protected List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> doEvaluate(List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> contractualPartyList = new ArrayList<>();
			return assignOutput(contractualPartyList, cdmCounterpartyList);
		}
		
		protected List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> assignOutput(List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> contractualPartyList, List<? extends Counterparty> cdmCounterpartyList) {
			contractualPartyList.addAll(toBuilder(MapperC.<Counterparty>of(cdmCounterpartyList).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).getMulti()));
			
			return Optional.ofNullable(contractualPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
