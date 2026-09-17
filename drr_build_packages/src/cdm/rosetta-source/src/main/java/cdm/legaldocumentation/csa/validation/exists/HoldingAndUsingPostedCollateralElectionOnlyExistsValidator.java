package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.EligibilityToHoldCollateral;
import cdm.legaldocumentation.csa.HoldingAndUsingPostedCollateralElection;
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

public class HoldingAndUsingPostedCollateralElectionOnlyExistsValidator implements ValidatorWithArg<HoldingAndUsingPostedCollateralElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends HoldingAndUsingPostedCollateralElection> ValidationResult<HoldingAndUsingPostedCollateralElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("eligibilityToHoldCollateral", ExistenceChecker.isSet((EligibilityToHoldCollateral) o.getEligibilityToHoldCollateral()))
				.put("useOfPostedCollateral", ExistenceChecker.isSet((Boolean) o.getUseOfPostedCollateral()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("HoldingAndUsingPostedCollateralElection", ValidationResult.ValidationType.ONLY_EXISTS, "HoldingAndUsingPostedCollateralElection", path, "");
		}
		return failure("HoldingAndUsingPostedCollateralElection", ValidationResult.ValidationType.ONLY_EXISTS, "HoldingAndUsingPostedCollateralElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
