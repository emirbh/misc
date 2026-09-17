package cdm.product.template.validation;

import cdm.product.template.AssetPayout;
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

public class AssetPayoutTypeFormatValidator implements Validator<AssetPayout> {

	private List<ComparisonResult> getComparisonResults(AssetPayout o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetPayout", ValidationResult.ValidationType.TYPE_FORMAT, "AssetPayout", path, "", res.getError());
				}
				return success("AssetPayout", ValidationResult.ValidationType.TYPE_FORMAT, "AssetPayout", path, "");
			})
			.collect(toList());
	}

}
