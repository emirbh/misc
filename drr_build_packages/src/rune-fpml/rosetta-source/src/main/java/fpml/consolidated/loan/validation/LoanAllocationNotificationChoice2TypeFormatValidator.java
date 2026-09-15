package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationNotificationChoice2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNotificationChoice2TypeFormatValidator implements Validator<LoanAllocationNotificationChoice2> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNotificationChoice2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNotificationChoice2", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationNotificationChoice2", path, "", res.getError());
				}
				return success("LoanAllocationNotificationChoice2", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationNotificationChoice2", path, "");
			})
			.collect(toList());
	}

}
