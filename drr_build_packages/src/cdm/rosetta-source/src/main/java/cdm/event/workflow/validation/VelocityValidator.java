package cdm.event.workflow.validation;

import cdm.base.datetime.PeriodTimeEnum;
import cdm.event.workflow.Velocity;
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

public class VelocityValidator implements Validator<Velocity> {

	private List<ComparisonResult> getComparisonResults(Velocity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("period", (PeriodTimeEnum) o.getPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Velocity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Velocity", ValidationResult.ValidationType.CARDINALITY, "Velocity", path, "", res.getError());
				}
				return success("Velocity", ValidationResult.ValidationType.CARDINALITY, "Velocity", path, "");
			})
			.collect(toList());
	}

}
