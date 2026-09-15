package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.ElectricityDeliveryFirm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliveryFirmTypeFormatValidator implements Validator<ElectricityDeliveryFirm> {

	private List<ComparisonResult> getComparisonResults(ElectricityDeliveryFirm o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliveryFirm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDeliveryFirm", ValidationResult.ValidationType.TYPE_FORMAT, "ElectricityDeliveryFirm", path, "", res.getError());
				}
				return success("ElectricityDeliveryFirm", ValidationResult.ValidationType.TYPE_FORMAT, "ElectricityDeliveryFirm", path, "");
			})
			.collect(toList());
	}

}
