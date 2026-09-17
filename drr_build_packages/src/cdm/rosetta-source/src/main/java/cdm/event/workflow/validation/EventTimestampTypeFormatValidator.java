package cdm.event.workflow.validation;

import cdm.event.workflow.EventTimestamp;
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

public class EventTimestampTypeFormatValidator implements Validator<EventTimestamp> {

	private List<ComparisonResult> getComparisonResults(EventTimestamp o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventTimestamp o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventTimestamp", ValidationResult.ValidationType.TYPE_FORMAT, "EventTimestamp", path, "", res.getError());
				}
				return success("EventTimestamp", ValidationResult.ValidationType.TYPE_FORMAT, "EventTimestamp", path, "");
			})
			.collect(toList());
	}

}
