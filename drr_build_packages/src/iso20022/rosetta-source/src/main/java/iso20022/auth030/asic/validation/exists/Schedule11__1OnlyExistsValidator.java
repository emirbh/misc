package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.AmountAndDirection106__2;
import iso20022.auth030.asic.Schedule11__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Schedule11__1OnlyExistsValidator implements ValidatorWithArg<Schedule11__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Schedule11__1> ValidationResult<Schedule11__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("uadjstdFctvDt", ExistenceChecker.isSet((Date) o.getUadjstdFctvDt()))
				.put("uadjstdEndDt", ExistenceChecker.isSet((Date) o.getUadjstdEndDt()))
				.put("amt", ExistenceChecker.isSet((AmountAndDirection106__2) o.getAmt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Schedule11__1", ValidationResult.ValidationType.ONLY_EXISTS, "Schedule11__1", path, "");
		}
		return failure("Schedule11__1", ValidationResult.ValidationType.ONLY_EXISTS, "Schedule11__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
