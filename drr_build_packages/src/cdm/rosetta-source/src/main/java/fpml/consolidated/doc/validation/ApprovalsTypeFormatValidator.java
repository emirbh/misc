package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.Approvals;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApprovalsTypeFormatValidator implements Validator<Approvals> {

	private List<ComparisonResult> getComparisonResults(Approvals o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Approvals o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Approvals", ValidationResult.ValidationType.TYPE_FORMAT, "Approvals", path, "", res.getError());
				}
				return success("Approvals", ValidationResult.ValidationType.TYPE_FORMAT, "Approvals", path, "");
			})
			.collect(toList());
	}

}
