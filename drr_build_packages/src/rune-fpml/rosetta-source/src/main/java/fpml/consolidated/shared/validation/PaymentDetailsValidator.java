package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.GrossCashflow;
import fpml.consolidated.shared.PaymentDetails;
import fpml.consolidated.shared.PaymentReference;
import fpml.consolidated.shared.SettlementInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaymentDetailsValidator implements Validator<PaymentDetails> {

	private List<ComparisonResult> getComparisonResults(PaymentDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentReference", (PaymentReference) o.getPaymentReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("grossCashflow", (List<? extends GrossCashflow>) o.getGrossCashflow() == null ? 0 : o.getGrossCashflow().size(), 1, 0), 
				checkCardinality("settlementInformation", (SettlementInformation) o.getSettlementInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDetails", ValidationResult.ValidationType.CARDINALITY, "PaymentDetails", path, "", res.getError());
				}
				return success("PaymentDetails", ValidationResult.ValidationType.CARDINALITY, "PaymentDetails", path, "");
			})
			.collect(toList());
	}

}
