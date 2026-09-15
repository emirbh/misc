package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.ContractDetails;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.GoverningLaw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapContractDetails.MapContractDetailsDefault.class)
public abstract class MapContractDetails implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapGoverningLaw mapGoverningLaw;
	@Inject protected MapLegalAgreementList mapLegalAgreementList;

	/**
	* @param fpmlTrade 
	* @param cdmCounterpartyList 
	* @return contractDetails 
	*/
	public ContractDetails evaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
		ContractDetails.ContractDetailsBuilder contractDetailsBuilder = doEvaluate(fpmlTrade, cdmCounterpartyList);
		
		final ContractDetails contractDetails;
		if (contractDetailsBuilder == null) {
			contractDetails = null;
		} else {
			contractDetails = contractDetailsBuilder.build();
			objectValidator.validate(ContractDetails.class, contractDetails);
		}
		
		return contractDetails;
	}

	protected abstract ContractDetails.ContractDetailsBuilder doEvaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapContractDetailsDefault extends MapContractDetails {
		@Override
		protected ContractDetails.ContractDetailsBuilder doEvaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			ContractDetails.ContractDetailsBuilder contractDetails = ContractDetails.builder();
			return assignOutput(contractDetails, fpmlTrade, cdmCounterpartyList);
		}
		
		protected ContractDetails.ContractDetailsBuilder assignOutput(ContractDetails.ContractDetailsBuilder contractDetails, Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
			contractDetails = toBuilder(ContractDetails.builder()
				.setDocumentation(new ArrayList(mapLegalAgreementList.evaluate(MapperS.of(fpmlTrade).<Documentation>map("getDocumentation", trade -> trade.getDocumentation()).get(), cdmCounterpartyList)))
				.setGoverningLaw(mapGoverningLaw.evaluate(MapperS.of(fpmlTrade).<GoverningLaw>map("getGoverningLaw", trade -> trade.getGoverningLaw()).get()))
				.build());
			
			return Optional.ofNullable(contractDetails)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
