package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.GasProduct;
import fpml.consolidated.com.GasQuality;
import fpml.consolidated.fpmlenum.GasProductTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GasProductValidator implements Validator<GasProduct> {

	private List<ComparisonResult> getComparisonResults(GasProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (GasProductTypeEnum) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("calorificValue", (BigDecimal) o.getCalorificValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("quality", (GasQuality) o.getQuality() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasProduct", ValidationResult.ValidationType.CARDINALITY, "GasProduct", path, "", res.getError());
				}
				return success("GasProduct", ValidationResult.ValidationType.CARDINALITY, "GasProduct", path, "");
			})
			.collect(toList());
	}

}
