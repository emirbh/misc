package cdm.product.template.validation;

import cdm.product.template.AveragingStrikeFeature;
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

public class AveragingStrikeFeatureTypeFormatValidator implements Validator<AveragingStrikeFeature> {

	private List<ComparisonResult> getComparisonResults(AveragingStrikeFeature o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragingStrikeFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AveragingStrikeFeature", ValidationResult.ValidationType.TYPE_FORMAT, "AveragingStrikeFeature", path, "", res.getError());
				}
				return success("AveragingStrikeFeature", ValidationResult.ValidationType.TYPE_FORMAT, "AveragingStrikeFeature", path, "");
			})
			.collect(toList());
	}

}
