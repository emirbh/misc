package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.SettlementPeriods;
import fpml.consolidated.fpmlenum.DayOfWeekExtEnum;
import fpml.consolidated.fpmlenum.SettlementPeriodDurationEnum;
import fpml.consolidated.shared.OffsetPrevailingTime;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsValidator implements Validator<SettlementPeriods> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("duration", (SettlementPeriodDurationEnum) o.getDuration() != null ? 1 : 0, 0, 1), 
				checkCardinality("applicableDay", (List<DayOfWeekExtEnum>) o.getApplicableDay() == null ? 0 : o.getApplicableDay().size(), 0, 7), 
				checkCardinality("startTime", (OffsetPrevailingTime) o.getStartTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("endTime", (OffsetPrevailingTime) o.getEndTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("timeDuration", (LocalTime) o.getTimeDuration() != null ? 1 : 0, 0, 1), 
				checkCardinality("excludeHolidays", (CommodityBusinessCalendar) o.getExcludeHolidays() != null ? 1 : 0, 0, 1), 
				checkCardinality("includeHolidays", (CommodityBusinessCalendar) o.getIncludeHolidays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriods", ValidationResult.ValidationType.CARDINALITY, "SettlementPeriods", path, "", res.getError());
				}
				return success("SettlementPeriods", ValidationResult.ValidationType.CARDINALITY, "SettlementPeriods", path, "");
			})
			.collect(toList());
	}

}
