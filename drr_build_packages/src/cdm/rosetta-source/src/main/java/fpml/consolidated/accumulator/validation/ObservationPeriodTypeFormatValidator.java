package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.ObservationPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ObservationPeriodTypeFormatValidator implements Validator<ObservationPeriod> {

	private List<ComparisonResult> getComparisonResults(ObservationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("observationPeriodNoOfTradingDays", o.getObservationPeriodNoOfTradingDays(), empty(), of(0), empty(), empty()), 
				checkNumber("noOfScheduledTradingDays", o.getNoOfScheduledTradingDays(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "ObservationPeriod", path, "", res.getError());
				}
				return success("ObservationPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "ObservationPeriod", path, "");
			})
			.collect(toList());
	}

}
