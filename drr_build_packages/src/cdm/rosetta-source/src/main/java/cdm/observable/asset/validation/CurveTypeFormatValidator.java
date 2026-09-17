package cdm.observable.asset.validation;

import cdm.observable.asset.Curve;
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

public class CurveTypeFormatValidator implements Validator<Curve> {

	private List<ComparisonResult> getComparisonResults(Curve o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Curve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Curve", ValidationResult.ValidationType.TYPE_FORMAT, "Curve", path, "", res.getError());
				}
				return success("Curve", ValidationResult.ValidationType.TYPE_FORMAT, "Curve", path, "");
			})
			.collect(toList());
	}

}
