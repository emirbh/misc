package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.SettlementPeriods;
import fpml.consolidated.fpmlenum.DayOfWeekExtEnum;
import fpml.consolidated.fpmlenum.SettlementPeriodDurationEnum;
import fpml.consolidated.shared.OffsetPrevailingTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementPeriodsOnlyExistsValidator implements ValidatorWithArg<SettlementPeriods, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPeriods> ValidationResult<SettlementPeriods> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("duration", ExistenceChecker.isSet((SettlementPeriodDurationEnum) o.getDuration()))
				.put("applicableDay", ExistenceChecker.isSet((List<DayOfWeekExtEnum>) o.getApplicableDay()))
				.put("startTime", ExistenceChecker.isSet((OffsetPrevailingTime) o.getStartTime()))
				.put("endTime", ExistenceChecker.isSet((OffsetPrevailingTime) o.getEndTime()))
				.put("timeDuration", ExistenceChecker.isSet((LocalTime) o.getTimeDuration()))
				.put("excludeHolidays", ExistenceChecker.isSet((CommodityBusinessCalendar) o.getExcludeHolidays()))
				.put("includeHolidays", ExistenceChecker.isSet((CommodityBusinessCalendar) o.getIncludeHolidays()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPeriods", ValidationResult.ValidationType.ONLY_EXISTS, "SettlementPeriods", path, "");
		}
		return failure("SettlementPeriods", ValidationResult.ValidationType.ONLY_EXISTS, "SettlementPeriods", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
