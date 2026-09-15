package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalProduct;
import fpml.consolidated.com.CoalProductSpecifications;
import fpml.consolidated.com.CoalProductType;
import fpml.consolidated.com.CoalQualityAdjustments;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoalProductValidator implements Validator<CoalProduct> {

	private List<ComparisonResult> getComparisonResults(CoalProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (CoalProductType) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("coalProductSpecifications", (CoalProductSpecifications) o.getCoalProductSpecifications() != null ? 1 : 0, 0, 1), 
				checkCardinality("sCoTASpecifications", (Boolean) o.getSCoTASpecifications() != null ? 1 : 0, 0, 1), 
				checkCardinality("btuQualityAdjustment", (CoalQualityAdjustments) o.getBtuQualityAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("so2QualityAdjustment", (CoalQualityAdjustments) o.getSo2QualityAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalProduct", ValidationResult.ValidationType.CARDINALITY, "CoalProduct", path, "", res.getError());
				}
				return success("CoalProduct", ValidationResult.ValidationType.CARDINALITY, "CoalProduct", path, "");
			})
			.collect(toList());
	}

}
