package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateRange;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.RelativeDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelativeDatesValidator implements Validator<RelativeDates> {

	private List<ComparisonResult> getComparisonResults(RelativeDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodEnum) o.getPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayType", (DayTypeEnum) o.getDayType() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessDayConvention", (BusinessDayConventionEnum) o.getBusinessDayConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateRelativeTo", (DateReference) o.getDateRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedDate", (IdentifiedDate) o.getAdjustedDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodSkip", (Integer) o.getPeriodSkip() != null ? 1 : 0, 0, 1), 
				checkCardinality("scheduleBounds", (DateRange) o.getScheduleBounds() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativeDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelativeDates", ValidationResult.ValidationType.CARDINALITY, "RelativeDates", path, "", res.getError());
				}
				return success("RelativeDates", ValidationResult.ValidationType.CARDINALITY, "RelativeDates", path, "");
			})
			.collect(toList());
	}

}
