package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
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

public class ProductIdentifierValidator implements Validator<ProductIdentifier> {

	private List<ComparisonResult> getComparisonResults(ProductIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (FieldWithMetaString) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("source", (ProductIdTypeEnum) o.getSource() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductIdentifier", ValidationResult.ValidationType.CARDINALITY, "ProductIdentifier", path, "", res.getError());
				}
				return success("ProductIdentifier", ValidationResult.ValidationType.CARDINALITY, "ProductIdentifier", path, "");
			})
			.collect(toList());
	}

}
