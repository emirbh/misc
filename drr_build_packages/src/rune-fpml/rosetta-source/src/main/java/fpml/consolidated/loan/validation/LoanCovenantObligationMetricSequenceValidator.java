package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LoanCovenantObligationMetricValueTypeEnum;
import fpml.consolidated.loan.LoanCovenantObligationMetricSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationMetricSequenceValidator implements Validator<LoanCovenantObligationMetricSequence> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationMetricSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("valueType", (LoanCovenantObligationMetricValueTypeEnum) o.getValueType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationMetricSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationMetricSequence", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricSequence", path, "", res.getError());
				}
				return success("LoanCovenantObligationMetricSequence", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationMetricSequence", path, "");
			})
			.collect(toList());
	}

}
