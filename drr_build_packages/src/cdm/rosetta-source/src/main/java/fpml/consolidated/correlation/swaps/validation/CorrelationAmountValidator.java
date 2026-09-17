package fpml.consolidated.correlation.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.correlation.swaps.CorrelationAmount;
import fpml.consolidated.eq.shared.Correlation;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CorrelationAmountValidator implements Validator<CorrelationAmount> {

	private List<ComparisonResult> getComparisonResults(CorrelationAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartDate", (AdjustableOrRelativeDate) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsExchangeDividends", (Boolean) o.getOptionsExchangeDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalDividends", (Boolean) o.getAdditionalDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("allDividends", (Boolean) o.getAllDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlation", (Correlation) o.getCorrelation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationAmount", ValidationResult.ValidationType.CARDINALITY, "CorrelationAmount", path, "", res.getError());
				}
				return success("CorrelationAmount", ValidationResult.ValidationType.CARDINALITY, "CorrelationAmount", path, "");
			})
			.collect(toList());
	}

}
