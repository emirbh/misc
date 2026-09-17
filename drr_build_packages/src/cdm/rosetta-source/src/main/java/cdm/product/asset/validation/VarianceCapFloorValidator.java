package cdm.product.asset.validation;

import cdm.product.asset.BoundedVariance;
import cdm.product.asset.VarianceCapFloor;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VarianceCapFloorValidator implements Validator<VarianceCapFloor> {

	private List<ComparisonResult> getComparisonResults(VarianceCapFloor o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("varianceCap", (Boolean) o.getVarianceCap() != null ? 1 : 0, 1, 1), 
				checkCardinality("unadjustedVarianceCap", (BigDecimal) o.getUnadjustedVarianceCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("boundedVariance", (BoundedVariance) o.getBoundedVariance() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceCapFloor o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceCapFloor", ValidationResult.ValidationType.CARDINALITY, "VarianceCapFloor", path, "", res.getError());
				}
				return success("VarianceCapFloor", ValidationResult.ValidationType.CARDINALITY, "VarianceCapFloor", path, "");
			})
			.collect(toList());
	}

}
