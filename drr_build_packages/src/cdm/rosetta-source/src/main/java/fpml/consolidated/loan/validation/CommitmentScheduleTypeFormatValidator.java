package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.CommitmentSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommitmentScheduleTypeFormatValidator implements Validator<CommitmentSchedule> {

	private List<ComparisonResult> getComparisonResults(CommitmentSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommitmentSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommitmentSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "CommitmentSchedule", path, "", res.getError());
				}
				return success("CommitmentSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "CommitmentSchedule", path, "");
			})
			.collect(toList());
	}

}
