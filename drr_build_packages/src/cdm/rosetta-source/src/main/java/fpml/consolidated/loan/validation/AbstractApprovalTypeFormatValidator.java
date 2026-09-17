package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractApproval;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractApprovalTypeFormatValidator implements Validator<AbstractApproval> {

	private List<ComparisonResult> getComparisonResults(AbstractApproval o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractApproval o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractApproval", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractApproval", path, "", res.getError());
				}
				return success("AbstractApproval", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractApproval", path, "");
			})
			.collect(toList());
	}

}
