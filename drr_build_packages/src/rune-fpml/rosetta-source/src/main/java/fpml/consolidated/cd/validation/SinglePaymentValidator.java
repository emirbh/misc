package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.SinglePayment;
import fpml.consolidated.shared.Money;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SinglePaymentValidator implements Validator<SinglePayment> {

	private List<ComparisonResult> getComparisonResults(SinglePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustablePaymentDate", (ZonedDateTime) o.getAdjustablePaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedPaymentDate", (ZonedDateTime) o.getAdjustedPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedAmount", (Money) o.getFixedAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SinglePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SinglePayment", ValidationResult.ValidationType.CARDINALITY, "SinglePayment", path, "", res.getError());
				}
				return success("SinglePayment", ValidationResult.ValidationType.CARDINALITY, "SinglePayment", path, "");
			})
			.collect(toList());
	}

}
