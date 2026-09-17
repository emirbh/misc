package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.TaskDates;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TaskDatesValidator implements Validator<TaskDates> {

	private List<ComparisonResult> getComparisonResults(TaskDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("raisedDate", (ZonedDateTime) o.getRaisedDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedDate", (ZonedDateTime) o.getExpectedDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearedDate", (ZonedDateTime) o.getClearedDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaskDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TaskDates", ValidationResult.ValidationType.CARDINALITY, "TaskDates", path, "", res.getError());
				}
				return success("TaskDates", ValidationResult.ValidationType.CARDINALITY, "TaskDates", path, "");
			})
			.collect(toList());
	}

}
