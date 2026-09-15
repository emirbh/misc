package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.PaymentProjection;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaymentProjectionValidator implements Validator<PaymentProjection> {

	private List<ComparisonResult> getComparisonResults(PaymentProjection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nextPaymentDate", (ZonedDateTime) o.getNextPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("projectedAmount", (MoneyWithParticipantShare) o.getProjectedAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentProjection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentProjection", ValidationResult.ValidationType.CARDINALITY, "PaymentProjection", path, "", res.getError());
				}
				return success("PaymentProjection", ValidationResult.ValidationType.CARDINALITY, "PaymentProjection", path, "");
			})
			.collect(toList());
	}

}
