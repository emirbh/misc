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
import fpml.consolidated.shared.OtherAgreement;
import fpml.consolidated.shared.OtherAgreementType;
import fpml.consolidated.shared.OtherAgreementVersion;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOtherAgreements.MapOtherAgreementsDefault.class)
public abstract class MapOtherAgreements implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalAgreement mapLegalAgreement;

	/**
	* @param fpmlOtherAgreement 
	* @param cdmCounterpartyList 
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList) {
		LegalAgreement.LegalAgreementBuilder legalAgreementBuilder = doEvaluate(fpmlOtherAgreement, cdmCounterpartyList);
		
		final LegalAgreement legalAgreement;
		if (legalAgreementBuilder == null) {
			legalAgreement = null;
		} else {
			legalAgreement = legalAgreementBuilder.build();
			objectValidator.validate(LegalAgreement.class, legalAgreement);
		}
		
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AgreementName> agreementName(OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<Integer> vintage(OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapOtherAgreementsDefault extends MapOtherAgreements {
		@Override
		protected LegalAgreement.LegalAgreementBuilder doEvaluate(OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			LegalAgreement.LegalAgreementBuilder legalAgreement = LegalAgreement.builder();
			return assignOutput(legalAgreement, fpmlOtherAgreement, cdmCounterpartyList);
		}
		
		protected LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			legalAgreement = toBuilder(mapLegalAgreement.evaluate(MapperS.of(fpmlOtherAgreement).<ZonedDateTime>map("getDate", otherAgreement -> otherAgreement.getDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), cdmCounterpartyList, agreementName(fpmlOtherAgreement, cdmCounterpartyList).get(), vintage(fpmlOtherAgreement, cdmCounterpartyList).get()));
			
			return Optional.ofNullable(legalAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends AgreementName> agreementName(OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(AgreementName.builder()
				.setOtherAgreement(MapperS.of(fpmlOtherAgreement).<OtherAgreementType>map("getType", otherAgreement -> otherAgreement._getType()).<String>map("getValue", otherAgreementType -> otherAgreementType.getValue()).get())
				.setAgreementType(LegalAgreementTypeEnum.OTHER)
				.build());
		}
		
		@Override
		protected MapperS<Integer> vintage(OtherAgreement fpmlOtherAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlOtherAgreement).<OtherAgreementVersion>map("getVersion", otherAgreement -> otherAgreement.getVersion()).<String>map("getValue", otherAgreementVersion -> otherAgreementVersion.getValue()).checkedMap("to-int", Integer::parseInt, NumberFormatException.class);
		}
	}
}
