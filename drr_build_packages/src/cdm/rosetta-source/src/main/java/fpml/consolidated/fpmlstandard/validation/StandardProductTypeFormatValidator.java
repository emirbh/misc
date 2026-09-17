package fpml.consolidated.fpmlstandard.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlstandard.StandardProduct;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StandardProductTypeFormatValidator implements Validator<StandardProduct> {

	private List<ComparisonResult> getComparisonResults(StandardProduct o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StandardProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StandardProduct", ValidationResult.ValidationType.TYPE_FORMAT, "StandardProduct", path, "", res.getError());
				}
				return success("StandardProduct", ValidationResult.ValidationType.TYPE_FORMAT, "StandardProduct", path, "");
			})
			.collect(toList());
	}

}
