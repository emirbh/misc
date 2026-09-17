package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationNoSettlePeriod;
import fpml.consolidated.loan.LoanAllocationNoSettlePeriodType;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNoSettlePeriodValidator implements Validator<LoanAllocationNoSettlePeriod> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNoSettlePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodType", (LoanAllocationNoSettlePeriodType) o.getPeriodType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNoSettlePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNoSettlePeriod", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNoSettlePeriod", path, "", res.getError());
				}
				return success("LoanAllocationNoSettlePeriod", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNoSettlePeriod", path, "");
			})
			.collect(toList());
	}

}
