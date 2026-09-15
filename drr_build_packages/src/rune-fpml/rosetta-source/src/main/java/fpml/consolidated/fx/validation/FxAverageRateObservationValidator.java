package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxAverageRateObservation;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAverageRateObservationValidator implements Validator<FxAverageRateObservation> {

	private List<ComparisonResult> getComparisonResults(FxAverageRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageRateWeightingFactor", (BigDecimal) o.getAverageRateWeightingFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAverageRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAverageRateObservation", ValidationResult.ValidationType.CARDINALITY, "FxAverageRateObservation", path, "", res.getError());
				}
				return success("FxAverageRateObservation", ValidationResult.ValidationType.CARDINALITY, "FxAverageRateObservation", path, "");
			})
			.collect(toList());
	}

}
