package cdm.product.asset.validation;

import cdm.product.asset.AssetDeliveryProfile;
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

public class AssetDeliveryProfileTypeFormatValidator implements Validator<AssetDeliveryProfile> {

	private List<ComparisonResult> getComparisonResults(AssetDeliveryProfile o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetDeliveryProfile o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetDeliveryProfile", ValidationResult.ValidationType.TYPE_FORMAT, "AssetDeliveryProfile", path, "", res.getError());
				}
				return success("AssetDeliveryProfile", ValidationResult.ValidationType.TYPE_FORMAT, "AssetDeliveryProfile", path, "");
			})
			.collect(toList());
	}

}
