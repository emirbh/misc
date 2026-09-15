package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.FixedRateAccrual;
import fpml.consolidated.loan.PaymentProjection;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedRateAccrualValidator implements Validator<FixedRateAccrual> {

	private List<ComparisonResult> getComparisonResults(FixedRateAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("pikSpread", (BigDecimal) o.getPikSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("numberOfDays", (Integer) o.getNumberOfDays() != null ? 1 : 0, 1, 1), 
				checkCardinality("penaltySpread", (BigDecimal) o.getPenaltySpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("defaultSpread", (BigDecimal) o.getDefaultSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryCostRate", (BigDecimal) o.getMandatoryCostRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("allInRate", (BigDecimal) o.getAllInRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentProjection", (PaymentProjection) o.getPaymentProjection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateAccrual", ValidationResult.ValidationType.CARDINALITY, "FixedRateAccrual", path, "", res.getError());
				}
				return success("FixedRateAccrual", ValidationResult.ValidationType.CARDINALITY, "FixedRateAccrual", path, "");
			})
			.collect(toList());
	}

}
