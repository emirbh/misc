package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityProductGrade;
import fpml.consolidated.com.OilProduct;
import fpml.consolidated.com.OilProductType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OilProductValidator implements Validator<OilProduct> {

	private List<ComparisonResult> getComparisonResults(OilProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (OilProductType) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("grade", (CommodityProductGrade) o.getGrade() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilProduct", ValidationResult.ValidationType.CARDINALITY, "OilProduct", path, "", res.getError());
				}
				return success("OilProduct", ValidationResult.ValidationType.CARDINALITY, "OilProduct", path, "");
			})
			.collect(toList());
	}

}
