package cdm.event.workflow.validation;

import cdm.event.workflow.WorkflowState;
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

public class WorkflowStateTypeFormatValidator implements Validator<WorkflowState> {

	private List<ComparisonResult> getComparisonResults(WorkflowState o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WorkflowState o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WorkflowState", ValidationResult.ValidationType.TYPE_FORMAT, "WorkflowState", path, "", res.getError());
				}
				return success("WorkflowState", ValidationResult.ValidationType.TYPE_FORMAT, "WorkflowState", path, "");
			})
			.collect(toList());
	}

}
