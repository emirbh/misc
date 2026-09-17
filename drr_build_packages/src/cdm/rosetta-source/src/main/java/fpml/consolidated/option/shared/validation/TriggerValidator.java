package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.TriggerTimeTypeEnum;
import fpml.consolidated.fpmlenum.TriggerTypeEnum;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.option.shared.CreditEventsReference;
import fpml.consolidated.option.shared.Trigger;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TriggerValidator implements Validator<Trigger> {

	private List<ComparisonResult> getComparisonResults(Trigger o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("level", (BigDecimal) o.getLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelPercentage", (BigDecimal) o.getLevelPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEvents", (CreditEvents) o.getCreditEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEventsReference", (CreditEventsReference) o.getCreditEventsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerType", (TriggerTypeEnum) o.getTriggerType() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerTimeType", (TriggerTimeTypeEnum) o.getTriggerTimeType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trigger o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Trigger", ValidationResult.ValidationType.CARDINALITY, "Trigger", path, "", res.getError());
				}
				return success("Trigger", ValidationResult.ValidationType.CARDINALITY, "Trigger", path, "");
			})
			.collect(toList());
	}

}
