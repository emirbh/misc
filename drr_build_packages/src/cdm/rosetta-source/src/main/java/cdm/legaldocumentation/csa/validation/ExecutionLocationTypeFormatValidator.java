package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ExecutionLocation;
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

public class ExecutionLocationTypeFormatValidator implements Validator<ExecutionLocation> {

	private List<ComparisonResult> getComparisonResults(ExecutionLocation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionLocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutionLocation", ValidationResult.ValidationType.TYPE_FORMAT, "ExecutionLocation", path, "", res.getError());
				}
				return success("ExecutionLocation", ValidationResult.ValidationType.TYPE_FORMAT, "ExecutionLocation", path, "");
			})
			.collect(toList());
	}

}
