package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.EarlyTerminationEvent;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EarlyTerminationEventValidator implements Validator<EarlyTerminationEvent> {

	private List<ComparisonResult> getComparisonResults(EarlyTerminationEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedExerciseDate", (ZonedDateTime) o.getAdjustedExerciseDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedEarlyTerminationDate", (ZonedDateTime) o.getAdjustedEarlyTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedCashSettlementValuationDate", (ZonedDateTime) o.getAdjustedCashSettlementValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedCashSettlementPaymentDate", (ZonedDateTime) o.getAdjustedCashSettlementPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedExerciseFeePaymentDate", (ZonedDateTime) o.getAdjustedExerciseFeePaymentDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EarlyTerminationEvent", ValidationResult.ValidationType.CARDINALITY, "EarlyTerminationEvent", path, "", res.getError());
				}
				return success("EarlyTerminationEvent", ValidationResult.ValidationType.CARDINALITY, "EarlyTerminationEvent", path, "");
			})
			.collect(toList());
	}

}
