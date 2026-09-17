package cdm.product.asset.validation;

import cdm.product.asset.FloatingAmountProvisions;
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

public class FloatingAmountProvisionsTypeFormatValidator implements Validator<FloatingAmountProvisions> {

	private List<ComparisonResult> getComparisonResults(FloatingAmountProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingAmountProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingAmountProvisions", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingAmountProvisions", path, "", res.getError());
				}
				return success("FloatingAmountProvisions", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingAmountProvisions", path, "");
			})
			.collect(toList());
	}

}
