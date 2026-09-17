package cdm.observable.asset.validation;

import cdm.observable.asset.ReferenceSwapCurve;
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

public class ReferenceSwapCurveTypeFormatValidator implements Validator<ReferenceSwapCurve> {

	private List<ComparisonResult> getComparisonResults(ReferenceSwapCurve o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceSwapCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceSwapCurve", ValidationResult.ValidationType.TYPE_FORMAT, "ReferenceSwapCurve", path, "", res.getError());
				}
				return success("ReferenceSwapCurve", ValidationResult.ValidationType.TYPE_FORMAT, "ReferenceSwapCurve", path, "");
			})
			.collect(toList());
	}

}
