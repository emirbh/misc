package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.FeaturePayment;
import fpml.consolidated.option.shared.Trigger;
import fpml.consolidated.option.shared.TriggerEvent;
import fpml.consolidated.shared.DateList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TriggerEventValidator implements Validator<TriggerEvent> {

	private List<ComparisonResult> getComparisonResults(TriggerEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triggerDates", (DateList) o.getTriggerDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("trigger", (Trigger) o.getTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("featurePayment", (FeaturePayment) o.getFeaturePayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriggerEvent", ValidationResult.ValidationType.CARDINALITY, "TriggerEvent", path, "", res.getError());
				}
				return success("TriggerEvent", ValidationResult.ValidationType.CARDINALITY, "TriggerEvent", path, "");
			})
			.collect(toList());
	}

}
