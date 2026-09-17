package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.EventsChoice;
import fpml.consolidated.confirmation.processes.ConfirmationStatus;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.EventStatus;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ConfirmationStatusValidator implements Validator<ConfirmationStatus> {

	private List<ComparisonResult> getComparisonResults(ConfirmationStatus o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (ResponseMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("status", (EventStatus) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("assertedEvent", (EventsChoice) o.getAssertedEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("allegedEvent", (EventsChoice) o.getAllegedEvent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConfirmationStatus o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConfirmationStatus", ValidationResult.ValidationType.CARDINALITY, "ConfirmationStatus", path, "", res.getError());
				}
				return success("ConfirmationStatus", ValidationResult.ValidationType.CARDINALITY, "ConfirmationStatus", path, "");
			})
			.collect(toList());
	}

}
