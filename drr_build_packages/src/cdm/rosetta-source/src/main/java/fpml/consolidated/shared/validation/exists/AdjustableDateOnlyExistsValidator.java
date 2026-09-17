package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustableDateOnlyExistsValidator implements ValidatorWithArg<AdjustableDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdjustableDate> ValidationResult<AdjustableDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("unadjustedDate", ExistenceChecker.isSet((IdentifiedDate) o.getUnadjustedDate()))
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("adjustedDate", ExistenceChecker.isSet((IdentifiedDate) o.getAdjustedDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdjustableDate", ValidationResult.ValidationType.ONLY_EXISTS, "AdjustableDate", path, "");
		}
		return failure("AdjustableDate", ValidationResult.ValidationType.ONLY_EXISTS, "AdjustableDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
