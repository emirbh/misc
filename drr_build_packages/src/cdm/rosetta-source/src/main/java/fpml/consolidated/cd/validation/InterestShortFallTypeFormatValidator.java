package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.InterestShortFall;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestShortFallTypeFormatValidator implements Validator<InterestShortFall> {

	private List<ComparisonResult> getComparisonResults(InterestShortFall o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestShortFall o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestShortFall", ValidationResult.ValidationType.TYPE_FORMAT, "InterestShortFall", path, "", res.getError());
				}
				return success("InterestShortFall", ValidationResult.ValidationType.TYPE_FORMAT, "InterestShortFall", path, "");
			})
			.collect(toList());
	}

}
