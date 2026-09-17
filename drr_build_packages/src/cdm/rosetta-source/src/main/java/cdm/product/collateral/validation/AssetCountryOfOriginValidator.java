package cdm.product.collateral.validation;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.AssetCountryOfOrigin;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetCountryOfOriginValidator implements Validator<AssetCountryOfOrigin> {

	private List<ComparisonResult> getComparisonResults(AssetCountryOfOrigin o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("assetCountryOfOrigin", (ISOCountryCodeEnum) o.getAssetCountryOfOrigin() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetCountryOfOrigin o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetCountryOfOrigin", ValidationResult.ValidationType.CARDINALITY, "AssetCountryOfOrigin", path, "", res.getError());
				}
				return success("AssetCountryOfOrigin", ValidationResult.ValidationType.CARDINALITY, "AssetCountryOfOrigin", path, "");
			})
			.collect(toList());
	}

}
