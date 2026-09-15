package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FallbackRateObservation;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FallbackRateObservationValidator implements Validator<FallbackRateObservation> {

	private List<ComparisonResult> getComparisonResults(FallbackRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationDate", (ZonedDateTime) o.getObservationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("availableRecordDate", (ZonedDateTime) o.getAvailableRecordDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FallbackRateObservation", ValidationResult.ValidationType.CARDINALITY, "FallbackRateObservation", path, "", res.getError());
				}
				return success("FallbackRateObservation", ValidationResult.ValidationType.CARDINALITY, "FallbackRateObservation", path, "");
			})
			.collect(toList());
	}

}
