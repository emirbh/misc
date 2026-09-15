package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityFrequencyType;
import fpml.consolidated.com.CommodityValuationDates;
import fpml.consolidated.com.Lag;
import fpml.consolidated.com.SettlementPeriods;
import fpml.consolidated.com.SettlementPeriodsReference;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.CalendarSourceEnum;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import fpml.consolidated.fpmlenum.DayOfWeekEnum;
import fpml.consolidated.shared.AdjustableDates;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityValuationDatesOnlyExistsValidator implements ValidatorWithArg<CommodityValuationDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityValuationDates> ValidationResult<CommodityValuationDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("calculationPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getCalculationPeriodsReference()))
				.put("calculationPeriodsScheduleReference", ExistenceChecker.isSet((CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference()))
				.put("calculationPeriodsDatesReference", ExistenceChecker.isSet((CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference()))
				.put("lag", ExistenceChecker.isSet((Lag) o.getLag()))
				.put("dayType", ExistenceChecker.isSet((CommodityDayTypeEnum) o.getDayType()))
				.put("dayDistribution", ExistenceChecker.isSet((CommodityFrequencyType) o.getDayDistribution()))
				.put("dayCount", ExistenceChecker.isSet((Integer) o.getDayCount()))
				.put("dayOfWeek", ExistenceChecker.isSet((List<DayOfWeekEnum>) o.getDayOfWeek()))
				.put("dayNumber", ExistenceChecker.isSet((Integer) o.getDayNumber()))
				.put("businessDayConvention", ExistenceChecker.isSet((BusinessDayConventionEnum) o.getBusinessDayConvention()))
				.put("businessCalendar", ExistenceChecker.isSet((CommodityBusinessCalendar) o.getBusinessCalendar()))
				.put("calendarSource", ExistenceChecker.isSet((CalendarSourceEnum) o.getCalendarSource()))
				.put("settlementPeriods", ExistenceChecker.isSet((List<? extends SettlementPeriods>) o.getSettlementPeriods()))
				.put("settlementPeriodsReference", ExistenceChecker.isSet((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()))
				.put("valuationDates", ExistenceChecker.isSet((List<? extends AdjustableDates>) o.getValuationDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityValuationDates", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityValuationDates", path, "");
		}
		return failure("CommodityValuationDates", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityValuationDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
