package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationSettlementDateAvailability;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LoanAllocationSettlementDateAvailabilityTypeFormatValidator implements Validator<LoanAllocationSettlementDateAvailability> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationSettlementDateAvailability o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 1, empty(), empty()), 
				checkNumber("leadDays", o.getLeadDays(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementDateAvailability o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationSettlementDateAvailability", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationSettlementDateAvailability", path, "", res.getError());
				}
				return success("LoanAllocationSettlementDateAvailability", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationSettlementDateAvailability", path, "");
			})
			.collect(toList());
	}

}
