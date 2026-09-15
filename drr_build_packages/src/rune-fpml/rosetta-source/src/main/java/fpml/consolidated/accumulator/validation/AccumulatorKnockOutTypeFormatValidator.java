package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.AccumulatorKnockOut;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class AccumulatorKnockOutTypeFormatValidator implements Validator<AccumulatorKnockOut> {

	private List<ComparisonResult> getComparisonResults(AccumulatorKnockOut o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("targetPerformance", o.getTargetPerformance(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccumulatorKnockOut o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccumulatorKnockOut", ValidationResult.ValidationType.TYPE_FORMAT, "AccumulatorKnockOut", path, "", res.getError());
				}
				return success("AccumulatorKnockOut", ValidationResult.ValidationType.TYPE_FORMAT, "AccumulatorKnockOut", path, "");
			})
			.collect(toList());
	}

}
