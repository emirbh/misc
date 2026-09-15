package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ServiceProcessingCycle;
import fpml.consolidated.msg.ServiceProcessingEvent;
import fpml.consolidated.msg.ServiceProcessingStatus;
import fpml.consolidated.msg.ServiceProcessingStep;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ServiceProcessingStatusValidator implements Validator<ServiceProcessingStatus> {

	private List<ComparisonResult> getComparisonResults(ServiceProcessingStatus o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cycle", (ServiceProcessingCycle) o.getCycle() != null ? 1 : 0, 0, 1), 
				checkCardinality("step", (ServiceProcessingStep) o.getStep() != null ? 1 : 0, 0, 1), 
				checkCardinality("event", (ServiceProcessingEvent) o.getEvent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceProcessingStatus o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ServiceProcessingStatus", ValidationResult.ValidationType.CARDINALITY, "ServiceProcessingStatus", path, "", res.getError());
				}
				return success("ServiceProcessingStatus", ValidationResult.ValidationType.CARDINALITY, "ServiceProcessingStatus", path, "");
			})
			.collect(toList());
	}

}
