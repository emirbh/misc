package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PaymentDetail;
import fpml.consolidated.shared.PaymentRule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaymentDetailValidator implements Validator<PaymentDetail> {

	private List<ComparisonResult> getComparisonResults(PaymentDetail o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDate", (AdjustableOrRelativeDate) o.getPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentRule", (PaymentRule) o.getPaymentRule() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentAmount", (Money) o.getPaymentAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDetail o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDetail", ValidationResult.ValidationType.CARDINALITY, "PaymentDetail", path, "", res.getError());
				}
				return success("PaymentDetail", ValidationResult.ValidationType.CARDINALITY, "PaymentDetail", path, "");
			})
			.collect(toList());
	}

}
