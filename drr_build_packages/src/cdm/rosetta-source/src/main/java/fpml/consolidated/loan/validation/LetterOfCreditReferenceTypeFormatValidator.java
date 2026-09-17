package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LetterOfCreditReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditReferenceTypeFormatValidator implements Validator<LetterOfCreditReference> {

	private List<ComparisonResult> getComparisonResults(LetterOfCreditReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCreditReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCreditReference", ValidationResult.ValidationType.TYPE_FORMAT, "LetterOfCreditReference", path, "", res.getError());
				}
				return success("LetterOfCreditReference", ValidationResult.ValidationType.TYPE_FORMAT, "LetterOfCreditReference", path, "");
			})
			.collect(toList());
	}

}
