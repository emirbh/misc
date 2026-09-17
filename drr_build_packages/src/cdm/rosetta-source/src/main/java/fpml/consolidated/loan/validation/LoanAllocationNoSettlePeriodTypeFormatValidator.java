package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationNoSettlePeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNoSettlePeriodTypeFormatValidator implements Validator<LoanAllocationNoSettlePeriod> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNoSettlePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNoSettlePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNoSettlePeriod", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationNoSettlePeriod", path, "", res.getError());
				}
				return success("LoanAllocationNoSettlePeriod", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationNoSettlePeriod", path, "");
			})
			.collect(toList());
	}

}
