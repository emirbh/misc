package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.AccrualReferenceAmountTypeEnum;
import fpml.consolidated.loan.AccrualPeriod;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.RateAdjustment;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AccrualPeriodValidator implements Validator<AccrualPeriod> {

	private List<ComparisonResult> getComparisonResults(AccrualPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("numberOfDays", (Integer) o.getNumberOfDays() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceAmount", (MoneyWithParticipantShare) o.getReferenceAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceAmountType", (AccrualReferenceAmountTypeEnum) o.getReferenceAmountType() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("baseRate", (BigDecimal) o.getBaseRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("compoundedRate", (BigDecimal) o.getCompoundedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadAdjustment", (BigDecimal) o.getSpreadAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateAdjustment", (RateAdjustment) o.getRateAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualAmount", (MoneyWithParticipantShare) o.getAccrualAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualPeriod", ValidationResult.ValidationType.CARDINALITY, "AccrualPeriod", path, "", res.getError());
				}
				return success("AccrualPeriod", ValidationResult.ValidationType.CARDINALITY, "AccrualPeriod", path, "");
			})
			.collect(toList());
	}

}
