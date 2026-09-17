package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnSwapBaseTypeFormatValidator implements Validator<ReturnSwapBase> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapBase", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnSwapBase", path, "", res.getError());
				}
				return success("ReturnSwapBase", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnSwapBase", path, "");
			})
			.collect(toList());
	}

}
