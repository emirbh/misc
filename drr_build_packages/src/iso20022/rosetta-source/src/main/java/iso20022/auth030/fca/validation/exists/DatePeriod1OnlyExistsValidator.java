package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.DatePeriod1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DatePeriod1OnlyExistsValidator implements ValidatorWithArg<DatePeriod1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DatePeriod1> ValidationResult<DatePeriod1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("frDt", ExistenceChecker.isSet((Date) o.getFrDt()))
				.put("toDt", ExistenceChecker.isSet((Date) o.getToDt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DatePeriod1", ValidationResult.ValidationType.ONLY_EXISTS, "DatePeriod1", path, "");
		}
		return failure("DatePeriod1", ValidationResult.ValidationType.ONLY_EXISTS, "DatePeriod1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
