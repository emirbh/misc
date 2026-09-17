package cdm.product.collateral.validation;

import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AssetAgencyRating;
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

public class AssetAgencyRatingValidator implements Validator<AssetAgencyRating> {

	private List<ComparisonResult> getComparisonResults(AssetAgencyRating o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("assetAgencyRating", (AgencyRatingCriteria) o.getAssetAgencyRating() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetAgencyRating o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetAgencyRating", ValidationResult.ValidationType.CARDINALITY, "AssetAgencyRating", path, "", res.getError());
				}
				return success("AssetAgencyRating", ValidationResult.ValidationType.CARDINALITY, "AssetAgencyRating", path, "");
			})
			.collect(toList());
	}

}
