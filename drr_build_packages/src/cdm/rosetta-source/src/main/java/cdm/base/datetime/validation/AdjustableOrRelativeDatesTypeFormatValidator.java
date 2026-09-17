package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustableOrRelativeDates;
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

public class AdjustableOrRelativeDatesTypeFormatValidator implements Validator<AdjustableOrRelativeDates> {

	private List<ComparisonResult> getComparisonResults(AdjustableOrRelativeDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrRelativeDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableOrRelativeDates", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustableOrRelativeDates", path, "", res.getError());
				}
				return success("AdjustableOrRelativeDates", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustableOrRelativeDates", path, "");
			})
			.collect(toList());
	}

}
