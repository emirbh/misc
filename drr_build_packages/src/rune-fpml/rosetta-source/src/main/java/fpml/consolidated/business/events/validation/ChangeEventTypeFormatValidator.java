package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ChangeEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ChangeEventTypeFormatValidator implements Validator<ChangeEvent> {

	private List<ComparisonResult> getComparisonResults(ChangeEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ChangeEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ChangeEvent", ValidationResult.ValidationType.TYPE_FORMAT, "ChangeEvent", path, "", res.getError());
				}
				return success("ChangeEvent", ValidationResult.ValidationType.TYPE_FORMAT, "ChangeEvent", path, "");
			})
			.collect(toList());
	}

}
