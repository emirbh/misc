package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LetterOfCredit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditTypeFormatValidator implements Validator<LetterOfCredit> {

	private List<ComparisonResult> getComparisonResults(LetterOfCredit o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCredit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCredit", ValidationResult.ValidationType.TYPE_FORMAT, "LetterOfCredit", path, "", res.getError());
				}
				return success("LetterOfCredit", ValidationResult.ValidationType.TYPE_FORMAT, "LetterOfCredit", path, "");
			})
			.collect(toList());
	}

}
