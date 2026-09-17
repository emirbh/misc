package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxOptionFeatures;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxOptionFeaturesTypeFormatValidator implements Validator<FxOptionFeatures> {

	private List<ComparisonResult> getComparisonResults(FxOptionFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOptionFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOptionFeatures", ValidationResult.ValidationType.TYPE_FORMAT, "FxOptionFeatures", path, "", res.getError());
				}
				return success("FxOptionFeatures", ValidationResult.ValidationType.TYPE_FORMAT, "FxOptionFeatures", path, "");
			})
			.collect(toList());
	}

}
