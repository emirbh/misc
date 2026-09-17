package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.ElectricityPhysicalQuantity;
import fpml.consolidated.com.UnitQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalQuantityValidator implements Validator<ElectricityPhysicalQuantity> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalPhysicalQuantity", (UnitQuantity) o.getTotalPhysicalQuantity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalQuantity", ValidationResult.ValidationType.CARDINALITY, "ElectricityPhysicalQuantity", path, "", res.getError());
				}
				return success("ElectricityPhysicalQuantity", ValidationResult.ValidationType.CARDINALITY, "ElectricityPhysicalQuantity", path, "");
			})
			.collect(toList());
	}

}
