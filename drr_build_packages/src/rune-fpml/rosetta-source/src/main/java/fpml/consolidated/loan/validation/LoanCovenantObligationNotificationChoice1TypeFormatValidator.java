package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationNotificationChoice1TypeFormatValidator implements Validator<LoanCovenantObligationNotificationChoice1> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationNotificationChoice1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationNotificationChoice1", ValidationResult.ValidationType.TYPE_FORMAT, "LoanCovenantObligationNotificationChoice1", path, "", res.getError());
				}
				return success("LoanCovenantObligationNotificationChoice1", ValidationResult.ValidationType.TYPE_FORMAT, "LoanCovenantObligationNotificationChoice1", path, "");
			})
			.collect(toList());
	}

}
