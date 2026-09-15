package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationReferenceTypeFormatValidator implements Validator<LoanAllocationReference> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationReference", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationReference", path, "", res.getError());
				}
				return success("LoanAllocationReference", ValidationResult.ValidationType.TYPE_FORMAT, "LoanAllocationReference", path, "");
			})
			.collect(toList());
	}

}
