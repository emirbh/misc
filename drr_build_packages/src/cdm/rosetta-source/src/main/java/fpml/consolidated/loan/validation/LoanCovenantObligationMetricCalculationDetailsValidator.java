package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FinancialMetric;
import fpml.consolidated.loan.LoanCovenantObligationMetricCalculationDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationMetricCalculationDetailsValidator implements Validator<LoanCovenantObligationMetricCalculationDetails> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationMetricCalculationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("numeratorType", (List<? extends FinancialMetric>) o.getNumeratorType() == null ? 0 : o.getNumeratorType().size(), 1, 0), 
				checkCardinality("denominatorType", (List<? extends FinancialMetric>) o.getDenominatorType() == null ? 0 : o.getDenominatorType().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationMetricCalculationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationMetricCalculationDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricCalculationDetails", path, "", res.getError());
				}
				return success("LoanCovenantObligationMetricCalculationDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricCalculationDetails", path, "");
			})
			.collect(toList());
	}

}
