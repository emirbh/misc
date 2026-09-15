package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.EventPaymentSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EventPaymentSequenceValidator implements Validator<EventPaymentSequence> {

	private List<ComparisonResult> getComparisonResults(EventPaymentSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (BusinessEventIdentifier) o.getEventIdentifier() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventPaymentSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventPaymentSequence", ValidationResult.ValidationType.CARDINALITY, "EventPaymentSequence", path, "", res.getError());
				}
				return success("EventPaymentSequence", ValidationResult.ValidationType.CARDINALITY, "EventPaymentSequence", path, "");
			})
			.collect(toList());
	}

}
