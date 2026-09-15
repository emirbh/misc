package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ExecutingEntity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExecutingEntityTypeFormatValidator implements Validator<ExecutingEntity> {

	private List<ComparisonResult> getComparisonResults(ExecutingEntity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutingEntity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutingEntity", ValidationResult.ValidationType.TYPE_FORMAT, "ExecutingEntity", path, "", res.getError());
				}
				return success("ExecutingEntity", ValidationResult.ValidationType.TYPE_FORMAT, "ExecutingEntity", path, "");
			})
			.collect(toList());
	}

}
