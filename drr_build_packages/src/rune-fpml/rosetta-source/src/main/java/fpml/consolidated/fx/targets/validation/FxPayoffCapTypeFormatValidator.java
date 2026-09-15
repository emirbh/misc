package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxPayoffCap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxPayoffCapTypeFormatValidator implements Validator<FxPayoffCap> {

	private List<ComparisonResult> getComparisonResults(FxPayoffCap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPayoffCap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPayoffCap", ValidationResult.ValidationType.TYPE_FORMAT, "FxPayoffCap", path, "", res.getError());
				}
				return success("FxPayoffCap", ValidationResult.ValidationType.TYPE_FORMAT, "FxPayoffCap", path, "");
			})
			.collect(toList());
	}

}
