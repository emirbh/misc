package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.legaldocumentation.common.LegalAgreement;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ContractualDefinitions;
import fpml.consolidated.shared.ContractualMatrix;
import fpml.consolidated.shared.ContractualTermsSupplement;
import fpml.consolidated.shared.CreditSupportAgreement;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.MasterAgreement;
import fpml.consolidated.shared.MasterConfirmation;
import fpml.consolidated.shared.OtherAgreement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapLegalAgreementList.MapLegalAgreementListDefault.class)
public abstract class MapLegalAgreementList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapConfirmationLegalAgreement mapConfirmationLegalAgreement;
	@Inject protected MapCreditSupportAgreement mapCreditSupportAgreement;
	@Inject protected MapMasterAgreement mapMasterAgreement;
	@Inject protected MapMasterConfirmation mapMasterConfirmation;
	@Inject protected MapOtherAgreements mapOtherAgreements;

	/**
	* @param fpmlDocumentation 
	* @param cdmCounterpartyList 
	* @return legalAgreementList 
	*/
	public List<? extends LegalAgreement> evaluate(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList) {
		List<LegalAgreement.LegalAgreementBuilder> legalAgreementListBuilder = doEvaluate(fpmlDocumentation, cdmCounterpartyList);
		
		final List<? extends LegalAgreement> legalAgreementList;
		if (legalAgreementListBuilder == null) {
			legalAgreementList = null;
		} else {
			legalAgreementList = legalAgreementListBuilder.stream().map(LegalAgreement::build).collect(Collectors.toList());
			objectValidator.validate(LegalAgreement.class, legalAgreementList);
		}
		
		return legalAgreementList;
	}

	protected abstract List<LegalAgreement.LegalAgreementBuilder> doEvaluate(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapLegalAgreementListDefault extends MapLegalAgreementList {
		@Override
		protected List<LegalAgreement.LegalAgreementBuilder> doEvaluate(Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<LegalAgreement.LegalAgreementBuilder> legalAgreementList = new ArrayList<>();
			return assignOutput(legalAgreementList, fpmlDocumentation, cdmCounterpartyList);
		}
		
		protected List<LegalAgreement.LegalAgreementBuilder> assignOutput(List<LegalAgreement.LegalAgreementBuilder> legalAgreementList, Documentation fpmlDocumentation, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperS.of(fpmlDocumentation).<MasterAgreement>map("getMasterAgreement", documentation -> documentation.getMasterAgreement())).getOrDefault(false)) {
				final LegalAgreement legalAgreement0 = mapMasterAgreement.evaluate(MapperS.of(fpmlDocumentation).<MasterAgreement>map("getMasterAgreement", documentation -> documentation.getMasterAgreement()).get(), cdmCounterpartyList);
				if (legalAgreement0 == null) {
					legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
				} else {
					legalAgreementList.addAll(toBuilder(Collections.singletonList(legalAgreement0)));
				}
			} else {
				legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlDocumentation).<MasterConfirmation>map("getMasterConfirmation", documentation -> documentation.getMasterConfirmation())).getOrDefault(false)) {
				final LegalAgreement legalAgreement1 = mapMasterConfirmation.evaluate(MapperS.of(fpmlDocumentation).<MasterConfirmation>map("getMasterConfirmation", documentation -> documentation.getMasterConfirmation()).get(), cdmCounterpartyList);
				if (legalAgreement1 == null) {
					legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
				} else {
					legalAgreementList.addAll(toBuilder(Collections.singletonList(legalAgreement1)));
				}
			} else {
				legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlDocumentation).<CreditSupportAgreement>map("getCreditSupportAgreement", documentation -> documentation.getCreditSupportAgreement())).getOrDefault(false)) {
				final LegalAgreement legalAgreement2 = mapCreditSupportAgreement.evaluate(MapperS.of(fpmlDocumentation).<CreditSupportAgreement>map("getCreditSupportAgreement", documentation -> documentation.getCreditSupportAgreement()).get(), cdmCounterpartyList);
				if (legalAgreement2 == null) {
					legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
				} else {
					legalAgreementList.addAll(toBuilder(Collections.singletonList(legalAgreement2)));
				}
			} else {
				legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlDocumentation).<ContractualDefinitions>mapC("getContractualDefinitions", documentation -> documentation.getContractualDefinitions())).orNullSafe(exists(MapperS.of(fpmlDocumentation).<ContractualMatrix>mapC("getContractualMatrix", documentation -> documentation.getContractualMatrix()))).orNullSafe(exists(MapperS.of(fpmlDocumentation).<ContractualTermsSupplement>mapC("getContractualTermsSupplement", documentation -> documentation.getContractualTermsSupplement()))).getOrDefault(false)) {
				final LegalAgreement legalAgreement3 = mapConfirmationLegalAgreement.evaluate(fpmlDocumentation, cdmCounterpartyList);
				if (legalAgreement3 == null) {
					legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
				} else {
					legalAgreementList.addAll(toBuilder(Collections.singletonList(legalAgreement3)));
				}
			} else {
				legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlDocumentation).<OtherAgreement>mapC("getOtherAgreement", documentation -> documentation.getOtherAgreement())).getOrDefault(false)) {
				legalAgreementList.addAll(toBuilder(MapperS.of(fpmlDocumentation).<OtherAgreement>mapC("getOtherAgreement", documentation -> documentation.getOtherAgreement())
					.mapItem(item -> MapperS.of(mapOtherAgreements.evaluate(item.get(), cdmCounterpartyList))).getMulti()));
			} else {
				legalAgreementList.addAll(toBuilder(Collections.<LegalAgreement>emptyList()));
			}
			
			return Optional.ofNullable(legalAgreementList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
