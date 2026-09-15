package fpml.consolidated.clearing.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.clearing.processes.ClearingRequirements;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingRequirementsOnlyExistsValidator implements ValidatorWithArg<ClearingRequirements, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingRequirements> ValidationResult<ClearingRequirements> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((SupervisoryBody) o.getSupervisoryBody()))
				.put("mandatorilyClearable", ExistenceChecker.isSet((Boolean) o.getMandatorilyClearable()))
				.put("reason", ExistenceChecker.isSet((List<? extends Reason>) o.getReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingRequirements", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingRequirements", path, "");
		}
		return failure("ClearingRequirements", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingRequirements", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
