package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestLegResetDatesTypeFormatValidator implements Validator<InterestLegResetDates> {

	private List<ComparisonResult> getComparisonResults(InterestLegResetDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegResetDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLegResetDates", ValidationResult.ValidationType.TYPE_FORMAT, "InterestLegResetDates", path, "", res.getError());
				}
				return success("InterestLegResetDates", ValidationResult.ValidationType.TYPE_FORMAT, "InterestLegResetDates", path, "");
			})
			.collect(toList());
	}

}
