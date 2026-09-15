package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AnyAssetReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnyAssetReferenceTypeFormatValidator implements Validator<AnyAssetReference> {

	private List<ComparisonResult> getComparisonResults(AnyAssetReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnyAssetReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnyAssetReference", ValidationResult.ValidationType.TYPE_FORMAT, "AnyAssetReference", path, "", res.getError());
				}
				return success("AnyAssetReference", ValidationResult.ValidationType.TYPE_FORMAT, "AnyAssetReference", path, "");
			})
			.collect(toList());
	}

}
