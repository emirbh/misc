package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
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

public class CollateralTaxonomyValueTypeFormatValidator implements Validator<CollateralTaxonomyValue> {

	private List<ComparisonResult> getComparisonResults(CollateralTaxonomyValue o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomyValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralTaxonomyValue", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralTaxonomyValue", path, "", res.getError());
				}
				return success("CollateralTaxonomyValue", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralTaxonomyValue", path, "");
			})
			.collect(toList());
	}

}
