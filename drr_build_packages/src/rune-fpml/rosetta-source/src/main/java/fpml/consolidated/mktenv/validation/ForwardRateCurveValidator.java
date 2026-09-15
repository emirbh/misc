package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.mktenv.ForwardRateCurve;
import fpml.consolidated.mktenv.TermCurve;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ForwardRateCurveValidator implements Validator<ForwardRateCurve> {

	private List<ComparisonResult> getComparisonResults(ForwardRateCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("assetReference", (AssetReference) o.getAssetReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateCurve", (TermCurve) o.getRateCurve() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ForwardRateCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ForwardRateCurve", ValidationResult.ValidationType.CARDINALITY, "ForwardRateCurve", path, "", res.getError());
				}
				return success("ForwardRateCurve", ValidationResult.ValidationType.CARDINALITY, "ForwardRateCurve", path, "");
			})
			.collect(toList());
	}

}
