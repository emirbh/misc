package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxFlexibleForwardExecutionPeriod;
import fpml.consolidated.shared.BusinessCenters;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxFlexibleForwardExecutionPeriodValidator implements Validator<FxFlexibleForwardExecutionPeriod> {

	private List<ComparisonResult> getComparisonResults(FxFlexibleForwardExecutionPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryDate", (ZonedDateTime) o.getExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFlexibleForwardExecutionPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFlexibleForwardExecutionPeriod", ValidationResult.ValidationType.CARDINALITY, "FxFlexibleForwardExecutionPeriod", path, "", res.getError());
				}
				return success("FxFlexibleForwardExecutionPeriod", ValidationResult.ValidationType.CARDINALITY, "FxFlexibleForwardExecutionPeriod", path, "");
			})
			.collect(toList());
	}

}
