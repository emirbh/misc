package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EnvironmentalProduct;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnvironmentalProductTypeFormatValidator implements Validator<EnvironmentalProduct> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalProduct o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalProduct", ValidationResult.ValidationType.TYPE_FORMAT, "EnvironmentalProduct", path, "", res.getError());
				}
				return success("EnvironmentalProduct", ValidationResult.ValidationType.TYPE_FORMAT, "EnvironmentalProduct", path, "");
			})
			.collect(toList());
	}

}
