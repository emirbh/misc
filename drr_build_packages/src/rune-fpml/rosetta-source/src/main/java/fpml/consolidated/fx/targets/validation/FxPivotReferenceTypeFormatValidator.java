package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxPivotReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxPivotReferenceTypeFormatValidator implements Validator<FxPivotReference> {

	private List<ComparisonResult> getComparisonResults(FxPivotReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPivotReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPivotReference", ValidationResult.ValidationType.TYPE_FORMAT, "FxPivotReference", path, "", res.getError());
				}
				return success("FxPivotReference", ValidationResult.ValidationType.TYPE_FORMAT, "FxPivotReference", path, "");
			})
			.collect(toList());
	}

}
