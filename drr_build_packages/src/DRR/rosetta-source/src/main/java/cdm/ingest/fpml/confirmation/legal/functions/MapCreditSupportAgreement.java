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
import fpml.consolidated.shared.CreditSupportAgreement;
import fpml.consolidated.shared.CreditSupportAgreementType;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditSupportAgreement.MapCreditSupportAgreementDefault.class)
public abstract class MapCreditSupportAgreement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditSupportAgreementTypeEnumWithScheme mapCreditSupportAgreementTypeEnumWithScheme;
	@Inject protected MapLegalAgreement mapLegalAgreement;

	/**
	* @param fpmlCreditSupportAgreement 
	* @param cdmCounterpartyList 
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(CreditSupportAgreement fpmlCreditSupportAgreement, List<? extends Counterparty> cdmCounterpartyList) {
		LegalAgreement.LegalAgreementBuilder legalAgreementBuilder = doEvaluate(fpmlCreditSupportAgreement, cdmCounterpartyList);
		
		final LegalAgreement legalAgreement;
		if (legalAgreementBuilder == null) {
			legalAgreement = null;
		} else {
			legalAgreement = legalAgreementBuilder.build();
			objectValidator.validate(LegalAgreement.class, legalAgreement);
		}
		
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(CreditSupportAgreement fpmlCreditSupportAgreement, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AgreementName> cdmAgreementName(CreditSupportAgreement fpmlCreditSupportAgreement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditSupportAgreementDefault extends MapCreditSupportAgreement {
		@Override
		protected LegalAgreement.LegalAgreementBuilder doEvaluate(CreditSupportAgreement fpmlCreditSupportAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			LegalAgreement.LegalAgreementBuilder legalAgreement = LegalAgreement.builder();
			return assignOutput(legalAgreement, fpmlCreditSupportAgreement, cdmCounterpartyList);
		}
		
		protected LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, CreditSupportAgreement fpmlCreditSupportAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			legalAgreement = toBuilder(mapLegalAgreement.evaluate(MapperS.of(fpmlCreditSupportAgreement).<ZonedDateTime>map("getDate", creditSupportAgreement -> creditSupportAgreement.getDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), cdmCounterpartyList, cdmAgreementName(fpmlCreditSupportAgreement, cdmCounterpartyList).get(), null));
			
			return Optional.ofNullable(legalAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends AgreementName> cdmAgreementName(CreditSupportAgreement fpmlCreditSupportAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(AgreementName.builder()
				.setCreditSupportAgreementType(mapCreditSupportAgreementTypeEnumWithScheme.evaluate(MapperS.of(fpmlCreditSupportAgreement).<CreditSupportAgreementType>map("getType", creditSupportAgreement -> creditSupportAgreement._getType()).get()))
				.setAgreementType(LegalAgreementTypeEnum.CREDIT_SUPPORT_AGREEMENT)
				.build());
		}
	}
}
