package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.DeliveryCapacity;
import drr.standards.iso.EnergyQuantityUnit2Code;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DeliveryCapacityValidator implements Validator<DeliveryCapacity> {

	private List<ComparisonResult> getComparisonResults(DeliveryCapacity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("unit", (EnergyQuantityUnit2Code) o.getUnit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryCapacity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeliveryCapacity", ValidationResult.ValidationType.CARDINALITY, "DeliveryCapacity", path, "", res.getError());
				}
				return success("DeliveryCapacity", ValidationResult.ValidationType.CARDINALITY, "DeliveryCapacity", path, "");
			})
			.collect(toList());
	}

}
