package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsTypeFormatValidator implements Validator<OptionExerciseAmounts> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmounts", ValidationResult.ValidationType.TYPE_FORMAT, "OptionExerciseAmounts", path, "", res.getError());
				}
				return success("OptionExerciseAmounts", ValidationResult.ValidationType.TYPE_FORMAT, "OptionExerciseAmounts", path, "");
			})
			.collect(toList());
	}

}
