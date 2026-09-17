package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationMetric;
import fpml.consolidated.loan.LoanCovenantObligationMetricAdjustment;
import fpml.consolidated.loan.LoanCovenantObligationMetricCalculationDetails;
import fpml.consolidated.loan.LoanCovenantObligationMetricSequence;
import fpml.consolidated.loan.LoanCovenantObligationMetricType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationMetricValidator implements Validator<LoanCovenantObligationMetric> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationMetric o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanCovenantObligationMetricSequence", (List<? extends LoanCovenantObligationMetricSequence>) o.getLoanCovenantObligationMetricSequence() == null ? 0 : o.getLoanCovenantObligationMetricSequence().size(), 1, 2), 
				checkCardinality("metricType", (LoanCovenantObligationMetricType) o.getMetricType() != null ? 1 : 0, 1, 1), 
				checkCardinality("metricAdjustment", (LoanCovenantObligationMetricAdjustment) o.getMetricAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationDetails", (LoanCovenantObligationMetricCalculationDetails) o.getCalculationDetails() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationMetric o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationMetric", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetric", path, "", res.getError());
				}
				return success("LoanCovenantObligationMetric", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetric", path, "");
			})
			.collect(toList());
	}

}
