package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.RollFeature;
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

public class RollFeatureTypeFormatValidator implements Validator<RollFeature> {

	private List<ComparisonResult> getComparisonResults(RollFeature o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RollFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RollFeature", ValidationResult.ValidationType.TYPE_FORMAT, "RollFeature", path, "", res.getError());
				}
				return success("RollFeature", ValidationResult.ValidationType.TYPE_FORMAT, "RollFeature", path, "");
			})
			.collect(toList());
	}

}
