package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.common.CreditSupportDocumentTermsEnum;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.csa.CreditSupportDocumentElection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditSupportDocumentElectionOnlyExistsValidator implements ValidatorWithArg<CreditSupportDocumentElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditSupportDocumentElection> ValidationResult<CreditSupportDocumentElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((Party) o.getParty()))
				.put("creditSupportDocumentTerms", ExistenceChecker.isSet((CreditSupportDocumentTermsEnum) o.getCreditSupportDocumentTerms()))
				.put("creditSupportDocumentTypes", ExistenceChecker.isSet((List<? extends LegalAgreementIdentification>) o.getCreditSupportDocumentTypes()))
				.put("creditSupportDocument", ExistenceChecker.isSet((List<? extends LegalAgreement>) o.getCreditSupportDocument()))
				.put("bespokeCreditSuppportDocument", ExistenceChecker.isSet((String) o.getBespokeCreditSuppportDocument()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportDocumentElection", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportDocumentElection", path, "");
		}
		return failure("CreditSupportDocumentElection", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportDocumentElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
