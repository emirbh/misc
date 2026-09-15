package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLegalAgreement.MapLegalAgreementDefault.class)
public abstract class MapLegalAgreement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContractualParty mapContractualParty;

	/**
	* @param fpmlAgreementDate 
	* @param cdmCounterpartyList 
	* @param cdmAgreementName 
	* @param cdmVintage 
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(Date fpmlAgreementDate, List<? extends Counterparty> cdmCounterpartyList, AgreementName cdmAgreementName, Integer cdmVintage) {
		LegalAgreement.LegalAgreementBuilder legalAgreementBuilder = doEvaluate(fpmlAgreementDate, cdmCounterpartyList, cdmAgreementName, cdmVintage);
		
		final LegalAgreement legalAgreement;
		if (legalAgreementBuilder == null) {
			legalAgreement = null;
		} else {
			legalAgreement = legalAgreementBuilder.build();
			objectValidator.validate(LegalAgreement.class, legalAgreement);
		}
		
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(Date fpmlAgreementDate, List<? extends Counterparty> cdmCounterpartyList, AgreementName cdmAgreementName, Integer cdmVintage);

	public static class MapLegalAgreementDefault extends MapLegalAgreement {
		@Override
		protected LegalAgreement.LegalAgreementBuilder doEvaluate(Date fpmlAgreementDate, List<? extends Counterparty> cdmCounterpartyList, AgreementName cdmAgreementName, Integer cdmVintage) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			LegalAgreement.LegalAgreementBuilder legalAgreement = LegalAgreement.builder();
			return assignOutput(legalAgreement, fpmlAgreementDate, cdmCounterpartyList, cdmAgreementName, cdmVintage);
		}
		
		protected LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, Date fpmlAgreementDate, List<? extends Counterparty> cdmCounterpartyList, AgreementName cdmAgreementName, Integer cdmVintage) {
			legalAgreement = toBuilder(LegalAgreement.builder()
				.setAgreementDate(fpmlAgreementDate)
				.setContractualParty(new ArrayList(mapContractualParty.evaluate(cdmCounterpartyList)))
				.setLegalAgreementIdentification(LegalAgreementIdentification.builder()
					.setGoverningLaw(null)
					.setAgreementName(cdmAgreementName)
					.setPublisher(null)
					.setVintage(cdmVintage)
					.build())
				.build());
			
			return Optional.ofNullable(legalAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
