package cdm.event.workflow.validation;

import cdm.event.workflow.EventInstruction;
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

public class EventInstructionTypeFormatValidator implements Validator<EventInstruction> {

	private List<ComparisonResult> getComparisonResults(EventInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "EventInstruction", path, "", res.getError());
				}
				return success("EventInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "EventInstruction", path, "");
			})
			.collect(toList());
	}

}
