package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.ElectricityPhysicalDeliveryQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalDeliveryQuantityTypeFormatValidator implements Validator<ElectricityPhysicalDeliveryQuantity> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalDeliveryQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalDeliveryQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalDeliveryQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "ElectricityPhysicalDeliveryQuantity", path, "", res.getError());
				}
				return success("ElectricityPhysicalDeliveryQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "ElectricityPhysicalDeliveryQuantity", path, "");
			})
			.collect(toList());
	}

}
