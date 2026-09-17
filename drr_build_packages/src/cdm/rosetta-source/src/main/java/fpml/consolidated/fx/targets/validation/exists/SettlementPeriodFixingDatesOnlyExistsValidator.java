package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementPeriodFixingDatesOnlyExistsValidator implements ValidatorWithArg<SettlementPeriodFixingDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPeriodFixingDates> ValidationResult<SettlementPeriodFixingDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixingDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getFixingDate()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("numberOfFixings", ExistenceChecker.isSet((Integer) o.getNumberOfFixings()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPeriodFixingDates", ValidationResult.ValidationType.ONLY_EXISTS, "SettlementPeriodFixingDates", path, "");
		}
		return failure("SettlementPeriodFixingDates", ValidationResult.ValidationType.ONLY_EXISTS, "SettlementPeriodFixingDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
