package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalPartiesChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApprovalPartiesChoiceTypeFormatValidator implements Validator<ApprovalPartiesChoice> {

	private List<ComparisonResult> getComparisonResults(ApprovalPartiesChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalPartiesChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApprovalPartiesChoice", ValidationResult.ValidationType.TYPE_FORMAT, "ApprovalPartiesChoice", path, "", res.getError());
				}
				return success("ApprovalPartiesChoice", ValidationResult.ValidationType.TYPE_FORMAT, "ApprovalPartiesChoice", path, "");
			})
			.collect(toList());
	}

}
