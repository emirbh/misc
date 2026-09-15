package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.ObservationPeriod;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservationPeriodValidator implements Validator<ObservationPeriod> {

	private List<ComparisonResult> getComparisonResults(ObservationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationPeriodStartDate", (ZonedDateTime) o.getObservationPeriodStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationPeriodEndDate", (ZonedDateTime) o.getObservationPeriodEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationPeriodSettlementDate", (ZonedDateTime) o.getObservationPeriodSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationPeriodNoOfTradingDays", (Integer) o.getObservationPeriodNoOfTradingDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("upFrontSettlement", (Boolean) o.getUpFrontSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("noOfScheduledTradingDays", (Integer) o.getNoOfScheduledTradingDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationPeriod", ValidationResult.ValidationType.CARDINALITY, "ObservationPeriod", path, "", res.getError());
				}
				return success("ObservationPeriod", ValidationResult.ValidationType.CARDINALITY, "ObservationPeriod", path, "");
			})
			.collect(toList());
	}

}
