package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.OilDelivery;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OilDeliveryTypeFormatValidator implements Validator<OilDelivery> {

	private List<ComparisonResult> getComparisonResults(OilDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilDelivery", ValidationResult.ValidationType.TYPE_FORMAT, "OilDelivery", path, "", res.getError());
				}
				return success("OilDelivery", ValidationResult.ValidationType.TYPE_FORMAT, "OilDelivery", path, "");
			})
			.collect(toList());
	}

}
