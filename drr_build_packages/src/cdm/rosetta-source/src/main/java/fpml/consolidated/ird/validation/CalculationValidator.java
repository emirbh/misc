package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.Discounting;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.FutureValueAmount;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationValidator implements Validator<Calculation> {

	private List<ComparisonResult> getComparisonResults(Calculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalSchedule", (Notional) o.getNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxLinkedNotionalSchedule", (FxLinkedNotionalSchedule) o.getFxLinkedNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("currentNotional", (Money) o.getCurrentNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRateSchedule", (Schedule) o.getFixedRateSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("futureValueNotional", (FutureValueAmount) o.getFutureValueNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateCalculation", (Rate) o.getRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("discounting", (Discounting) o.getDiscounting() != null ? 1 : 0, 0, 1), 
				checkCardinality("compoundingMethod", (CompoundingMethodEnum) o.getCompoundingMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Calculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Calculation", ValidationResult.ValidationType.CARDINALITY, "Calculation", path, "", res.getError());
				}
				return success("Calculation", ValidationResult.ValidationType.CARDINALITY, "Calculation", path, "");
			})
			.collect(toList());
	}

}
