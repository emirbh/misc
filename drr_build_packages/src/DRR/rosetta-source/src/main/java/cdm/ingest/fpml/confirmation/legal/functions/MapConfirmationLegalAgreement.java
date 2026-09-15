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
import fpml.consolidated.shared.ContractualDefinitions;
import fpml.consolidated.shared.ContractualMatrix;
import fpml.consolidated.shared.ContractualSupplement;
import fpml.consolidated.shared.ContractualTermsSupplement;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.MatrixTerm;
import fpml.consolidated.shared.MatrixType;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapConfirmationLegalAgreement.MapConfirmationLegalAgreementDefault.class)
public abstract class MapConfirmationLegalAgreement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContractualDefinitionsEnumWithScheme mapContractualDefinitionsEnumWithScheme;
	@Inject protected MapContractualSupplementTypeEnumWithScheme mapContractualSupplementTypeEnumWithScheme;
	@Inject protected MapLegalAgreement mapLegalAgreement;
	@Inject protected MapMatrixTermEnumWithScheme mapMatrixTermEnumWithScheme;
	@Inject protected MapMatrixTypeEnumWithScheme mapMatrixTypeEnumWithScheme;

	/**
	* @param fpmlDocumentation 
	* @param cdmCounterpartyList 
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList) {
		LegalAgreement.LegalAgreementBuilder legalAgreementBuilder = doEvaluate(fpmlDocumentation, cdmCounterpartyList);
		
		final LegalAgreement legalAgreement;
		if (legalAgreementBuilder == null) {
			legalAgreement = null;
		} else {
			legalAgreement = legalAgreementBuilder.build();
			objectValidator.validate(LegalAgreement.class, legalAgreement);
		}
		
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AgreementName> cdmAgreementName(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapConfirmationLegalAgreementDefault extends MapConfirmationLegalAgreement {
		@Override
		protected LegalAgreement.LegalAgreementBuilder doEvaluate(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			LegalAgreement.LegalAgreementBuilder legalAgreement = LegalAgreement.builder();
			return assignOutput(legalAgreement, fpmlDocumentation, cdmCounterpartyList);
		}
		
		protected LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList) {
			legalAgreement = toBuilder(mapLegalAgreement.evaluate(null, cdmCounterpartyList, cdmAgreementName(fpmlDocumentation, cdmCounterpartyList).get(), null));
			
			return Optional.ofNullable(legalAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends AgreementName> cdmAgreementName(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(AgreementName.builder()
				.setContractualDefinitionsType(MapperS.of(fpmlDocumentation).<ContractualDefinitions>mapC("getContractualDefinitions", documentation -> documentation.getContractualDefinitions())
					.mapItem(item -> MapperS.of(mapContractualDefinitionsEnumWithScheme.evaluate(item.get()))).getMulti())
				.setContractualMatrix(MapperS.of(fpmlDocumentation).<ContractualMatrix>mapC("getContractualMatrix", documentation -> documentation.getContractualMatrix())
					.mapItem(item -> MapperS.of(cdm.legaldocumentation.common.ContractualMatrix.builder()
						.setMatrixType(mapMatrixTypeEnumWithScheme.evaluate(item.<MatrixType>map("getMatrixType", contractualMatrix -> contractualMatrix.getMatrixType()).get()))
						.setMatrixTerm(mapMatrixTermEnumWithScheme.evaluate(item.<MatrixTerm>map("getMatrixTerm", contractualMatrix -> contractualMatrix.getMatrixTerm()).get()))
						.build())).getMulti())
				.setContractualTermsSupplement(MapperS.of(fpmlDocumentation).<ContractualTermsSupplement>mapC("getContractualTermsSupplement", documentation -> documentation.getContractualTermsSupplement())
					.mapItem(item -> MapperS.of(cdm.legaldocumentation.common.ContractualTermsSupplement.builder()
						.setContractualTermsSupplementType(mapContractualSupplementTypeEnumWithScheme.evaluate(item.<ContractualSupplement>map("getType", contractualTermsSupplement -> contractualTermsSupplement._getType()).get()))
						.setPublicationDate(item.<ZonedDateTime>map("getPublicationDate", contractualTermsSupplement -> contractualTermsSupplement.getPublicationDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
						.build())).getMulti())
				.setAgreementType(LegalAgreementTypeEnum.CONFIRMATION)
				.build());
		}
	}
}
