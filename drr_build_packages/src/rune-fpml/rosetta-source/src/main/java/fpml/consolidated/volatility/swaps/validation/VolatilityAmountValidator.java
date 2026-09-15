package fpml.consolidated.volatility.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.volatility.swaps.Volatility;
import fpml.consolidated.volatility.swaps.VolatilityAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilityAmountValidator implements Validator<VolatilityAmount> {

	private List<ComparisonResult> getComparisonResults(VolatilityAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartDate", (AdjustableOrRelativeDate) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsExchangeDividends", (Boolean) o.getOptionsExchangeDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalDividends", (Boolean) o.getAdditionalDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("allDividends", (Boolean) o.getAllDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatility", (Volatility) o.getVolatility() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityAmount", ValidationResult.ValidationType.CARDINALITY, "VolatilityAmount", path, "", res.getError());
				}
				return success("VolatilityAmount", ValidationResult.ValidationType.CARDINALITY, "VolatilityAmount", path, "");
			})
			.collect(toList());
	}

}
