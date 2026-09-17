package cdm.base.math.validation;

import cdm.base.datetime.Frequency;
import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonNegativeQuantityScheduleValidator implements Validator<NonNegativeQuantitySchedule> {

	private List<ComparisonResult> getComparisonResults(NonNegativeQuantitySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("unit", (UnitType) o.getUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (Measure) o.getMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("frequency", (Frequency) o.getFrequency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeQuantitySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonNegativeQuantitySchedule", ValidationResult.ValidationType.CARDINALITY, "NonNegativeQuantitySchedule", path, "", res.getError());
				}
				return success("NonNegativeQuantitySchedule", ValidationResult.ValidationType.CARDINALITY, "NonNegativeQuantitySchedule", path, "");
			})
			.collect(toList());
	}

}
