package cdm.product.asset.validation;

import cdm.product.asset.FloatingRate;
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

public class FloatingRateTypeFormatValidator implements Validator<FloatingRate> {

	private List<ComparisonResult> getComparisonResults(FloatingRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRate", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRate", path, "", res.getError());
				}
				return success("FloatingRate", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRate", path, "");
			})
			.collect(toList());
	}

}
