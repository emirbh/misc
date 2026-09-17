package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ReturnSwapNotionalAmountReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnSwapNotionalAmountReferenceTypeFormatValidator implements Validator<ReturnSwapNotionalAmountReference> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapNotionalAmountReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapNotionalAmountReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapNotionalAmountReference", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnSwapNotionalAmountReference", path, "", res.getError());
				}
				return success("ReturnSwapNotionalAmountReference", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnSwapNotionalAmountReference", path, "");
			})
			.collect(toList());
	}

}
