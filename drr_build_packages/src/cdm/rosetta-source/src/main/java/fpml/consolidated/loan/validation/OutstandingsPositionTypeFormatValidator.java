package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.OutstandingsPosition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OutstandingsPositionTypeFormatValidator implements Validator<OutstandingsPosition> {

	private List<ComparisonResult> getComparisonResults(OutstandingsPosition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingsPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OutstandingsPosition", ValidationResult.ValidationType.TYPE_FORMAT, "OutstandingsPosition", path, "", res.getError());
				}
				return success("OutstandingsPosition", ValidationResult.ValidationType.TYPE_FORMAT, "OutstandingsPosition", path, "");
			})
			.collect(toList());
	}

}
