package cdm.event.workflow.validation;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EventTimestampValidator implements Validator<EventTimestamp> {

	private List<ComparisonResult> getComparisonResults(EventTimestamp o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateTime", (ZonedDateTime) o.getDateTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("qualification", (EventTimestampQualificationEnum) o.getQualification() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventTimestamp o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventTimestamp", ValidationResult.ValidationType.CARDINALITY, "EventTimestamp", path, "", res.getError());
				}
				return success("EventTimestamp", ValidationResult.ValidationType.CARDINALITY, "EventTimestamp", path, "");
			})
			.collect(toList());
	}

}
