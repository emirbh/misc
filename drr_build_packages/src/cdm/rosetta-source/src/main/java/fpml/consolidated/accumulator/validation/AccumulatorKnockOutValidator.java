package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.AccumulatorKnockOut;
import fpml.consolidated.fpmlenum.TriggerTimeTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AccumulatorKnockOutValidator implements Validator<AccumulatorKnockOut> {

	private List<ComparisonResult> getComparisonResults(AccumulatorKnockOut o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("targetPerformance", (BigDecimal) o.getTargetPerformance() != null ? 1 : 0, 0, 1), 
				checkCardinality("level", (BigDecimal) o.getLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerTimeType", (TriggerTimeTypeEnum) o.getTriggerTimeType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccumulatorKnockOut o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccumulatorKnockOut", ValidationResult.ValidationType.CARDINALITY, "AccumulatorKnockOut", path, "", res.getError());
				}
				return success("AccumulatorKnockOut", ValidationResult.ValidationType.CARDINALITY, "AccumulatorKnockOut", path, "");
			})
			.collect(toList());
	}

}
