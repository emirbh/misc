package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
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

public class CollateralTaxonomyValidator implements Validator<CollateralTaxonomy> {

	private List<ComparisonResult> getComparisonResults(CollateralTaxonomy o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("taxonomyValue", (CollateralTaxonomyValue) o.getTaxonomyValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("taxonomySource", (TaxonomySourceEnum) o.getTaxonomySource() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomy o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralTaxonomy", ValidationResult.ValidationType.CARDINALITY, "CollateralTaxonomy", path, "", res.getError());
				}
				return success("CollateralTaxonomy", ValidationResult.ValidationType.CARDINALITY, "CollateralTaxonomy", path, "");
			})
			.collect(toList());
	}

}
