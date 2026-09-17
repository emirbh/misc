package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RelativeDateSequenceOnlyExistsValidator implements ValidatorWithArg<RelativeDateSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RelativeDateSequence> ValidationResult<RelativeDateSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dateRelativeTo", ExistenceChecker.isSet((DateReference) o.getDateRelativeTo()))
				.put("dateOffset", ExistenceChecker.isSet((List<? extends DateOffset>) o.getDateOffset()))
				.put("businessCentersReference", ExistenceChecker.isSet((BusinessCentersReference) o.getBusinessCentersReference()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RelativeDateSequence", ValidationResult.ValidationType.ONLY_EXISTS, "RelativeDateSequence", path, "");
		}
		return failure("RelativeDateSequence", ValidationResult.ValidationType.ONLY_EXISTS, "RelativeDateSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
