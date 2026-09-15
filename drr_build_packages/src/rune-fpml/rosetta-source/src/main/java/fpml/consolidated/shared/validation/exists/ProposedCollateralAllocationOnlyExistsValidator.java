package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProposedCollateralAllocation;
import fpml.consolidated.shared.ProposedCollateralAllocationChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ProposedCollateralAllocationOnlyExistsValidator implements ValidatorWithArg<ProposedCollateralAllocation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ProposedCollateralAllocation> ValidationResult<ProposedCollateralAllocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("allocationPartyReference", ExistenceChecker.isSet((PartyReference) o.getAllocationPartyReference()))
				.put("allocationAccountReference", ExistenceChecker.isSet((AccountReference) o.getAllocationAccountReference()))
				.put("proposedCollateralAllocationChoice", ExistenceChecker.isSet((List<? extends ProposedCollateralAllocationChoice>) o.getProposedCollateralAllocationChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ProposedCollateralAllocation", ValidationResult.ValidationType.ONLY_EXISTS, "ProposedCollateralAllocation", path, "");
		}
		return failure("ProposedCollateralAllocation", ValidationResult.ValidationType.ONLY_EXISTS, "ProposedCollateralAllocation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
