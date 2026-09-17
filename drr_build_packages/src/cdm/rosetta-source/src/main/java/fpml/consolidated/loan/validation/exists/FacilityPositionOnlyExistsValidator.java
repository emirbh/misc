package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.FacilityPosition;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.OutstandingsPosition;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityPositionOnlyExistsValidator implements ValidatorWithArg<FacilityPosition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityPosition> ValidationResult<FacilityPosition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("commitment", ExistenceChecker.isSet((FacilityCommitment) o.getCommitment()))
				.put("priorCommitment", ExistenceChecker.isSet((FacilityCommitment) o.getPriorCommitment()))
				.put("outstandingsPosition", ExistenceChecker.isSet((List<? extends OutstandingsPosition>) o.getOutstandingsPosition()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityPosition", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityPosition", path, "");
		}
		return failure("FacilityPosition", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityPosition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
