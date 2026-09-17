package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.CollateralManagementAgreementElection;
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

public class CollateralManagementAgreementElectionOnlyExistsValidator implements ValidatorWithArg<CollateralManagementAgreementElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralManagementAgreementElection> ValidationResult<CollateralManagementAgreementElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("collateralManagementAgreement", ExistenceChecker.isSet((String) o.getCollateralManagementAgreement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralManagementAgreementElection", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralManagementAgreementElection", path, "");
		}
		return failure("CollateralManagementAgreementElection", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralManagementAgreementElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
