package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.common.CreditSupportProviderTermsEnum;
import cdm.legaldocumentation.csa.CreditSupportProviderElection;
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

public class CreditSupportProviderElectionOnlyExistsValidator implements ValidatorWithArg<CreditSupportProviderElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditSupportProviderElection> ValidationResult<CreditSupportProviderElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((Party) o.getParty()))
				.put("creditSupportProviderTerms", ExistenceChecker.isSet((CreditSupportProviderTermsEnum) o.getCreditSupportProviderTerms()))
				.put("creditSupportProvider", ExistenceChecker.isSet((List<? extends LegalEntity>) o.getCreditSupportProvider()))
				.put("bespokeCreditSuppportProvider", ExistenceChecker.isSet((String) o.getBespokeCreditSuppportProvider()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportProviderElection", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportProviderElection", path, "");
		}
		return failure("CreditSupportProviderElection", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportProviderElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
