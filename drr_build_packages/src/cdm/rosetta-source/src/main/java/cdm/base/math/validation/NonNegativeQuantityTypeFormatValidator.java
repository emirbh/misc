package cdm.base.math.validation;

import cdm.base.math.NonNegativeQuantity;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonNegativeQuantityTypeFormatValidator implements Validator<NonNegativeQuantity> {

	private List<ComparisonResult> getComparisonResults(NonNegativeQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonNegativeQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "NonNegativeQuantity", path, "", res.getError());
				}
				return success("NonNegativeQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "NonNegativeQuantity", path, "");
			})
			.collect(toList());
	}

}
