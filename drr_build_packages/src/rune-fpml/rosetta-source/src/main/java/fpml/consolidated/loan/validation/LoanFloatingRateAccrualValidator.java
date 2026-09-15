package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.LoanFloatingRate;
import fpml.consolidated.loan.LoanFloatingRateAccrual;
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

public class LoanFloatingRateAccrualValidator implements Validator<LoanFloatingRateAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanFloatingRateAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (LoanFloatingRate) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("numberOfDays", (Integer) o.getNumberOfDays() != null ? 1 : 0, 1, 1), 
				checkCardinality("rateEffectiveDate", (ZonedDateTime) o.getRateEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("baseRate", (BigDecimal) o.getBaseRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("pikSpread", (BigDecimal) o.getPikSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("fundingLossSpread", (BigDecimal) o.getFundingLossSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("defaultSpread", (BigDecimal) o.getDefaultSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryCostRate", (BigDecimal) o.getMandatoryCostRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("allInRate", (BigDecimal) o.getAllInRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanFloatingRateAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanFloatingRateAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanFloatingRateAccrual", path, "", res.getError());
				}
				return success("LoanFloatingRateAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanFloatingRateAccrual", path, "");
			})
			.collect(toList());
	}

}
