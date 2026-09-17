package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityNotificationChoice1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FacilityNotificationChoice1TypeFormatValidator implements Validator<FacilityNotificationChoice1> {

	private List<ComparisonResult> getComparisonResults(FacilityNotificationChoice1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityNotificationChoice1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityNotificationChoice1", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityNotificationChoice1", path, "", res.getError());
				}
				return success("FacilityNotificationChoice1", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityNotificationChoice1", path, "");
			})
			.collect(toList());
	}

}
