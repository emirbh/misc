package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetIdentifierValidator implements Validator<AssetIdentifier> {

	private List<ComparisonResult> getComparisonResults(AssetIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (FieldWithMetaString) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("identifierType", (AssetIdTypeEnum) o.getIdentifierType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetIdentifier", ValidationResult.ValidationType.CARDINALITY, "AssetIdentifier", path, "", res.getError());
				}
				return success("AssetIdentifier", ValidationResult.ValidationType.CARDINALITY, "AssetIdentifier", path, "");
			})
			.collect(toList());
	}

}
