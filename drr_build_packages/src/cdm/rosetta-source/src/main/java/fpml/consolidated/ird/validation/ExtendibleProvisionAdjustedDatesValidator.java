package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ExtendibleProvisionAdjustedDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExtendibleProvisionAdjustedDatesValidator implements Validator<ExtendibleProvisionAdjustedDates> {

	private List<ComparisonResult> getComparisonResults(ExtendibleProvisionAdjustedDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtendibleProvisionAdjustedDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExtendibleProvisionAdjustedDates", ValidationResult.ValidationType.CARDINALITY, "ExtendibleProvisionAdjustedDates", path, "", res.getError());
				}
				return success("ExtendibleProvisionAdjustedDates", ValidationResult.ValidationType.CARDINALITY, "ExtendibleProvisionAdjustedDates", path, "");
			})
			.collect(toList());
	}

}
