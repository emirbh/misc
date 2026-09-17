package cdm.product.asset.validation;

import cdm.product.asset.FixedRateSpecification;
import cdm.product.common.schedule.RateSchedule;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedRateSpecificationValidator implements Validator<FixedRateSpecification> {

	private List<ComparisonResult> getComparisonResults(FixedRateSpecification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateSchedule", (RateSchedule) o.getRateSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateSpecification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateSpecification", ValidationResult.ValidationType.CARDINALITY, "FixedRateSpecification", path, "", res.getError());
				}
				return success("FixedRateSpecification", ValidationResult.ValidationType.CARDINALITY, "FixedRateSpecification", path, "");
			})
			.collect(toList());
	}

}
