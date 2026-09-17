package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.CompoundingFrequency;
import fpml.consolidated.mktenv.TermCurve;
import fpml.consolidated.mktenv.ZeroRateCurve;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ZeroRateCurveValidator implements Validator<ZeroRateCurve> {

	private List<ComparisonResult> getComparisonResults(ZeroRateCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("compoundingFrequency", (CompoundingFrequency) o.getCompoundingFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateCurve", (TermCurve) o.getRateCurve() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ZeroRateCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ZeroRateCurve", ValidationResult.ValidationType.CARDINALITY, "ZeroRateCurve", path, "", res.getError());
				}
				return success("ZeroRateCurve", ValidationResult.ValidationType.CARDINALITY, "ZeroRateCurve", path, "");
			})
			.collect(toList());
	}

}
