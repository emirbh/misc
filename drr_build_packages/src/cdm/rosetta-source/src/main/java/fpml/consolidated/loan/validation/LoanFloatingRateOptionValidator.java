package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.LoanFloatingRate;
import fpml.consolidated.loan.LoanFloatingRateOption;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanFloatingRateOptionValidator implements Validator<LoanFloatingRateOption> {

	private List<ComparisonResult> getComparisonResults(LoanFloatingRateOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (LoanFloatingRate) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("drawdownNoticeDays", (Integer) o.getDrawdownNoticeDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxRateSetNoticeDays", (Integer) o.getFxRateSetNoticeDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateSetNoticeDays", (Integer) o.getRateSetNoticeDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanFloatingRateOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanFloatingRateOption", ValidationResult.ValidationType.CARDINALITY, "LoanFloatingRateOption", path, "", res.getError());
				}
				return success("LoanFloatingRateOption", ValidationResult.ValidationType.CARDINALITY, "LoanFloatingRateOption", path, "");
			})
			.collect(toList());
	}

}
