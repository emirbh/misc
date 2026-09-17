package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustableOrAdjustedOrRelativeDateTypeFormatValidator implements Validator<AdjustableOrAdjustedOrRelativeDate> {

	private List<ComparisonResult> getComparisonResults(AdjustableOrAdjustedOrRelativeDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrAdjustedOrRelativeDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableOrAdjustedOrRelativeDate", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustableOrAdjustedOrRelativeDate", path, "", res.getError());
				}
				return success("AdjustableOrAdjustedOrRelativeDate", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustableOrAdjustedOrRelativeDate", path, "");
			})
			.collect(toList());
	}

}
