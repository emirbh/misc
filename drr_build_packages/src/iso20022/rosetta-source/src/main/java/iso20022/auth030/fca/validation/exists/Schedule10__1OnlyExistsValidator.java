package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.Schedule10__1;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Schedule10__1OnlyExistsValidator implements ValidatorWithArg<Schedule10__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Schedule10__1> ValidationResult<Schedule10__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("qty", ExistenceChecker.isSet((BigDecimal) o.getQty()))
				.put("uadjstdFctvDt", ExistenceChecker.isSet((Date) o.getUadjstdFctvDt()))
				.put("uadjstdEndDt", ExistenceChecker.isSet((Date) o.getUadjstdEndDt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Schedule10__1", ValidationResult.ValidationType.ONLY_EXISTS, "Schedule10__1", path, "");
		}
		return failure("Schedule10__1", ValidationResult.ValidationType.ONLY_EXISTS, "Schedule10__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
