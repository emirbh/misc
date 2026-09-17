package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.PayRelativeToEnum;
import fpml.consolidated.ird.CalculationPeriodDatesReference;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.ird.ResetDatesReference;
import fpml.consolidated.ird.ValuationDatesReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Offset;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaymentDatesValidator implements Validator<PaymentDates> {

	private List<ComparisonResult> getComparisonResults(PaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodDatesReference", (CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetDatesReference", (ResetDatesReference) o.getResetDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDatesReference", (ValuationDatesReference) o.getValuationDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentFrequency", (Frequency) o.getPaymentFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("firstPaymentDate", (ZonedDateTime) o.getFirstPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastRegularPaymentDate", (ZonedDateTime) o.getLastRegularPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("payRelativeTo", (PayRelativeToEnum) o.getPayRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDaysOffset", (Offset) o.getPaymentDaysOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDatesAdjustments", (BusinessDayAdjustments) o.getPaymentDatesAdjustments() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDates", ValidationResult.ValidationType.CARDINALITY, "PaymentDates", path, "", res.getError());
				}
				return success("PaymentDates", ValidationResult.ValidationType.CARDINALITY, "PaymentDates", path, "");
			})
			.collect(toList());
	}

}
