package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalActionNotificationChoiceChoice2TypeFormatValidator implements Validator<LoanLegalActionNotificationChoiceChoice2> {

	private List<ComparisonResult> getComparisonResults(LoanLegalActionNotificationChoiceChoice2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoiceChoice2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalActionNotificationChoiceChoice2", ValidationResult.ValidationType.TYPE_FORMAT, "LoanLegalActionNotificationChoiceChoice2", path, "", res.getError());
				}
				return success("LoanLegalActionNotificationChoiceChoice2", ValidationResult.ValidationType.TYPE_FORMAT, "LoanLegalActionNotificationChoiceChoice2", path, "");
			})
			.collect(toList());
	}

}
