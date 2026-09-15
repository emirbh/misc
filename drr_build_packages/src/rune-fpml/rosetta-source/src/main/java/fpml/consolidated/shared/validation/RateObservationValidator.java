package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FallbackRateObservation;
import fpml.consolidated.shared.RateObservation;
import fpml.consolidated.shared.RateReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RateObservationValidator implements Validator<RateObservation> {

	private List<ComparisonResult> getComparisonResults(RateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetDate", (ZonedDateTime) o.getResetDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedFixingDate", (ZonedDateTime) o.getAdjustedFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observedRate", (BigDecimal) o.getObservedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("treatedRate", (BigDecimal) o.getTreatedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationWeight", (Integer) o.getObservationWeight() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateReference", (RateReference) o.getRateReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("forecastRate", (BigDecimal) o.getForecastRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("treatedForecastRate", (BigDecimal) o.getTreatedForecastRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallback", (FallbackRateObservation) o.getFallback() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RateObservation", ValidationResult.ValidationType.CARDINALITY, "RateObservation", path, "", res.getError());
				}
				return success("RateObservation", ValidationResult.ValidationType.CARDINALITY, "RateObservation", path, "");
			})
			.collect(toList());
	}

}
