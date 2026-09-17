package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationMetricType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationMetricTypeValidator implements Validator<LoanCovenantObligationMetricType> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationMetricType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanCovenantObligationMetricTypeScheme", (String) o.getLoanCovenantObligationMetricTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationMetricType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationMetricType", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricType", path, "", res.getError());
				}
				return success("LoanCovenantObligationMetricType", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricType", path, "");
			})
			.collect(toList());
	}

}
