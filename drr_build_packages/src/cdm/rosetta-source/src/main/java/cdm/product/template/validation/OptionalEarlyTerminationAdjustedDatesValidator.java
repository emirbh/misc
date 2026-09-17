package cdm.product.template.validation;

import cdm.product.template.EarlyTerminationEvent;
import cdm.product.template.OptionalEarlyTerminationAdjustedDates;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionalEarlyTerminationAdjustedDatesValidator implements Validator<OptionalEarlyTerminationAdjustedDates> {

	private List<ComparisonResult> getComparisonResults(OptionalEarlyTerminationAdjustedDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("earlyTerminationEvent", (List<? extends EarlyTerminationEvent>) o.getEarlyTerminationEvent() == null ? 0 : o.getEarlyTerminationEvent().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionalEarlyTerminationAdjustedDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionalEarlyTerminationAdjustedDates", ValidationResult.ValidationType.CARDINALITY, "OptionalEarlyTerminationAdjustedDates", path, "", res.getError());
				}
				return success("OptionalEarlyTerminationAdjustedDates", ValidationResult.ValidationType.CARDINALITY, "OptionalEarlyTerminationAdjustedDates", path, "");
			})
			.collect(toList());
	}

}
