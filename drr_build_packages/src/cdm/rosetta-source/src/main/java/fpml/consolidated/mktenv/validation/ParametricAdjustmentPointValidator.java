package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.ParametricAdjustmentPoint;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ParametricAdjustmentPointValidator implements Validator<ParametricAdjustmentPoint> {

	private List<ComparisonResult> getComparisonResults(ParametricAdjustmentPoint o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("parameterValue", (BigDecimal) o.getParameterValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustmentValue", (BigDecimal) o.getAdjustmentValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricAdjustmentPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricAdjustmentPoint", ValidationResult.ValidationType.CARDINALITY, "ParametricAdjustmentPoint", path, "", res.getError());
				}
				return success("ParametricAdjustmentPoint", ValidationResult.ValidationType.CARDINALITY, "ParametricAdjustmentPoint", path, "");
			})
			.collect(toList());
	}

}
