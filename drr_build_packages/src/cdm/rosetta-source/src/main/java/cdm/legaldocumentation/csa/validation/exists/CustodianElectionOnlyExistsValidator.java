package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.csa.CustodianElection;
import cdm.legaldocumentation.csa.LegacyVMCustodianEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CustodianElectionOnlyExistsValidator implements ValidatorWithArg<CustodianElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CustodianElection> ValidationResult<CustodianElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("custodian", ExistenceChecker.isSet((LegalEntity) o.getCustodian()))
				.put("segregatedCashAccount", ExistenceChecker.isSet((Account) o.getSegregatedCashAccount()))
				.put("segregatedSecurityAccount", ExistenceChecker.isSet((Account) o.getSegregatedSecurityAccount()))
				.put("legacyVMCustodian", ExistenceChecker.isSet((LegacyVMCustodianEnum) o.getLegacyVMCustodian()))
				.put("legacyNamedEntity", ExistenceChecker.isSet((LegalEntity) o.getLegacyNamedEntity()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustodianElection", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianElection", path, "");
		}
		return failure("CustodianElection", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
