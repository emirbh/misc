package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.TermCurve;
import fpml.consolidated.shared.InterpolationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TermCurveValidator implements Validator<TermCurve> {

	private List<ComparisonResult> getComparisonResults(TermCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("extrapolationPermitted", (Boolean) o.getExtrapolationPermitted() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermCurve", ValidationResult.ValidationType.CARDINALITY, "TermCurve", path, "", res.getError());
				}
				return success("TermCurve", ValidationResult.ValidationType.CARDINALITY, "TermCurve", path, "");
			})
			.collect(toList());
	}

}
