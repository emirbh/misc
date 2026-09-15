package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.CdePriceSchedule;
import iso20022.dtcc.rds.harmonized.CdeSchedule1;
import iso20022.dtcc.rds.harmonized.CdeSchedule2;
import iso20022.dtcc.rds.harmonized.CdeStrikePriceSchedule;
import iso20022.dtcc.rds.harmonized.Schedules;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SchedulesOnlyExistsValidator implements ValidatorWithArg<Schedules, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Schedules> ValidationResult<Schedules> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cdeNotionalSchedule1", ExistenceChecker.isSet((List<? extends CdeSchedule1>) o.getCdeNotionalSchedule1()))
				.put("cdeNotionalSchedule2", ExistenceChecker.isSet((List<? extends CdeSchedule2>) o.getCdeNotionalSchedule2()))
				.put("cdePriceSchedule", ExistenceChecker.isSet((List<? extends CdePriceSchedule>) o.getCdePriceSchedule()))
				.put("cdeStrikePriceSchedule", ExistenceChecker.isSet((List<? extends CdeStrikePriceSchedule>) o.getCdeStrikePriceSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Schedules", ValidationResult.ValidationType.ONLY_EXISTS, "Schedules", path, "");
		}
		return failure("Schedules", ValidationResult.ValidationType.ONLY_EXISTS, "Schedules", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
