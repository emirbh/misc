package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.targets.FxDateOffset;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxExpiryScheduleValidator implements Validator<FxExpirySchedule> {

	private List<ComparisonResult> getComparisonResults(FxExpirySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationFrequency", (ObservationFrequency) o.getObservationFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayType", (DayTypeEnum) o.getDayType() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateOffset", (FxDateOffset) o.getDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalExpiryDate", (ZonedDateTime) o.getFinalExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryTime", (BusinessCenterTime) o.getExpiryTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExpirySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExpirySchedule", ValidationResult.ValidationType.CARDINALITY, "FxExpirySchedule", path, "", res.getError());
				}
				return success("FxExpirySchedule", ValidationResult.ValidationType.CARDINALITY, "FxExpirySchedule", path, "");
			})
			.collect(toList());
	}

}
