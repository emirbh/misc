package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.ElectricityProduct;
import fpml.consolidated.fpmlenum.ElectricityProductTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityProductValidator implements Validator<ElectricityProduct> {

	private List<ComparisonResult> getComparisonResults(ElectricityProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (ElectricityProductTypeEnum) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("voltage", (BigDecimal) o.getVoltage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityProduct", ValidationResult.ValidationType.CARDINALITY, "ElectricityProduct", path, "", res.getError());
				}
				return success("ElectricityProduct", ValidationResult.ValidationType.CARDINALITY, "ElectricityProduct", path, "");
			})
			.collect(toList());
	}

}
