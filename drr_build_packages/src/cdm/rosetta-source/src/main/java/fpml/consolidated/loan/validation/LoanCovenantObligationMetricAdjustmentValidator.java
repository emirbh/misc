package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationMetricAdjustment;
import fpml.consolidated.loan.MetricAdjustmentType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationMetricAdjustmentValidator implements Validator<LoanCovenantObligationMetricAdjustment> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationMetricAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (MetricAdjustmentType) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Integer) o.getAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationMetricAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationMetricAdjustment", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricAdjustment", path, "", res.getError());
				}
				return success("LoanCovenantObligationMetricAdjustment", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricAdjustment", path, "");
			})
			.collect(toList());
	}

}
