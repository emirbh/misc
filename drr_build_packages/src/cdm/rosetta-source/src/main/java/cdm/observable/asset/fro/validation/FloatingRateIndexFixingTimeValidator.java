package cdm.observable.asset.fro.validation;

import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.observable.asset.fro.FloatingRateIndexFixingTime;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingRateIndexFixingTimeValidator implements Validator<FloatingRateIndexFixingTime> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexFixingTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("hourMinuteTime", (LocalTime) o.getHourMinuteTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCenter", (FieldWithMetaBusinessCenterEnum) o.getBusinessCenter() != null ? 1 : 0, 1, 1), 
				checkCardinality("designatedMaturity", (String) o.getDesignatedMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTimeDefinition", (String) o.getFixingTimeDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingReason", (String) o.getFixingReason() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexFixingTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexFixingTime", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexFixingTime", path, "", res.getError());
				}
				return success("FloatingRateIndexFixingTime", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexFixingTime", path, "");
			})
			.collect(toList());
	}

}
