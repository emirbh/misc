package fpml.consolidated.variance.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.Variance;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.variance.swaps.VarianceAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VarianceAmountValidator implements Validator<VarianceAmount> {

	private List<ComparisonResult> getComparisonResults(VarianceAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartDate", (AdjustableOrRelativeDate) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsExchangeDividends", (Boolean) o.getOptionsExchangeDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalDividends", (Boolean) o.getAdditionalDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("allDividends", (Boolean) o.getAllDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("variance", (Variance) o.getVariance() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceAmount", ValidationResult.ValidationType.CARDINALITY, "VarianceAmount", path, "", res.getError());
				}
				return success("VarianceAmount", ValidationResult.ValidationType.CARDINALITY, "VarianceAmount", path, "");
			})
			.collect(toList());
	}

}
