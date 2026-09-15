package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.FixedAmountCalculation;
import fpml.consolidated.cd.FloatingAmountCalculation;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.fpmlenum.RollConventionEnum;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Period;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PeriodicPaymentValidator implements Validator<PeriodicPayment> {

	private List<ComparisonResult> getComparisonResults(PeriodicPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstPeriodStartDate", (ZonedDateTime) o.getFirstPeriodStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstPaymentDate", (ZonedDateTime) o.getFirstPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastRegularPaymentDate", (ZonedDateTime) o.getLastRegularPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("rollConvention", (RollConventionEnum) o.getRollConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedAmount", (Money) o.getFixedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedAmountCalculation", (FixedAmountCalculation) o.getFixedAmountCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingAmountCalculation", (FloatingAmountCalculation) o.getFloatingAmountCalculation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodicPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodicPayment", ValidationResult.ValidationType.CARDINALITY, "PeriodicPayment", path, "", res.getError());
				}
				return success("PeriodicPayment", ValidationResult.ValidationType.CARDINALITY, "PeriodicPayment", path, "");
			})
			.collect(toList());
	}

}
