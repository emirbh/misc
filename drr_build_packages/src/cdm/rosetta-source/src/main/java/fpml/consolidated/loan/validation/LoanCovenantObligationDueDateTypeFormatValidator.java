package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationDueDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationDueDateTypeFormatValidator implements Validator<LoanCovenantObligationDueDate> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationDueDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationDueDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationDueDate", ValidationResult.ValidationType.TYPE_FORMAT, "LoanCovenantObligationDueDate", path, "", res.getError());
				}
				return success("LoanCovenantObligationDueDate", ValidationResult.ValidationType.TYPE_FORMAT, "LoanCovenantObligationDueDate", path, "");
			})
			.collect(toList());
	}

}
