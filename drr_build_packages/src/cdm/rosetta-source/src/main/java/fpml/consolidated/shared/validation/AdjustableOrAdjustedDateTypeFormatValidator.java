package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustableOrAdjustedDateTypeFormatValidator implements Validator<AdjustableOrAdjustedDate> {

	private List<ComparisonResult> getComparisonResults(AdjustableOrAdjustedDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrAdjustedDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableOrAdjustedDate", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustableOrAdjustedDate", path, "", res.getError());
				}
				return success("AdjustableOrAdjustedDate", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustableOrAdjustedDate", path, "");
			})
			.collect(toList());
	}

}
