package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractLoanFloatingRateOptionBase;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.LoanFloatingRate;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractLoanFloatingRateOptionBaseValidator implements Validator<AbstractLoanFloatingRateOptionBase> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanFloatingRateOptionBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (LoanFloatingRate) o.getRate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanFloatingRateOptionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanFloatingRateOptionBase", ValidationResult.ValidationType.CARDINALITY, "AbstractLoanFloatingRateOptionBase", path, "", res.getError());
				}
				return success("AbstractLoanFloatingRateOptionBase", ValidationResult.ValidationType.CARDINALITY, "AbstractLoanFloatingRateOptionBase", path, "");
			})
			.collect(toList());
	}

}
