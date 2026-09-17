package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityFrequencyType;
import fpml.consolidated.com.CommodityValuationDates;
import fpml.consolidated.com.Lag;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.CalendarSourceEnum;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import fpml.consolidated.fpmlenum.DayOfWeekEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityValuationDatesValidator implements Validator<CommodityValuationDates> {

	private List<ComparisonResult> getComparisonResults(CommodityValuationDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsReference", (CalculationPeriodsReference) o.getCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsDatesReference", (CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("lag", (Lag) o.getLag() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayType", (CommodityDayTypeEnum) o.getDayType() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayDistribution", (CommodityFrequencyType) o.getDayDistribution() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCount", (Integer) o.getDayCount() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayOfWeek", (List<DayOfWeekEnum>) o.getDayOfWeek() == null ? 0 : o.getDayOfWeek().size(), 0, 7), 
				checkCardinality("dayNumber", (Integer) o.getDayNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessDayConvention", (BusinessDayConventionEnum) o.getBusinessDayConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCalendar", (CommodityBusinessCalendar) o.getBusinessCalendar() != null ? 1 : 0, 0, 1), 
				checkCardinality("calendarSource", (CalendarSourceEnum) o.getCalendarSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityValuationDates", ValidationResult.ValidationType.CARDINALITY, "CommodityValuationDates", path, "", res.getError());
				}
				return success("CommodityValuationDates", ValidationResult.ValidationType.CARDINALITY, "CommodityValuationDates", path, "");
			})
			.collect(toList());
	}

}
