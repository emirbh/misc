package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.EventTimestamps;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EventTimestampsTypeFormatValidator implements Validator<EventTimestamps> {

	private List<ComparisonResult> getComparisonResults(EventTimestamps o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventTimestamps o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventTimestamps", ValidationResult.ValidationType.TYPE_FORMAT, "EventTimestamps", path, "", res.getError());
				}
				return success("EventTimestamps", ValidationResult.ValidationType.TYPE_FORMAT, "EventTimestamps", path, "");
			})
			.collect(toList());
	}

}
