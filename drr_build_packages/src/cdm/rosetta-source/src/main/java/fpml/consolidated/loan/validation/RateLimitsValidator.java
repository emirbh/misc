package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.PeriodRate;
import fpml.consolidated.loan.RateLimits;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RateLimitsValidator implements Validator<RateLimits> {

	private List<ComparisonResult> getComparisonResults(RateLimits o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floorRate", (PeriodRate) o.getFloorRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("capRate", (PeriodRate) o.getCapRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateLimits o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RateLimits", ValidationResult.ValidationType.CARDINALITY, "RateLimits", path, "", res.getError());
				}
				return success("RateLimits", ValidationResult.ValidationType.CARDINALITY, "RateLimits", path, "");
			})
			.collect(toList());
	}

}
