package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.EventStatusItem;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EventStatusItemTypeFormatValidator implements Validator<EventStatusItem> {

	private List<ComparisonResult> getComparisonResults(EventStatusItem o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventStatusItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventStatusItem", ValidationResult.ValidationType.TYPE_FORMAT, "EventStatusItem", path, "", res.getError());
				}
				return success("EventStatusItem", ValidationResult.ValidationType.TYPE_FORMAT, "EventStatusItem", path, "");
			})
			.collect(toList());
	}

}
