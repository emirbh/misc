package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.confirmation.processes.Clearing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingTypeFormatValidator implements Validator<Clearing> {

	private List<ComparisonResult> getComparisonResults(Clearing o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Clearing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Clearing", ValidationResult.ValidationType.TYPE_FORMAT, "Clearing", path, "", res.getError());
				}
				return success("Clearing", ValidationResult.ValidationType.TYPE_FORMAT, "Clearing", path, "");
			})
			.collect(toList());
	}

}
