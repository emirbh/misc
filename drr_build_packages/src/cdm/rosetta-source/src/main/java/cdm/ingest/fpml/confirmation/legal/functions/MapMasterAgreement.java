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
import fpml.consolidated.shared.MasterAgreement;
import fpml.consolidated.shared.MasterAgreementType;
import fpml.consolidated.shared.MasterAgreementVersion;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMasterAgreement.MapMasterAgreementDefault.class)
public abstract class MapMasterAgreement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalAgreement mapLegalAgreement;
	@Inject protected MapMasterAgreementTypeEnumWithScheme mapMasterAgreementTypeEnumWithScheme;

	/**
	* @param fpmlMasterAgreement 
	* @param cdmCounterpartyList 
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(MasterAgreement fpmlMasterAgreement, List<? extends Counterparty> cdmCounterpartyList) {
		LegalAgreement.LegalAgreementBuilder legalAgreementBuilder = doEvaluate(fpmlMasterAgreement, cdmCounterpartyList);
		
		final LegalAgreement legalAgreement;
		if (legalAgreementBuilder == null) {
			legalAgreement = null;
		} else {
			legalAgreement = legalAgreementBuilder.build();
			objectValidator.validate(LegalAgreement.class, legalAgreement);
		}
		
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(MasterAgreement fpmlMasterAgreement, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AgreementName> cdmAgreementName(MasterAgreement fpmlMasterAgreement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapMasterAgreementDefault extends MapMasterAgreement {
		@Override
		protected LegalAgreement.LegalAgreementBuilder doEvaluate(MasterAgreement fpmlMasterAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			LegalAgreement.LegalAgreementBuilder legalAgreement = LegalAgreement.builder();
			return assignOutput(legalAgreement, fpmlMasterAgreement, cdmCounterpartyList);
		}
		
		protected LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, MasterAgreement fpmlMasterAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			legalAgreement = toBuilder(mapLegalAgreement.evaluate(MapperS.of(fpmlMasterAgreement).<ZonedDateTime>map("getMasterAgreementDate", masterAgreement -> masterAgreement.getMasterAgreementDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), cdmCounterpartyList, cdmAgreementName(fpmlMasterAgreement, cdmCounterpartyList).get(), MapperS.of(fpmlMasterAgreement).<MasterAgreementVersion>map("getMasterAgreementVersion", masterAgreement -> masterAgreement.getMasterAgreementVersion()).<String>map("getValue", masterAgreementVersion -> masterAgreementVersion.getValue()).checkedMap("to-int", Integer::parseInt, NumberFormatException.class).get()));
			
			return Optional.ofNullable(legalAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends AgreementName> cdmAgreementName(MasterAgreement fpmlMasterAgreement, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(AgreementName.builder()
				.setMasterAgreementType(mapMasterAgreementTypeEnumWithScheme.evaluate(MapperS.of(fpmlMasterAgreement).<MasterAgreementType>map("getMasterAgreementType", masterAgreement -> masterAgreement.getMasterAgreementType()).get()))
				.setAgreementType(LegalAgreementTypeEnum.MASTER_AGREEMENT)
				.build());
		}
	}
}
