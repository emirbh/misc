package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LetterOfCreditSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditSummaryTypeFormatValidator implements Validator<LetterOfCreditSummary> {

	private List<ComparisonResult> getComparisonResults(LetterOfCreditSummary o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCreditSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCreditSummary", ValidationResult.ValidationType.TYPE_FORMAT, "LetterOfCreditSummary", path, "", res.getError());
				}
				return success("LetterOfCreditSummary", ValidationResult.ValidationType.TYPE_FORMAT, "LetterOfCreditSummary", path, "");
			})
			.collect(toList());
	}

}
