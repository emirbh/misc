package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.TaskId;
import fpml.consolidated.loan.TaskIdentifier;
import fpml.consolidated.loan.VersionedTaskId;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TaskIdentifierValidator implements Validator<TaskIdentifier> {

	private List<ComparisonResult> getComparisonResults(TaskIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("taskId", (TaskId) o.getTaskId() != null ? 1 : 0, 0, 1), 
				checkCardinality("versionedTaskId", (VersionedTaskId) o.getVersionedTaskId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaskIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TaskIdentifier", ValidationResult.ValidationType.CARDINALITY, "TaskIdentifier", path, "", res.getError());
				}
				return success("TaskIdentifier", ValidationResult.ValidationType.CARDINALITY, "TaskIdentifier", path, "");
			})
			.collect(toList());
	}

}
