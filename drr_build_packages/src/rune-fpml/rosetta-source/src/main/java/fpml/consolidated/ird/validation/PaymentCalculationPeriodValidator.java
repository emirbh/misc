package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PaymentCalculationPeriod;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaymentCalculationPeriodValidator implements Validator<PaymentCalculationPeriod> {

	private List<ComparisonResult> getComparisonResults(PaymentCalculationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedPaymentDate", (ZonedDateTime) o.getUnadjustedPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedPaymentDate", (ZonedDateTime) o.getAdjustedPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPaymentAmount", (BigDecimal) o.getFixedPaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("discountFactor", (BigDecimal) o.getDiscountFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("forecastPaymentAmount", (Money) o.getForecastPaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("presentValueAmount", (Money) o.getPresentValueAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentCalculationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentCalculationPeriod", ValidationResult.ValidationType.CARDINALITY, "PaymentCalculationPeriod", path, "", res.getError());
				}
				return success("PaymentCalculationPeriod", ValidationResult.ValidationType.CARDINALITY, "PaymentCalculationPeriod", path, "");
			})
			.collect(toList());
	}

}
