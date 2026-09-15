package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.MasterConfirmation;
import fpml.consolidated.shared.MasterConfirmationAnnexType;
import fpml.consolidated.shared.MasterConfirmationType;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMasterConfirmation.MapMasterConfirmationDefault.class)
public abstract class MapMasterConfirmation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalAgreement mapLegalAgreement;
	@Inject protected MapMasterConfirmationAnnexTypeEnumWithScheme mapMasterConfirmationAnnexTypeEnumWithScheme;
	@Inject protected MapMasterConfirmationTypeEnumWithScheme mapMasterConfirmationTypeEnumWithScheme;

	/**
	* @param fpmlMasterConfirmation 
	* @param cdmCounterpartyList 
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(MasterConfirmation fpmlMasterConfirmation, List<? extends Counterparty> cdmCounterpartyList) {
		LegalAgreement.LegalAgreementBuilder legalAgreementBuilder = doEvaluate(fpmlMasterConfirmation, cdmCounterpartyList);
		
		final LegalAgreement legalAgreement;
		if (legalAgreementBuilder == null) {
			legalAgreement = null;
		} else {
			legalAgreement = legalAgreementBuilder.build();
			objectValidator.validate(LegalAgreement.class, legalAgreement);
		}
		
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(MasterConfirmation fpmlMasterConfirmation, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AgreementName> cdmAgreementName(MasterConfirmation fpmlMasterConfirmation, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapMasterConfirmationDefault extends MapMasterConfirmation {
		@Override
		protected LegalAgreement.LegalAgreementBuilder doEvaluate(MasterConfirmation fpmlMasterConfirmation, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			LegalAgreement.LegalAgreementBuilder legalAgreement = LegalAgreement.builder();
			return assignOutput(legalAgreement, fpmlMasterConfirmation, cdmCounterpartyList);
		}
		
		protected LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, MasterConfirmation fpmlMasterConfirmation, List<? extends Counterparty> cdmCounterpartyList) {
			legalAgreement = toBuilder(mapLegalAgreement.evaluate(MapperS.of(fpmlMasterConfirmation).<ZonedDateTime>map("getMasterConfirmationDate", masterConfirmation -> masterConfirmation.getMasterConfirmationDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), cdmCounterpartyList, cdmAgreementName(fpmlMasterConfirmation, cdmCounterpartyList).get(), null));
			
			return Optional.ofNullable(legalAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends AgreementName> cdmAgreementName(MasterConfirmation fpmlMasterConfirmation, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(AgreementName.builder()
				.setMasterConfirmationType(mapMasterConfirmationTypeEnumWithScheme.evaluate(MapperS.of(fpmlMasterConfirmation).<MasterConfirmationType>map("getMasterConfirmationType", masterConfirmation -> masterConfirmation.getMasterConfirmationType()).get()))
				.setMasterConfirmationAnnexType(mapMasterConfirmationAnnexTypeEnumWithScheme.evaluate(MapperS.of(fpmlMasterConfirmation).<MasterConfirmationAnnexType>map("getMasterConfirmationAnnexType", masterConfirmation -> masterConfirmation.getMasterConfirmationAnnexType()).get()))
				.setAgreementType(LegalAgreementTypeEnum.MASTER_CONFIRMATION)
				.build());
		}
	}
}
