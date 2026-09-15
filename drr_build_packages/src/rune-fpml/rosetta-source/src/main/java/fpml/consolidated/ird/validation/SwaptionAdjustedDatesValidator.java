package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.SwaptionAdjustedDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SwaptionAdjustedDatesValidator implements Validator<SwaptionAdjustedDates> {

	private List<ComparisonResult> getComparisonResults(SwaptionAdjustedDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwaptionAdjustedDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SwaptionAdjustedDates", ValidationResult.ValidationType.CARDINALITY, "SwaptionAdjustedDates", path, "", res.getError());
				}
				return success("SwaptionAdjustedDates", ValidationResult.ValidationType.CARDINALITY, "SwaptionAdjustedDates", path, "");
			})
			.collect(toList());
	}

}
