package drr.base.util.datetime.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.util.datetime.ValuePeriodBase;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuePeriodBaseOnlyExistsValidator implements ValidatorWithArg<ValuePeriodBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuePeriodBase> ValidationResult<ValuePeriodBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("endDate", ExistenceChecker.isSet((Date) o.getEndDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuePeriodBase", ValidationResult.ValidationType.ONLY_EXISTS, "ValuePeriodBase", path, "");
		}
		return failure("ValuePeriodBase", ValidationResult.ValidationType.ONLY_EXISTS, "ValuePeriodBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
