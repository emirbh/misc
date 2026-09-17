package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.NumberOfOptionsReference;
import fpml.consolidated.shared.NumberOfUnitsReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsValidator implements Validator<OptionExerciseAmounts> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalReference", (NotionalReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNotionalAmount", (Money) o.getExerciseInNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNotionalAmount", (Money) o.getOutstandingNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalScheduleReference", (NotionalReference) o.getNotionalScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNotionalSchedule", (NonNegativeAmountSchedule) o.getExerciseInNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNotionalSchedule", (NonNegativeAmountSchedule) o.getOutstandingNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfOptionsReference", (NumberOfOptionsReference) o.getNumberOfOptionsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNumberOfOptions", (BigDecimal) o.getExerciseInNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfOptions", (BigDecimal) o.getOutstandingNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfUnitsReference", (NumberOfUnitsReference) o.getNumberOfUnitsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNumberOfUnits", (BigDecimal) o.getExerciseInNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfUnits", (BigDecimal) o.getOutstandingNumberOfUnits() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmounts", ValidationResult.ValidationType.CARDINALITY, "OptionExerciseAmounts", path, "", res.getError());
				}
				return success("OptionExerciseAmounts", ValidationResult.ValidationType.CARDINALITY, "OptionExerciseAmounts", path, "");
			})
			.collect(toList());
	}

}
